package com.kokoo.querydsl.domain.menu;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kokoo.querydsl.domain.store.Store;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="MENU")
@Table(name = "menu")
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long menuId;
    @Column(name = "STORE_ID")
    private Long storeId;
    @Column(name = "MENU_NAME")
    private String menuName;
    @Column(name = "CRE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    private Date creDate;

    @ManyToOne(optional = false)

    @JoinColumn(name="STORE_ID", foreignKey = @ForeignKey(name = "MENU_FK1"), insertable = false, updatable = false)
    private Store store;
}
