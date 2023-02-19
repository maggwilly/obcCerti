package org.obc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.obc.entity.Period;

public interface PeriodService {
	 void generate(LocalDateTime start, LocalDateTime end);

	 void save(Period period);
	 List<Period> findAvailable(LocalDate date);
	 Optional<Period> findLast();
}
