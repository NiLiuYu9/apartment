package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.UserInfo;
import com.n.lease.web.admin.service.UserInfoService;
import com.n.lease.web.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:42
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




