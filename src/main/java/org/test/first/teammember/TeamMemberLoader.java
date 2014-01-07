package org.test.first.teammember;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.first.team.Team;
import org.test.first.team.TeamRepository;

@Component
public class TeamMemberLoader implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(TeamMemberLoader.class);

	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Autowired
	private TeamRepository campaigns;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (teamMemberRepository.count() == 0) {
			addElements();
		}
	}

	private void addElements() {
		Team team = new Team("The best team");
		team = campaigns.save(team);
		LOG.info("Added team " + team);
		
		TeamMember member1 = new TeamMember("John Doe", new DateTime(), team);
		member1 = teamMemberRepository.save(member1);
		LOG.info("added new team member " + member1);
		
		TeamMember member2 = new TeamMember("John Doe", new DateTime(), team);
		member2 = teamMemberRepository.save(member2);
		LOG.info("added new team member " + member2);
	}
}
