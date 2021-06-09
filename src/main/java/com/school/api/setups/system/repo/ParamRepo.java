package com.school.api.setups.system.repo;

import com.school.api.setups.system.models.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParamRepo extends JpaRepository<Parameters,Long> {
    Parameters findByParamCode(Long paramCode);
}
