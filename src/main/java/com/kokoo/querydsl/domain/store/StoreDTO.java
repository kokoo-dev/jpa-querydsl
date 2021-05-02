package com.kokoo.querydsl.domain.store;

import com.kokoo.querydsl.domain.menu.MenuDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class StoreDTO {
    private Long storeId;
    private String storeName;
    private Date creDate;
    private List<MenuDTO> menuDTOList;

}
