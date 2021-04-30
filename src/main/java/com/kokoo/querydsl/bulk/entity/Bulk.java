package com.kokoo.querydsl.bulk.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="BULK")
public class Bulk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BULK_ID")
    private Long bulkId;
    @Column(name = "BULK_DATA")
    private String bulkData;
    @Column(name = "CRE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    private Date creDate;

    public Bulk(String bulkData){
        this.bulkData = bulkData;
    }
}
