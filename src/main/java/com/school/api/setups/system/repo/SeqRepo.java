package com.school.api.setups.system.repo;

import com.school.api.setups.system.models.Sequences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeqRepo extends JpaRepository<Sequences,Long> {

    Sequences findBySeqCode(Long seqCode);
}
