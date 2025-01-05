package com.n.lease.web.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.n.lease.model.entity.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.n.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.n.lease.web.admin.vo.system.user.SystemUserQueryVo;

/**
* @author 倪刘宇
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-09-01 15:38:43
* @Entity com.n.lease.model.entity.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    Page<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo);

}




