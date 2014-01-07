package org.test.first.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.first.teammember.TeamMemberLoader;

@Controller
@RequestMapping(value = "team")
public class TeamController {
	private static final Logger LOG = LoggerFactory.getLogger(TeamMemberLoader.class);

	@Autowired
	private TeamRepository teamService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Team> listTeams() {
		Iterable<Team> teams = teamService.findAll();
		LOG.info(teams.toString());
		return teams;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Team addTeam(@RequestBody Team team, BindingResult result) {
		LOG.info(team.toString());
		teamService.save(team);

		return team;
	}
}
