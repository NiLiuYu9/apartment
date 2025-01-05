package com.n.lease.web.admin.controller.login;


import com.n.lease.common.result.Result;
import com.n.lease.common.utils.JwtUtil;
import com.n.lease.web.admin.service.LoginService;
import com.n.lease.web.admin.vo.login.CaptchaVo;
import com.n.lease.web.admin.vo.login.LoginVo;
import com.n.lease.web.admin.vo.system.user.SystemUserInfoVo;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
//    前端发送`username`、`password`、`captchaKey`、`captchaCode`请求登录
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    //                                    前端携带的请求头
    public Result<SystemUserInfoVo> info(@RequestHeader("access-token")String token) {
        //解析token
        Claims claims = JwtUtil.parseToken(token);
        //                                  指定userId的类型
        Long userId = claims.get("userId", Long.class);
        SystemUserInfoVo systemUserInfoVo = loginService.getLoginUserInfoById(userId);
        return Result.ok(systemUserInfoVo);

    }

}