package com.ruoyi.framework.web.domain.server;

import com.ruoyi.common.utils.Arith;
import com.ruoyi.common.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import java.lang.management.ManagementFactory;

/**
 * JVM相关信息
 *
 * @author ruoyi
 */
public class Jvm {
    /** 当前JVM占用的内存总数(M) */
    private double total;

    /** JVM最大可用内存总数(M) */
    private double max;

    /** JVM空闲内存(M) */
    private double free;

    /** JDK版本 */
    @Getter
    @Setter
    private String version;

    /** JDK路径 */
    @Getter
    @Setter
    private String home;

    public double getTotal() {
        return Arith.div(total, (1024 * 1024), 2);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMax() {
        return Arith.div(max, (1024 * 1024), 2);
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getFree() {
        return Arith.div(free, (1024 * 1024), 2);
    }

    public void setFree(double free) {
        this.free = free;
    }

    public double getUsed() {
        return Arith.div(total - free, (1024 * 1024), 2);
    }

    public double getUsage() {
        return Arith.mul(Arith.div(total - free, total, 4), 100);
    }

    /**
     * 获取JDK名称
     */
    public String getName() {
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }

    /**
     * JDK启动时间
     */
    public String getStartTime() {
        return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getServerStartDate());
    }

    /**
     * JDK运行时间
     */
    public String getRunTime() {
        return DateUtils.getDatePoor(DateUtils.getNowDate(), DateUtils.getServerStartDate());
    }

    /**
     * 运行参数
     */
    public String getInputArgs() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
    }
}