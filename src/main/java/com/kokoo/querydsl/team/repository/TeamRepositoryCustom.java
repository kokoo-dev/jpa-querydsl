package com.kokoo.querydsl.team.repository;

import com.kokoo.querydsl.team.dto.TeamDTO;
import com.kokoo.querydsl.team.dto.TeamMember;

import java.util.List;

public interface TeamRepositoryCustom {
    public List<TeamMember> findAllTeamMember();
    public TeamDTO findOne(Long teamId);
    public List<TeamDTO> findByTeamNameOrTeamName(String teamName1, String teamName2);
}
