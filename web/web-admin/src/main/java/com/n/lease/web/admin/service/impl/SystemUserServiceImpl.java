package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.SystemPost;
import com.n.lease.model.entity.SystemUser;
import com.n.lease.web.admin.mapper.SystemPostMapper;
import com.n.lease.web.admin.service.SystemUserService;
import com.n.lease.web.admin.mapper.SystemUserMapper;
import com.n.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.n.lease.web.admin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService{

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemPostMapper systemPostMapper;

    @Override
    public Page<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageSystemUser(page,queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        //自带
        SystemUser systemUser = systemUserMapper.selectById(id);
        SystemPost post = systemPostMapper.selectById(systemUser.getPostId());
        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        //把属性名字一样的复制
        BeanUtils.copyProperties(systemUser,systemUserItemVo);
        systemUserItemVo.setPostName(post.getName());
        return systemUserItemVo;
    }
}




