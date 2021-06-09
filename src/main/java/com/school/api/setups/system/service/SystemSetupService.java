package com.school.api.setups.system.service;

import com.school.api.setups.system.models.Organization;
import com.school.api.setups.system.models.Parameters;
import com.school.api.setups.system.models.Sequences;

import java.util.List;

public interface SystemSetupService {
    String createOrganization(Organization org);

    List<Organization> getOrgs();

    void deleteOrg(Long code);

    List<Parameters> getParameters();

    Long countParams();

    String createParameters(Parameters parameters);

    void deleteParameters(Long code);

    List<Sequences> getSequences();

    Long countSequences();

    String createSequences(Sequences sequences);

    void deleteSequence(Long code);
}
