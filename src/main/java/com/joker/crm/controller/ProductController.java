package com.joker.crm.controller;

import java.util.List;

import com.joker.crm.common.api.R;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 * @author Mr.Joker
 * @date 2021/03/18
 * @time 15:00:48
 * @description 用户相关
 */
@RestController
@RequestMapping("/product")
@Api(tags = "客户管理接口")
public class ProductController {
    
    @PostMapping("/queryById/{productId}")
    @ApiOperation("根据客户id查询")
    public R queryById(@PathVariable("productId") @ApiParam(name = "id", value = "id") Integer id) {
        return R.ok().data("productId", id);
    }

    @PostMapping("/deleteByIds")
    @ApiOperation("根据id删除数据")
    public R deleteByIds(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Integer> ids) {
        return R.ok().data("ids", ids);
    }
}
