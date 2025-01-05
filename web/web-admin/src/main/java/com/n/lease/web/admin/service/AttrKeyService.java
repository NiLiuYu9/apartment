package com.n.lease.web.admin.service;

import com.n.lease.model.entity.AttrKey;
import com.baomidou.mybatisplus.extension.service.IService;
import com.n.lease.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author 倪刘宇
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
* @createDate 2024-09-01 15:38:43
*/
public interface AttrKeyService extends IService<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}
