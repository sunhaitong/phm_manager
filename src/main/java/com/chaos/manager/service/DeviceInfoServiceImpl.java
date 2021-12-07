package com.chaos.manager.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaos.manager.dao.DeviceInfoDao;
import com.chaos.manager.entity.DeviceInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunht
 * @date 2021/12/7
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoDao, DeviceInfo> implements DeviceInfoService {
    @Override
    public boolean importDevice(List<DeviceInfo> allRecords) {
        return saveBatch(allRecords);
    }
}
