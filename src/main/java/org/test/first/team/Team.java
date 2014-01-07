package org.test.first.team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.test.first.teammember.TeamMember;

@Entity
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id", columnDefinition = "serial")
	private Long id;

	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="team")
	private List<TeamMember> teamMembers = new ArrayList<TeamMember>();

	public Team() {
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeamMember> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}

}
