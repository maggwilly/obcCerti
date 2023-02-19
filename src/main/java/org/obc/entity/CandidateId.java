package org.obc.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateId implements Serializable {
	private  LocalDate date;
	private String phone;
}
