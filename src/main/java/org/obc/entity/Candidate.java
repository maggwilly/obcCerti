package org.obc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CANDIDAT")
public class Candidate {
	@EmbeddedId
	private CandidateId id;
	private String branch;
	private String sessionName;
	private String name;
	private String surname;
	private String email;
}
