package com.kokoo.querydsl.domain.store;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kokoo.querydsl.domain.menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="STORE")
@Table(name = "store")
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long storeId;
    @Column(name = "STORE_NAME")
    private String storeName;
    @Column(name = "CRE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    private Date creDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<Menu> menuList = new ArrayList<>();
}
