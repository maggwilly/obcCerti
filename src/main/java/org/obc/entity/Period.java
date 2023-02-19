package org.obc.entity;

import java.time.LocalTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PERIOD")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period {
	@EmbeddedId
	private PeriodId id;
	private LocalTime endTime;
	@OneToOne(mappedBy = "period" )
	private Reservation reservation;
}
