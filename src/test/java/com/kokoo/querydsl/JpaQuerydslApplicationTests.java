package com.kokoo.querydsl;

import com.kokoo.querydsl.bulk.entity.Bulk;
import com.kokoo.querydsl.bulk.repository.BulkRepository;
import com.kokoo.querydsl.team.dto.TeamDTO;
import com.kokoo.querydsl.team.entity.Team;
import com.kokoo.querydsl.team.repository.TeamRepository;
import com.kokoo.querydsl.team.repository.TeamRepositoryCustom;
import com.kokoo.querydsl.team.support.TeamRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
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

	@Autowired
	private BulkRepository bulkRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
	public void insertBulkSaveAll(){
		List<Bulk> bulkList = new ArrayList<>();

		for(int i=0; i<100000; i++)
			bulkList.add(new Bulk("testData"));

		bulkRepository.saveAll(bulkList);
	}

	@Test
	public void insertBulk(){
		List<Object[]> batch = new ArrayList<>();

		for(int i=0; i<100000; i++){
			Object[] values = new Object[]{"testData"};
			batch.add(values);
		}

		int[] insertCount = jdbcTemplate.batchUpdate(
				"insert into bulk (bulk_data) values (?)"
				, batch
		);
	}

	@Test
	void contextLoads() {
	}

}

