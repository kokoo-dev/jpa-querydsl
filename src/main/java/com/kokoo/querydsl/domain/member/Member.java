package com.kokoo.querydsl.domain.member;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "TEAM_ID")
    private Long teamId;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name = "CRE_DATE")
    private Date creDate;
}
