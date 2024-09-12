package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.ApartmentInfo;
import com.n.lease.web.admin.service.ApartmentInfoService;
import com.n.lease.web.admin.mapper.ApartmentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 倪刘宇
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
    implements ApartmentInfoService{

}




