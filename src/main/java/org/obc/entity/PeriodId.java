package org.obc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
public class PeriodId implements Serializable {
	private LocalDate date;
	private Integer office;
	private LocalTime startTime;
}
