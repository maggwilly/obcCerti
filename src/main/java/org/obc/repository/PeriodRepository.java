package org.obc.repository;

import java.time.LocalDate;
import java.util.List;

import org.obc.entity.Period;
import org.obc.entity.PeriodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, PeriodId> {

	List<Period> findTop1ByOrderByIdDateDescEndTimeDesc() ;

	List<Period> findAllByIdDateBefore(LocalDate localDate) ;
}
