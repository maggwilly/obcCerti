package org.obc.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.obc.entity.Period;
import org.obc.entity.PeriodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, PeriodId> {

	List<Period> findTop1ByOrderByIdDateDescEndTimeDesc() ;

	@Query("SELECT p FROM Period  p WHERE p.id.date<=:localDate")
	List<Period> findAvailableBefore(@Param("localDate") LocalDate localDate) ;

	@Query("SELECT p FROM Period  p  WHERE p.id.date=:localDate AND p.id.startTime=:time")
	List<Period> findAvailableOnDateAndTime(@Param("localDate") LocalDate localDate,@Param("time") LocalTime time) ;
}
