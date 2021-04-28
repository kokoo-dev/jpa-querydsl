package com.kokoo.querydsl.team.controller;

import com.kokoo.querydsl.team.entity.Team;
import com.kokoo.querydsl.team.repository.TeamRepository;
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

    @GetMapping("/findAllPaging")
    public PageImpl<Team> findAllPaging(Pageable pageable){
        PageImpl<Team> results = teamRepositorySupport.findAllPaging(pageable);

        return results;
    }

    @GetMapping("/findByName")
    public List<Team> findByName(Team team){
        List<Team> results = teamRepositorySupport.findByTeamName(team.getTeamName());

        return results;
    }

    @GetMapping("/findByOne")
    public Team findByOne(Team team){
        Team result = teamRepositorySupport.findOne(team.getTeamId());
        return result;
    }

    @GetMapping("/findByTeamNameOrTeamName")
    public List<Team> findByTeamNameOrTeamName(){
        String teamName1 = "B_TEAM";
        String teamName2 = "F_TEAM";
        List<Team> results = teamRepositorySupport.findByTeamNameOrTeamName(teamName1, teamName2);

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
