package com.n.lease.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 租约信息表
 * @TableName lease_agreement
 */
@TableName(value ="lease_agreement")
@Data
public class LeaseAgreement implements Serializable {
    /**
     * 租约id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 承租人手机号码
     */
    private String phone;

    /**
     * 承租人姓名
     */
    private String name;

    /**
     * 承租人身份证号码
     */
    private String identificationNumber;

    /**
     * 签约公寓id
     */
    private Long apartmentId;

    /**
     * 签约房间id
     */
    private Long roomId;

    /**
     * 租约开始日期
     */
    private Date leaseStartDate;

    /**
     * 租约结束日期
     */
    private Date leaseEndDate;

    /**
     * 租期id
     */
    private Long leaseTermId;

    /**
     * 租金（元/月）
     */
    private BigDecimal rent;

    /**
     * 押金（元）
     */
    private BigDecimal deposit;

    /**
     * 支付类型id

     */
    private Long paymentTypeId;

    /**
     * 租约状态（1:签约待确认，2:已签约，3:已取消，4:已到期，5:退租待确认，6:已退租，7:续约待确认）
     */
    private Integer status;

    /**
     * 租约来源（1:新签，2:续约）
     */
    private Integer sourceType;

    /**
     * 备注信息
     */
    private String additionalInfo;

    /**
     * 创建时间
     */
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否删除
     */
    @JsonIgnore
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
        LeaseAgreement other = (LeaseAgreement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdentificationNumber() == null ? other.getIdentificationNumber() == null : this.getIdentificationNumber().equals(other.getIdentificationNumber()))
            && (this.getApartmentId() == null ? other.getApartmentId() == null : this.getApartmentId().equals(other.getApartmentId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getLeaseStartDate() == null ? other.getLeaseStartDate() == null : this.getLeaseStartDate().equals(other.getLeaseStartDate()))
            && (this.getLeaseEndDate() == null ? other.getLeaseEndDate() == null : this.getLeaseEndDate().equals(other.getLeaseEndDate()))
            && (this.getLeaseTermId() == null ? other.getLeaseTermId() == null : this.getLeaseTermId().equals(other.getLeaseTermId()))
            && (this.getRent() == null ? other.getRent() == null : this.getRent().equals(other.getRent()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getPaymentTypeId() == null ? other.getPaymentTypeId() == null : this.getPaymentTypeId().equals(other.getPaymentTypeId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getAdditionalInfo() == null ? other.getAdditionalInfo() == null : this.getAdditionalInfo().equals(other.getAdditionalInfo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdentificationNumber() == null) ? 0 : getIdentificationNumber().hashCode());
        result = prime * result + ((getApartmentId() == null) ? 0 : getApartmentId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getLeaseStartDate() == null) ? 0 : getLeaseStartDate().hashCode());
        result = prime * result + ((getLeaseEndDate() == null) ? 0 : getLeaseEndDate().hashCode());
        result = prime * result + ((getLeaseTermId() == null) ? 0 : getLeaseTermId().hashCode());
        result = prime * result + ((getRent() == null) ? 0 : getRent().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getPaymentTypeId() == null) ? 0 : getPaymentTypeId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getAdditionalInfo() == null) ? 0 : getAdditionalInfo().hashCode());
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
        sb.append(", phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", identificationNumber=").append(identificationNumber);
        sb.append(", apartmentId=").append(apartmentId);
        sb.append(", roomId=").append(roomId);
        sb.append(", leaseStartDate=").append(leaseStartDate);
        sb.append(", leaseEndDate=").append(leaseEndDate);
        sb.append(", leaseTermId=").append(leaseTermId);
        sb.append(", rent=").append(rent);
        sb.append(", deposit=").append(deposit);
        sb.append(", paymentTypeId=").append(paymentTypeId);
        sb.append(", status=").append(status);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", additionalInfo=").append(additionalInfo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}