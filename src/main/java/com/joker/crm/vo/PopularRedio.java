package com.joker.crm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class PopularRedio {
    
    @ApiModelProperty(value = "书id")
    private Integer id; 
    @ApiModelProperty(value = "书名")
    private String name;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "简介")
    private String description;
}
