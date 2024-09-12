package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.LeaseTerm;
import com.n.lease.web.admin.service.LeaseTermService;
import com.n.lease.web.admin.mapper.LeaseTermMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【lease_term(租期)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService{

}




