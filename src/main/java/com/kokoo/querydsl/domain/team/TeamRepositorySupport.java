package com.kokoo.querydsl.domain.team;

import com.kokoo.querydsl.domain.team.TeamDTO;
import com.kokoo.querydsl.domain.team.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.kokoo.querydsl.domain.team.QTeam.*;
@Repository
public class TeamRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public PageImpl<TeamDTO> findAllPaging(Pageable pageable){
        JPQLQuery<TeamDTO> query = jpaQueryFactory
                .select(Projections.fields(TeamDTO.class
                , team.teamId
                , team.teamName
                , team.teamSort
                , team.creDate))
                .from(team);

        long totalCount = query.fetchCount();
        List<TeamDTO> results = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(results, pageable, totalCount);
    }

    public List<TeamDTO> findByTeamName(String teamName){
        return jpaQueryFactory
                .select(Projections.fields(TeamDTO.class
                , team.teamId
                , team.teamName
                , team.teamSort
                , team.creDate))
                .from(team)
                .where(team.teamName.eq(teamName))
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
