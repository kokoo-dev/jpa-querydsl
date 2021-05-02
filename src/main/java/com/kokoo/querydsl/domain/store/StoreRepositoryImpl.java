package com.kokoo.querydsl.domain.store;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import static com.kokoo.querydsl.domain.store.QStore.store;
import static com.kokoo.querydsl.domain.menu.QMenu.menu;

@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<StoreMenu> findAllStoreMenuDTO(){
        // fetch join은 엔티티 그래프를 참조하기 위함,
        // DTO는 순수 join()을 사용
        return jpaQueryFactory
                .select(Projections.fields(StoreMenu.class
                , store.storeId.as("storeId")
                , store.storeName.as("storeName")
                , store.creDate.as("storeCreDate")
                , menu.menuId.as("menuId")
                , menu.menuName.as("menuName")
                , menu.creDate.as("menuCreDate")))
                .from(store)
                .join(menu)
                .on(store.storeId.eq(menu.storeId))
                .fetch();
    }

    @Override
    public List<Store> findAllStoreMenu(){
        return jpaQueryFactory
                .selectFrom(store)
                .leftJoin(store.menuList, menu)
                .fetchJoin()
                .fetch();
    }
}

