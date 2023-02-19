package org.obc.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.obc.util.PeriodIdGenerator.ID_GENERATOR;

@Entity
@Table(name = "PERIOD")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period {
	@Id
	@GeneratedValue(generator = "id-generator")
	@GenericGenerator(name = "id-generator", strategy = ID_GENERATOR)
	private String id;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Integer office;
}
