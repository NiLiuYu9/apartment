package com.n.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.n.lease.model.entity.RoomInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.n.lease.web.admin.vo.room.RoomDetailVo;
import com.n.lease.web.admin.vo.room.RoomItemVo;
import com.n.lease.web.admin.vo.room.RoomQueryVo;
import com.n.lease.web.admin.vo.room.RoomSubmitVo;

/**
* @author 倪刘宇
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2024-09-01 15:38:43
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
