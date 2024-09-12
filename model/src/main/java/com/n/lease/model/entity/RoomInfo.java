package com.n.lease.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 房间信息表
 * @TableName room_info
 */
@TableName(value ="room_info")
@Data
public class RoomInfo implements Serializable {
    /**
     * 房间id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 房间号
     */
    private String roomNumber;

    /**
     * 租金（元/月）
     */
    private BigDecimal rent;

    /**
     * 所属公寓id
     */
    private Long apartmentId;

    /**
     * 是否发布
     */
    private Integer isRelease;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RoomInfo other = (RoomInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoomNumber() == null ? other.getRoomNumber() == null : this.getRoomNumber().equals(other.getRoomNumber()))
            && (this.getRent() == null ? other.getRent() == null : this.getRent().equals(other.getRent()))
            && (this.getApartmentId() == null ? other.getApartmentId() == null : this.getApartmentId().equals(other.getApartmentId()))
            && (this.getIsRelease() == null ? other.getIsRelease() == null : this.getIsRelease().equals(other.getIsRelease()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoomNumber() == null) ? 0 : getRoomNumber().hashCode());
        result = prime * result + ((getRent() == null) ? 0 : getRent().hashCode());
        result = prime * result + ((getApartmentId() == null) ? 0 : getApartmentId().hashCode());
        result = prime * result + ((getIsRelease() == null) ? 0 : getIsRelease().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", rent=").append(rent);
        sb.append(", apartmentId=").append(apartmentId);
        sb.append(", isRelease=").append(isRelease);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}