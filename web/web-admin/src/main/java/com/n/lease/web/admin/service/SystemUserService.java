package com.n.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.n.lease.model.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.n.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.n.lease.web.admin.vo.system.user.SystemUserQueryVo;

/**
* @author 倪刘宇
* @description 针对表【system_user(员工信息表)】的数据库操作Service
* @createDate 2024-09-01 15:38:43
*/
public interface SystemUserService extends IService<SystemUser> {

    Page<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getSystemUserById(Long id);
}
