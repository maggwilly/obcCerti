package org.obc.exception;

import java.time.LocalTime;

public class ErrorUtils {
	public static UnavailablePeriodException unavailablePeriod(LocalTime startTime) {
		return new UnavailablePeriodException("Unavailable period of time");
	}
}
