package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.PaymentType;
import com.n.lease.web.admin.service.PaymentTypeService;
import com.n.lease.web.admin.mapper.PaymentTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

}




