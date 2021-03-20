package com.joker.crm.controller;

import java.util.List;

import com.joker.crm.common.api.R;
import com.joker.crm.dao.PopularRedioMapper;
import com.joker.crm.vo.PopularRedio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/redioStation")
@Api(tags = "电台资源接口")
public class RedioStationController {
    
    @Autowired
    private PopularRedioMapper popularRedioMapper;

    @ApiOperation(value = "获取热榜资源")
    @PostMapping("/popular")
    public R getPopularResources() {
        List<PopularRedio> result = popularRedioMapper.queryPopularRedioList();
        return R.ok().data("popular", result);
    }
}
