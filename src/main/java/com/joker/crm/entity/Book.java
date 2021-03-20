package com.joker.crm.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class Book implements Serializable {
    
    private static final long serialVersionUID = 9043041804232653249L;
    private Integer bookId;
    private String name;
    private String author;
    private String tag;
}
