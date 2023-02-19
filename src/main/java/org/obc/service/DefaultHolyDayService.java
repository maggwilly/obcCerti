package org.obc.service;

import java.time.LocalDate;
import java.util.List;

import org.obc.entity.HolyDay;
import org.obc.repository.HolyDayRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultHolyDayService implements HolyDayService{
	private final HolyDayRepository repository;
	@Override
	public List<HolyDay> findBetween(LocalDate from, LocalDate to) {
		return repository.findBetween(from,to);
	}
}
