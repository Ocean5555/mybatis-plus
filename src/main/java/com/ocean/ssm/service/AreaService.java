package com.ocean.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ocean.ssm.entity.Area;
import com.ocean.ssm.mapper.AreaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ocean on 2019/3/5 10:46.
 */
@Service
@Transactional
public class AreaService {

    @Resource
    @SuppressWarnings("all")
    private AreaMapper areaMapper;

    public void create(){
        for (int i = 100; i < 200; i++) {
            Area area = new Area();
            area.setCityCode("xi'an");
            area.setAreaName("区域名" + i);
            area.setAddress("地址" + i);
            areaMapper.insert(area);
        }

    }

    public void update (Integer id){
        Area area = areaMapper.selectById(id);
        area.setAreaName("长安区");
        area.setAddress("府东一路");
        areaMapper.updateById(area);
    }

    public void delete(Integer id){
        areaMapper.deleteById(id);
    }

    public List<Area> selectArea(){
        QueryWrapper<Area> condition = new QueryWrapper<>();
//        condition.eq("area_id",6);
//        condition.eq("area_name","长安区");
        condition.orderByAsc("area_id");
        List<Area> areas = areaMapper.selectList(condition);
        return areas;
    }

    public IPage<Area> selectAreaPage(Integer page, Integer rows){
        Page<Area> currentPage = new Page<>(page,rows);
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        IPage<Area> areaIPage = areaMapper.selectPage(currentPage, queryWrapper);
        return areaIPage;

    }
}
