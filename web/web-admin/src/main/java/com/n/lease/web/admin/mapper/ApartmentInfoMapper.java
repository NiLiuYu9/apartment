package com.n.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.n.lease.model.entity.ApartmentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.n.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.n.lease.web.admin.vo.apartment.ApartmentQueryVo;

/**
* @author 倪刘宇
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2024-09-01 15:38:43
* @Entity com.n.lease.model.entity.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);
}




