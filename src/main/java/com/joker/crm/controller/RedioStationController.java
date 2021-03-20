package com.joker.crm.controller;

import java.util.List;

import com.joker.crm.common.api.R;
import com.joker.crm.dao.PopularRedioMapper;
import com.joker.crm.entity.Book;
import com.joker.crm.entity.Chapter;
import com.joker.crm.service.RedioStationService;
import com.joker.crm.vo.PopularRedio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/redioStation")
@Api(tags = "电台资源接口")
public class RedioStationController {
    
    @Autowired
    private RedioStationService service;

    @ApiOperation(value = "获取热榜资源")
    @PostMapping("/popular")
    public R queryPopularBooks() {
        List<PopularRedio> result = service.queryPopularRedioList();
        return R.ok().data("popular", result);
    }

    @ApiOperation(value = "获取资源详细章节")
    @PostMapping("/books/{id}")
    public R queryBookInfoByBookId(@PathVariable("id") @ApiParam(name = "id", value = "书籍id") Integer id) {
        Book book = service.queryBookInfoByBookId(id);
        return R.ok().data("book", book);
    }

}
