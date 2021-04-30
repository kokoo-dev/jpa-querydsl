package com.kokoo.querydsl.bulk.service;

import com.kokoo.querydsl.bulk.entity.Bulk;
import com.kokoo.querydsl.bulk.repository.BulkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BulkService {

    @Autowired
    BulkRepository bulkRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertBulk(List<Bulk> bulkList){
        //list 사이즈 만큼 insert가 발생함, jdbcTemplate으로 대체
//        bulkRepository.saveAll(bulkList);

        List<Object[]> batch = new ArrayList<>();

        bulkList.stream().forEach(bulk -> {
            Object[] values = new Object[]{
                    bulk.getBulkData()
            };

            batch.add(values);
        });

        int[] insertCount = jdbcTemplate.batchUpdate(
                "insert into bulk (bulk_data) values (?)"
                , batch
        );

    }
}
