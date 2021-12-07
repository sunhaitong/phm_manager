package com.chaos.manager.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaos.manager.entity.DeviceInfo;
import com.chaos.manager.entity.QueryEntity;
import com.chaos.manager.service.DeviceInfoService;
import com.chaos.manager.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunht
 * @date 2021/12/7
 */
@RestController
@RequestMapping("device")
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    /**
     * 导入
     *
     * @param file
     * @return
     */
    @PostMapping("import")
    public Result getStr(@RequestParam("files") MultipartFile file) {
        log.info("开始导入设备excel:"+System.currentTimeMillis());
        try {
            //读取excel
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            int sheetCount = reader.getSheetCount();
            List<DeviceInfo> allRecords = new ArrayList<>(sheetCount);
            for (int i = 0; i < sheetCount; i++) {
                reader.setSheet(i);
                List<DeviceInfo> readAll = reader.readAll(DeviceInfo.class);
                allRecords.addAll(readAll);
            }
            log.info("读取完成:"+System.currentTimeMillis());
            return Result.success(deviceInfoService.importDevice(allRecords));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return Result.error740("上传失败");
        }
    }

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestBody QueryEntity entity) {
        IPage<DeviceInfo> page = new Page<>(entity.getPageNum(), entity.getPageSize());
        QueryWrapper<DeviceInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(entity.getDevNo()), "device_no", entity.getDevNo())
                .eq(StringUtils.isNotBlank(entity.getPointNo()),"point_no", entity.getPointNo());
        IPage<DeviceInfo> pageEntity = deviceInfoService.page(page, wrapper);
        return Result.success(pageEntity);
    }
}
