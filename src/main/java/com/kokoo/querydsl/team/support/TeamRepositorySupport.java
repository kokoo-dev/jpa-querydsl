package com.kokoo.querydsl.team.support;

import com.kokoo.querydsl.team.entity.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.kokoo.querydsl.team.entity.QTeam.*;
@Repository
public class TeamRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public PageImpl<Team> findAllPaging(Pageable pageable){
        JPQLQuery<Team> query = jpaQueryFactory
                .select(Projections.fields(Team.class
                , team.teamId
                , team.teamName
                , team.teamSort
                , team.creDate))
                .from(team);

        long totalCount = query.fetchCount();
        List<Team> results = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(results, pageable, totalCount);
    }

    public List<Team> findByTeamName(String teamName){
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.teamName.eq(teamName))
                .fetch();
    }

    public Team findOne(Long teamId){
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.teamId.eq(teamId))
                .fetchOne();
    }

    public List<Team> findByTeamNameOrTeamName(String teamName1, String teamName2){
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.teamName.eq(teamName1).or(team.teamName.eq(teamName2)))
                .fetch();
    }

    @Transactional
    public void update(Team teams){
        jpaQueryFactory.update(team)
                .set(team.teamSort, teams.getTeamSort())
                .where(team.teamId.eq(teams.getTeamId()))
                .execute();
    }
}
