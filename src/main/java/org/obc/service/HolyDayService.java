package org.obc.service;

import java.time.LocalDate;
import java.util.List;

import org.obc.entity.HolyDay;

public interface HolyDayService {
	List<HolyDay> findBetween(LocalDate from,LocalDate to);
}
