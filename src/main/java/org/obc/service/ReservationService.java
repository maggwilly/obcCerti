package org.obc.service;

import java.util.Optional;

import org.obc.entity.Reservation;
import org.obc.exception.UnavailablePeriodException;

public interface ReservationService {
	Reservation save(Reservation reservation) throws UnavailablePeriodException;

	Optional<Reservation> findById(String id);
}
