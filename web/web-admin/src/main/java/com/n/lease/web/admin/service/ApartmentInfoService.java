package com.n.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.n.lease.model.entity.ApartmentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.n.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.n.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.n.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.n.lease.web.admin.vo.apartment.ApartmentSubmitVo;

/**
* @author 倪刘宇
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2024-09-01 15:38:43
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    void saveorUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    ApartmentDetailVo getDetailById(Long id);

    void removeApartmentById(Long id);
}
