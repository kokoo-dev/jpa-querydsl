package com.kokoo.querydsl.domain.team;

import com.kokoo.querydsl.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
//    List<Team> findByTeamName(String teamName);
}
