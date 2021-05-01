package com.kokoo.querydsl.domain.team;

import lombok.Getter;

import java.util.Date;

@Getter
public class TeamDTO {
    private Long teamId;
    private String teamName;
    private String teamSort;
    private Date creDate;
}
