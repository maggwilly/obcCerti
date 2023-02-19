package org.obc.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateUtils {
	public static List<LocalDate> getBusinessDaysBetween(final LocalDate startDate, final LocalDate endDate, final List<LocalDate> holidays) {
		final Predicate<LocalDate> isHoliday = holidays::contains;

		final Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

		return Stream.iterate(startDate, date -> date.plusDays(1))
				.limit(daysBetween)
				.filter(isHoliday.or(isWeekend).negate())
				.collect(Collectors.toList());
	}
}
