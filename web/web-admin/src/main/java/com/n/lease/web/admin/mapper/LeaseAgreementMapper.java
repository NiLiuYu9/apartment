package com.n.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.n.lease.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.n.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.n.lease.web.admin.vo.agreement.AgreementVo;

/**
* @author 倪刘宇
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-09-01 15:38:43
* @Entity com.n.lease.model.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




