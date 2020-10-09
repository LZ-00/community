package com.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String accountId;
    private String token;
    private String name;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
