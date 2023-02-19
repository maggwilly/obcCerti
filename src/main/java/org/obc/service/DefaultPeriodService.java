package org.obc.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.obc.entity.Period;
import org.obc.entity.PeriodId;
import org.obc.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultPeriodService implements PeriodService {
	private final PeriodRepository repository;
	@Value("${period.max.length:15}")
	private Duration duration;
	@Value("${period.max.officeNumber:1}")
	private Integer officeNumber;

	@Override
	public void generate(final LocalDateTime start, LocalDateTime end) {
		LocalDateTime currentStart = start;
		while (currentStart.isBefore(end)) {
			LocalDateTime currentEnd = currentStart.plus(duration);
			if (currentEnd.isAfter(end)) {
				currentEnd = end;
			}
			createPeriod(currentStart, currentEnd);
			currentStart = currentEnd;
		}
	}

	private void createPeriod(LocalDateTime currentStart, LocalDateTime currentEnd) {
		IntStream.range(1, (1+officeNumber)).boxed().forEach(value -> {
			final var date = currentStart.toLocalDate();
			final var endTime = currentEnd.toLocalTime();
			final var startTime = currentStart.toLocalTime();
			final var id = PeriodId.builder().startTime(startTime).date(date).office(officeNumber).build();
			final var period = Period.builder().id(id).endTime(endTime).build();
			save(period);
		});
	}

	@Override
	@Transactional
	public void save(Period period) {
		repository.save(period);
	}

	@Override
	public List<Period> findAvailable(LocalDate date) {
		return repository.findAllByIdDateBefore(date);
	}

	@Override
	public Optional<Period> findLast() {
		return repository.findTop1ByOrderByIdDateDescEndTimeDesc().stream().findAny();
	}
}
