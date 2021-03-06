package com.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubUser {
    private Integer id;
    private String name;
    private String bio;
    private String avatar_url;

}
