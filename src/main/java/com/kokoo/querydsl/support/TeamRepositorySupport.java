package com.kokoo.querydsl.support;

import com.kokoo.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.kokoo.querydsl.entity.QTeam.*;
@Repository
public class TeamRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Team> findByTeamName(String teamName){
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.teamName.eq(teamName))
                .fetch();
    }
}
