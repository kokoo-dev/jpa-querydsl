package com.kokoo.querydsl;

import com.kokoo.querydsl.entity.Team;
import com.kokoo.querydsl.repository.TeamRepository;
import com.kokoo.querydsl.support.TeamRepositorySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaQuerydslApplicationTests {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamRepositorySupport teamRepositorySupport;

	@Test
	public void findByName(){
		String teamName = "A_TEAM";
		String teamSort = "Soccer";

//		Team team = Team.builder()
//				.teamName(teamName)
//				.teamSort(teamSort)
//				.build();
//
//		teamRepository.save(team);

		List<Team> results = teamRepositorySupport.findByTeamName(teamName);

		System.out.println(results.get(0).getTeamSort());
	}
	@Test
	void contextLoads() {
	}

}

