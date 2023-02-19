package org.obc.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

}
