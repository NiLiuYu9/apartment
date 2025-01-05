package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.*;
import com.n.lease.web.admin.mapper.*;
import com.n.lease.web.admin.service.LeaseAgreementService;
import com.n.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.n.lease.web.admin.vo.agreement.AgreementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService{

    @Autowired
    private LeaseAgreementMapper leaseAgreementMapper;
    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;

    @Override
    public IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo) {
        return leaseAgreementMapper.pageAgreement(page,queryVo);
    }

    @Override
    public AgreementVo getAgreementById(Long id) {
        LeaseAgreement leaseAgreement = leaseAgreementMapper.selectById(id);
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(leaseAgreement.getApartmentId());
        RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreement.getRoomId());
        PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreement.getPaymentTypeId());
        LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreement.getLeaseTermId());
        AgreementVo agreementVo = new AgreementVo();
        //agreementVo继承了LeaseAgreement,用工具类将继承的属性复制
        BeanUtils.copyProperties(leaseAgreement,agreementVo);
        //传入其他属性
        agreementVo.setApartmentInfo(apartmentInfo);
        agreementVo.setRoomInfo(roomInfo);
        agreementVo.setPaymentType(paymentType);
        agreementVo.setLeaseTerm(leaseTerm);
        return agreementVo;
    }
}




