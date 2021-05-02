package com.kokoo.querydsl.domain.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MenuDTO {
    private Long menuId;
    private Long storeId;
    private String menuName;
    private Date creDate;
}
