package com.n.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.n.lease.model.entity.LeaseAgreement;
import com.n.lease.model.enums.LeaseStatus;
import com.n.lease.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTasks {
    @Autowired
    private LeaseAgreementService leaseAgreementService;
    //多久执行一次
//  ┌───────────── second (0-59)
//  │ ┌───────────── minute (0 - 59)
//  │ │ ┌───────────── hour (0 - 23)
//  │ │ │ ┌───────────── day of the month (1 - 31)
//  │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
//  │ │ │ │ │ ┌───────────── day of the week (0 - 7)
//  │ │ │ │ │ │          (0 or 7 is Sunday, or MON-SUN)
//  │ │ │ │ │ │
//  * * * * * *
//    每天0点0分0秒检查租约状态
//    将结束日期小于等于当前日期的租约设置成已到期
    @Scheduled(cron="0 0 0 * * *")
    public void checkLeaseStatus(){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        //只对签约状态和退租待确认状态作租约是否过期的判断和修改
        updateWrapper.in(LeaseAgreement::getStatus,LeaseStatus.SIGNED,LeaseStatus.WITHDRAWING);
        updateWrapper.le(LeaseAgreement::getLeaseEndDate,new Date());//le小于等于
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        leaseAgreementService.update(updateWrapper);
    }
}
