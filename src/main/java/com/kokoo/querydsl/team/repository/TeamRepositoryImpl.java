package com.kokoo.querydsl.team.repository;

import com.kokoo.querydsl.team.dto.TeamDTO;
import com.kokoo.querydsl.team.dto.TeamMember;
import com.kokoo.querydsl.team.entity.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kokoo.querydsl.team.entity.QTeam.team;
import static com.kokoo.querydsl.member.entity.QMember.member;

@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TeamMember> findAllTeamMember(){
        return jpaQueryFactory
                .select(Projections.fields(TeamMember.class
                , team.teamName.as("teamName")
                , team.teamSort.as("teamSort")
                , member.memberName.as("memberName")
                ))
                .from(team)
                .join(member)
                .on(team.teamId.eq(member.teamId))
                .fetch();
    }

    @Override
    public TeamDTO findOne(Long teamId){
        return jpaQueryFactory
                .select(Projections.fields(TeamDTO.class
                , team.teamId
                , team.teamName
                , team.teamSort
                , team.creDate))
                .from(team)
                .where(team.teamId.eq(teamId))
                .fetchOne();
    }

    @Override
    public List<TeamDTO> findByTeamNameOrTeamName(String teamName1, String teamName2){
        return jpaQueryFactory
                .select(Projections.fields(TeamDTO.class
                        , team.teamId
                        , team.teamName
                        , team.teamSort
                        , team.creDate))
                .from(team)
                .where(team.teamName.eq(teamName1).or(team.teamName.eq(teamName2)))
                .fetch();
    }
}
