package com.joker.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 4331397251879964594L;
    private Long id;
    private String userName;
    private String userSex;
}
