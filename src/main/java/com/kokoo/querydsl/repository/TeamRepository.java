package com.kokoo.querydsl.repository;

import com.kokoo.querydsl.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByTeamName(String teamName);
}
