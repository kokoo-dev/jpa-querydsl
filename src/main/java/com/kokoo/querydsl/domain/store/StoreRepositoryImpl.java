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
    public List<Store> findAllStoreMenu(){
        return jpaQueryFactory
                .selectFrom(store)
                .leftJoin(store.menuList, menu)
                .fetchJoin()
                .fetch();
    }
}

