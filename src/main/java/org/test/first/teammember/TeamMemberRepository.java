package org.test.first.teammember;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(rel = "teamMember", path = "teamMember")
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
}
