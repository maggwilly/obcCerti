package org.obc;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

import org.obc.entity.HolyDay;
import org.obc.entity.Period;
import org.obc.service.HolyDayService;
import org.obc.service.PeriodService;
import org.obc.util.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PeriodGenerator {
	private final PeriodService periodService;
	private final HolyDayService holyDayService;
	@Value("${period.generate.interval}")
	private Duration duration;
	@Value("${period.start.dayTime}")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startDayTime;
	@Value("${period.end.dayTime}")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime endDayTime;

	private
	//@Scheduled(cron = "${period.rate.cron.expression}")
	@Scheduled(fixedRate = 5000)
	void generatePeriods() {
		final var startDate = periodService.findLast().map(PeriodGenerator::getLocalDateTime).orElse(LocalDateTime.now());
		final var endDate = startDate.plus(duration);
		final var holyDays = holyDayService.findBetween(startDate.toLocalDate(), endDate.toLocalDate()).stream().map(HolyDay::getDate).collect(Collectors.toList());

		DateUtils.getBusinessDaysBetween(startDate.toLocalDate(), endDate.toLocalDate(), holyDays).forEach(localDate -> {
			final var start = localDate.atTime(startDayTime);
			final var end = localDate.atTime(endDayTime);
			periodService.generate(start, end);
		});
	}

	private static LocalDateTime getLocalDateTime(Period period) {
		return period.getDate().atTime(period.getEndTime()).plusDays(1);
	}
}
