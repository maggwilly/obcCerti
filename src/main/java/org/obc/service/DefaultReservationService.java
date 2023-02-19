package org.obc.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.obc.entity.Reservation;
import org.obc.exception.ErrorUtils;
import org.obc.exception.UnavailablePeriodException;
import org.obc.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultReservationService implements ReservationService {
	private final ReservationRepository repository;

	@Override
	@Transactional
	public Reservation save(@Valid Reservation reservation) throws UnavailablePeriodException {
		final var period = reservation.getPeriod();
		final var periodId = period.getId();
		final var byPeriod = repository.findByPeriod(period);
		if (byPeriod.isEmpty()) {
			final var day = periodId.getDate();
			final var candidate = reservation.getCandidate().getId();
			candidate.setDate(day);
			var integer = repository.findLastReservation(day).stream().mapToInt(Reservation::getRegistrationNumber).findFirst().orElse(0);
			reservation.setRegistrationNumber(++integer);
			return repository.save(reservation);
		}
		throw ErrorUtils.unavailablePeriod(periodId.getStartTime());
	}

	@Override
	public Optional<Reservation> findById(String id) {
		return repository.findById(id);
	}
}
