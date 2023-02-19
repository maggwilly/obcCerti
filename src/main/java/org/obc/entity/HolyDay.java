package org.obc.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOLYDAY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HolyDay {
	@Id
	private LocalDate date;
	private String description;
}
