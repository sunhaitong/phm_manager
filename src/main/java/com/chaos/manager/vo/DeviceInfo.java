package com.chaos.manager.vo;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author sunht
 * @date 2021/12/7
 */
@Data
@TableName("t_device_info")
public class DeviceInfo {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    @Alias("设备编码")
    private String deviceNo;
    @Alias("设备名称")
    private String deviceName;
    @Alias("测点名称")
    private String pointNo;
    @Alias("通道ID")
    private String channelId;
    @Alias("MAC地址")
    private String macAddress;

    @TableField(exist = false)
    private Boolean isOnline;
}
