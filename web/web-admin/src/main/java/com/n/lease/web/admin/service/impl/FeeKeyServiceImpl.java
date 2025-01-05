package com.n.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.n.lease.model.entity.FeeKey;
import com.n.lease.web.admin.service.FeeKeyService;
import com.n.lease.web.admin.mapper.FeeKeyMapper;
import com.n.lease.web.admin.vo.fee.FeeKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 倪刘宇
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2024-09-01 15:38:43
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{
    @Autowired
    private FeeKeyMapper feeKeyMapper;

    @Override
    public List<FeeKeyVo> feeInfoList() {
        return feeKeyMapper.feeInfoList();
    }
}




