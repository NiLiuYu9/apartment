package com.n.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.n.lease.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.n.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.n.lease.web.admin.vo.agreement.AgreementVo;

/**
* @author 倪刘宇
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-09-01 15:38:43
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}
