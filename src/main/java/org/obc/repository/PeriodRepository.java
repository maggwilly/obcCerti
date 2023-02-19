package org.obc.repository;

import java.time.LocalDate;
import java.util.List;

import org.obc.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

	List<Period> findTop1ByOrderByDateDescEndTimeDesc() ;

	List<Period> findAllByDateBefore(LocalDate localDate) ;
}
