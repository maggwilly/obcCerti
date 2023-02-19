package org.obc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.obc.entity.Period;
import org.obc.entity.PeriodId;

public interface PeriodService {
	 void generate(LocalDateTime start, LocalDateTime end);

	 void save(Period period);
	 List<Period> findAvailable(LocalDate date);
	 Optional<Period> findLast();
	Optional<Period> findById(PeriodId id);
	 List<Period> findAvailableOnDateAndTime(LocalDate localDate, LocalTime time);
}
