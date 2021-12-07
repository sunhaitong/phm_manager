package com.chaos.manager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaos.manager.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yanghuan
 * @date 2021/12/7
 */
@Mapper
public interface DeviceInfoDao extends BaseMapper<DeviceInfo> {

    int insertOne();
}
