package com.kokoo.querydsl.domain.team;

import com.kokoo.querydsl.domain.team.TeamDTO;
import com.kokoo.querydsl.domain.team.TeamMember;

import java.util.List;

public interface TeamRepositoryCustom {
    public List<TeamMember> findAllTeamMember();
    public TeamDTO findOne(Long teamId);
    public List<TeamDTO> findByTeamNameOrTeamName(String teamName1, String teamName2);
}
