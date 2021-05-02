package com.kokoo.querydsl.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreRepositoryCustom storeRepositoryCustom;

    @GetMapping("/findAllStoreMenuDTO")
    public List<StoreMenu> findAllStoreMenuDTO(){
        return storeRepositoryCustom.findAllStoreMenuDTO();
    }

    @GetMapping("/findAllStoreMenu")
    public List<Store> findAllStoreMenu(){
        return storeRepositoryCustom.findAllStoreMenu();
    }

}
