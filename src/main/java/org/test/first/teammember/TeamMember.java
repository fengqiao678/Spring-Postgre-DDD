package org.test.first.teammember;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.test.first.team.Team;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TeamMember implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teamMember_id", columnDefinition = "serial")
	private Long id;

	private String name;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime joined;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime created;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updated;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;

	public TeamMember() {
	}

	public TeamMember(String name, DateTime joined, Team team) {
		super();
		this.name = name;
		this.joined = joined;
		this.team = team;
	}

	@PreUpdate
	private void setUpdated() {
		this.updated = new DateTime();
	}

	@PrePersist
	private void setCreated() {
		this.created = new DateTime();
		this.updated = this.created;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getJoined() {
		return joined;
	}

	public void setJoined(DateTime joined) {
		this.joined = joined;
	}

	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", name=" + name + ", joined=" + joined
				+ ", created=" + created + ", updated=" + updated + ", team="
				+ team + "]";
	}

}
