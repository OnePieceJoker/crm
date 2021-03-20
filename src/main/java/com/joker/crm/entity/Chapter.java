package com.joker.crm.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1620002636612179427L;
    private Integer chapterId;
    private String chapterName;
    private String audioAddress;
    private transient Book book;

}