package com.school.api.setups.system.repo;

import com.school.api.setups.system.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepo extends JpaRepository<Organization, Long> {
    Organization findByOrgCode(Long orgCode);
}
