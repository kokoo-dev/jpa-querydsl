package com.kokoo.querydsl.team.controller;

import com.kokoo.querydsl.team.dto.TeamDTO;
import com.kokoo.querydsl.team.dto.TeamMember;
import com.kokoo.querydsl.team.entity.Team;
import com.kokoo.querydsl.team.repository.TeamRepository;
import com.kokoo.querydsl.team.repository.TeamRepositoryCustom;
import com.kokoo.querydsl.team.repository.TeamRepositoryImpl;
import com.kokoo.querydsl.team.support.TeamRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamRepositorySupport teamRepositorySupport;

    @Autowired
    private TeamRepositoryCustom teamRepositoryCustom;

    @GetMapping("/findAllPaging")
    public PageImpl<TeamDTO> findAllPaging(Pageable pageable){
        PageImpl<TeamDTO> results = teamRepositorySupport.findAllPaging(pageable);

        return results;
    }

    @GetMapping("/findByName")
    public List<TeamDTO> findByName(Team team){
        List<TeamDTO> results = teamRepositorySupport.findByTeamName(team.getTeamName());

        return results;
    }

    @GetMapping("/findByOne")
    public TeamDTO findByOne(Team team){
        TeamDTO result = teamRepositoryCustom.findOne(team.getTeamId());
        return result;
    }

    @GetMapping("/findByTeamNameOrTeamName")
    public List<TeamDTO> findByTeamNameOrTeamName(){
        String teamName1 = "B_TEAM";
        String teamName2 = "F_TEAM";
        List<TeamDTO> results = teamRepositoryCustom.findByTeamNameOrTeamName(teamName1, teamName2);

        return results;
    }

    @GetMapping("/findAllTeamMember")
    public List<TeamMember> findAllTeamMember(){
        List<TeamMember> results = teamRepositoryCustom.findAllTeamMember();

        return results;
    }


    @PostMapping("/insert")
    public void insert(Team team){
        teamRepository.save(team);
    }

    @PostMapping("/update")
    public void update(Team team){
        teamRepositorySupport.update(team);
    }
}
