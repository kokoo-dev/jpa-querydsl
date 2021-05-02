package com.kokoo.querydsl.domain.store;

import java.util.List;

public interface StoreRepositoryCustom {

    public List<StoreMenu> findAllStoreMenuDTO();
    public List<Store> findAllStoreMenu();
}
