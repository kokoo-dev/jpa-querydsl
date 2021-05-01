package com.kokoo.querydsl.domain.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @PostMapping("/insertAll")
    public void insertAll(){
        List<Team> teams = new ArrayList<>();

        for(int i=0; i<10; i++)
            teams.add(new Team("TestTeam"));

        teamRepository.saveAll(teams);
    }

    @PostMapping("/update")
    public void update(Team team){
        teamRepositorySupport.update(team);
    }

}
