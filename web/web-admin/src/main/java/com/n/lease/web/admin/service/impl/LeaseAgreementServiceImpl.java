package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.LeaseAgreement;
import com.n.lease.web.admin.service.LeaseAgreementService;
import com.n.lease.web.admin.mapper.LeaseAgreementMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService{

}




