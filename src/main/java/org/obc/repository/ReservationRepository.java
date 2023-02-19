package org.obc.repository;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.obc.entity.Period;
import org.obc.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
	@Query("SELECT r FROM Reservation r WHERE r.period.id.date=:localDate ORDER BY r.period.id.startTime DESC")
	List<Reservation> findLastReservation(@Param("localDate") LocalDate localDate) ;
	Optional<Reservation> findByPeriod(Period period) ;
}
