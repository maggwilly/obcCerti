package org.obc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CANDIDAT")
public class Candidate {
	@EmbeddedId
	private CandidateId id;
	@NotEmpty(message = "The branch cannot be empty.")
	private String branch;
	@NotEmpty(message = "The sessionName cannot be empty.")
	private String sessionName;
	@NotEmpty(message = "Candidate's centre cannot be empty.")
	private String centre;
	@NotEmpty(message = "Candidate's name cannot be empty.")
	private String name;
	private String surname;
	@NotEmpty(message = "Candidate's email cannot be empty.")
	private String email;
}
