package org.obc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Period period;
	@OneToOne
     private Candidate candidate;
     private Integer registrationNumber;
	 private Status status;
}
