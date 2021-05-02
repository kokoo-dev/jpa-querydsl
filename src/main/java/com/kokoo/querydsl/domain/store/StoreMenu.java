package com.kokoo.querydsl.domain.store;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class StoreMenu {
    private Long storeId;
    private Long menuId;
    private String storeName;
    private String menuName;
    private Date storeCreDate;
    private Date menuCreDate;

}
