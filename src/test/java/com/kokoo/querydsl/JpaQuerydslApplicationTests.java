package com.kokoo.querydsl;

import com.kokoo.querydsl.team.dto.TeamDTO;
import com.kokoo.querydsl.team.entity.Team;
import com.kokoo.querydsl.team.repository.TeamRepository;
import com.kokoo.querydsl.team.repository.TeamRepositoryCustom;
import com.kokoo.querydsl.team.support.TeamRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaQuerydslApplicationTests {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamRepositorySupport teamRepositorySupport;

	@Autowired
	private TeamRepositoryCustom teamRepositoryCustom;

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

		List<TeamDTO> results = teamRepositorySupport.findByTeamName(teamName);

		System.out.println(results.get(0).getTeamSort());
	}

	@Test
	public void findByOne(){
		Long teamId = 2L;
		TeamDTO team = teamRepositoryCustom.findOne(teamId);

		System.out.println("select one!");
		System.out.println(team.getTeamName());
		System.out.println(team.getTeamSort());
	}

	@Test
	void contextLoads() {
	}

}

