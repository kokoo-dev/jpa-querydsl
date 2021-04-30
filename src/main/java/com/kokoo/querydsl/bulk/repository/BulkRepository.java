package com.kokoo.querydsl.bulk.repository;

import com.kokoo.querydsl.bulk.entity.Bulk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulkRepository extends JpaRepository<Bulk, Long> {

}
