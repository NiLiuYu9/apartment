package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.SystemUser;
import com.n.lease.web.admin.service.SystemUserService;
import com.n.lease.web.admin.mapper.SystemUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService{

}




