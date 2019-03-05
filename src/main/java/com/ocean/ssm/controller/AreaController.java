package com.ocean.ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ocean.ssm.entity.Area;
import com.ocean.ssm.mapper.AreaMapper;
import com.ocean.ssm.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ocean on 2019/3/5 9:36.
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        areaService.create();
        return "suceess!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Integer id) {
        if (id == null) {
            return "id is be needed";
        }
        areaService.update(id);
        return "update suceess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        if (id == null) {
            return "id is be needed";
        }
        areaService.delete(id);
        return "delete suceess";
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Area> selectArea() {
        List<Area> areas = areaService.selectArea();
        return areas;
    }

    @RequestMapping("/page")
    @ResponseBody
    public IPage<Area> selectAreaPage(Integer page, Integer rows) {
        IPage<Area> areaIPage = areaService.selectAreaPage(page, rows);
        return areaIPage;
    }
}
