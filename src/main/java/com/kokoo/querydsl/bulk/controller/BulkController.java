package com.kokoo.querydsl.bulk.controller;

import com.kokoo.querydsl.bulk.entity.Bulk;
import com.kokoo.querydsl.bulk.repository.BulkRepository;
import com.kokoo.querydsl.bulk.service.BulkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BulkController {
    @Autowired
    BulkRepository bulkRepository;

    @Autowired
    BulkService bulkService;

    @PostMapping("/insertBulk")
    public void insertBulk(){
        List<Bulk> bulkList = new ArrayList<>();

        for(int i=0; i<100; i++)
            bulkList.add(new Bulk("testData"));

        bulkService.insertBulk(bulkList);
    }
}
