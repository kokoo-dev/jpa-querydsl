package com.kokoo.querydsl.team.repository;

import com.kokoo.querydsl.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
//    List<Team> findByTeamName(String teamName);
}
