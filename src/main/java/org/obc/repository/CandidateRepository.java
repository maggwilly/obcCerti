package org.obc.repository;

import org.obc.entity.Candidate;
import org.obc.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
}
