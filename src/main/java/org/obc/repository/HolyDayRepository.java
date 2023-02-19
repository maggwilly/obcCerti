package org.obc.repository;

import java.time.LocalDate;
import java.util.List;

import org.obc.entity.HolyDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HolyDayRepository extends JpaRepository<HolyDay, LocalDate> {
	@Query("SELECT h FROM HolyDay h WHERE h.date>=:from AND h.date<=:to")
	List<HolyDay> findBetween(@Param("from") LocalDate from, @Param("to")LocalDate to);
}
