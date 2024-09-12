package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.SystemPost;
import com.n.lease.web.admin.service.SystemPostService;
import com.n.lease.web.admin.mapper.SystemPostMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService{

}




