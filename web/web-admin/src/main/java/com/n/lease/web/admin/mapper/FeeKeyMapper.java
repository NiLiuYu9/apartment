package com.n.lease.web.admin.mapper;

import com.n.lease.model.entity.FeeKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.n.lease.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

/**
* @author 倪刘宇
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Mapper
* @createDate 2024-09-01 15:38:43
* @Entity com.n.lease.model.entity.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}




