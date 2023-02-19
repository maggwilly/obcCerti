package org.obc.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.obc.entity.Candidate;
import org.obc.entity.Reservation;
import org.obc.exception.ErrorUtils;
import org.obc.exception.UnavailablePeriodException;
import org.obc.service.PeriodService;
import org.obc.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReservationController {
	@Resource
	private PeriodService periodService;
	@Resource
	private ReservationService reservationService;

	@GetMapping("/schedule/{date}/{startTime}")
	public String createReservation(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable("startTime") @DateTimeFormat(pattern = "HH:mm") LocalTime startTime, Model model) throws UnavailablePeriodException {
		final var availableOnDateAndTime = periodService.findAvailableOnDateAndTime(date, startTime);
		final var period = availableOnDateAndTime.stream().findAny().orElseThrow(() -> ErrorUtils.unavailablePeriod(startTime));
		final var candidate = Candidate.builder().build();
		final var reservation = Reservation.builder().candidate(candidate).period(period).build();
		model.addAttribute("reservation", reservation);
		return "reservation_form";
	}

	@PostMapping("/schedule")
	public RedirectView saveReservation(@Valid Reservation reservation) throws UnavailablePeriodException {
		final var saved = reservationService.save(reservation);
		return new RedirectView("reservation/" + saved.getId());
	}

	@GetMapping("/reservation/{id}")
	public String show(@PathVariable("id") String id, Model model) {
		final var reservation = reservationService.findById(id).orElseThrow(NoSuchElementException::new);
		model.addAttribute("reservation", reservation);
		return "reservation";
	}
}
