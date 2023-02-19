package org.obc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateId implements Serializable {
	private String date;
	private String phone;
}
