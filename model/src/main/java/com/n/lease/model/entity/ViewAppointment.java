package com.n.lease.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 预约看房信息表
 * @TableName view_appointment
 */
@TableName(value ="view_appointment")
@Data
public class ViewAppointment implements Serializable {
    /**
     * 预约id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 公寓id
     */
    private Integer apartmentId;

    /**
     * 预约时间
     */
    private Date appointmentTime;

    /**
     * 备注信息
     */
    private String additionalInfo;

    /**
     * 预约状态（1:待看房，2:已取消，3已看房）
     */
    private Integer appointmentStatus;

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
        ViewAppointment other = (ViewAppointment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getApartmentId() == null ? other.getApartmentId() == null : this.getApartmentId().equals(other.getApartmentId()))
            && (this.getAppointmentTime() == null ? other.getAppointmentTime() == null : this.getAppointmentTime().equals(other.getAppointmentTime()))
            && (this.getAdditionalInfo() == null ? other.getAdditionalInfo() == null : this.getAdditionalInfo().equals(other.getAdditionalInfo()))
            && (this.getAppointmentStatus() == null ? other.getAppointmentStatus() == null : this.getAppointmentStatus().equals(other.getAppointmentStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getApartmentId() == null) ? 0 : getApartmentId().hashCode());
        result = prime * result + ((getAppointmentTime() == null) ? 0 : getAppointmentTime().hashCode());
        result = prime * result + ((getAdditionalInfo() == null) ? 0 : getAdditionalInfo().hashCode());
        result = prime * result + ((getAppointmentStatus() == null) ? 0 : getAppointmentStatus().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", apartmentId=").append(apartmentId);
        sb.append(", appointmentTime=").append(appointmentTime);
        sb.append(", additionalInfo=").append(additionalInfo);
        sb.append(", appointmentStatus=").append(appointmentStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}