package com.n.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.n.lease.model.entity.RoomInfo;
import com.n.lease.web.admin.vo.room.RoomItemVo;
import com.n.lease.web.admin.vo.room.RoomQueryVo;

/**
* @author 倪刘宇
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-09-01 15:38:43
* @Entity com.n.lease.model.entity.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);
}




