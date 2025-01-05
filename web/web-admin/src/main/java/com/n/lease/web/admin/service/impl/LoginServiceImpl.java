package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.n.lease.common.constant.RedisConstant;
import com.n.lease.common.exception.LeaseException;
import com.n.lease.common.result.ResultCodeEnum;
import com.n.lease.common.utils.JwtUtil;
import com.n.lease.model.entity.SystemUser;
import com.n.lease.model.enums.BaseStatus;
import com.n.lease.web.admin.mapper.SystemUserMapper;
import com.n.lease.web.admin.service.LoginService;
import com.n.lease.web.admin.vo.login.CaptchaVo;
import com.n.lease.web.admin.vo.login.LoginVo;
import com.n.lease.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public CaptchaVo getCaptcha() {
        //新建验证码对象                             验证码大小                验证码4位
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();
        //获取验证码的值
        String value = specCaptcha.text().toLowerCase();
//        将键值对放入redis中储存并设置过期时间                              60s过期时间                            时间单位秒
        stringRedisTemplate.opsForValue().set(key, value, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        //返回base64编码后的验证码图片以及验证码对应的key
        return new CaptchaVo(specCaptcha.toBase64(), key);
    }

    @Override
    public String login(LoginVo loginVo) {
        // 如果验证码为空
        if (!StringUtils.hasLength(loginVo.getCaptchaCode())) {
        //给全局异常处理器传递code和Message，验证码未找到
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        //通过key从redis中进行校验
        String code = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        //如果找到的验证码为空说明验证码已经过期
        if (!StringUtils.hasLength(code)) {
            //向前端返回验证码过期的信息
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }
        //如果查询到的验证码和前端传来的验证码不相等
        if (!code.equals(loginVo.getCaptchaCode().toLowerCase())) {
            //返回验证码错误
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }
        //通过用户名查找用户
        LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemUser::getUsername,loginVo.getUsername());
        SystemUser systemUser = systemUserMapper.selectOne(queryWrapper);
        //如果查找的结果为空则说明用户名不存在
        if (systemUser == null) {
            //向前端返回用户名不存在
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        //如果用户状态为被禁用
        if (systemUser.getStatus() == BaseStatus.DISABLE) {
            //返回该用户已被禁用
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }
        //如果密码错误
        if (!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword()))) {
            //返回密码错误
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        //创建JWT，包含id和用户名
        return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
    }


    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        //mapper自带方法
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        //头像地址
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        systemUserInfoVo.setName(systemUser.getName());
        return systemUserInfoVo;
    }
}
