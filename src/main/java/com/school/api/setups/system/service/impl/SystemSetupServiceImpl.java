package com.school.api.setups.system.service.impl;

import com.school.api.setups.system.models.Organization;
import com.school.api.setups.system.models.Parameters;
import com.school.api.setups.system.models.Sequences;
import com.school.api.setups.system.repo.OrgRepo;
import com.school.api.setups.system.repo.ParamRepo;
import com.school.api.setups.system.repo.SeqRepo;
import com.school.api.setups.system.service.SystemSetupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSetupServiceImpl implements SystemSetupService {

    private OrgRepo orgRepo;
    private ParamRepo paramRepo;
    private SeqRepo seqRepo;

    public SystemSetupServiceImpl(OrgRepo orgRepo, ParamRepo paramRepo, SeqRepo seqRepo) {
        this.orgRepo = orgRepo;
        this.paramRepo = paramRepo;
        this.seqRepo = seqRepo;
    }

    @Override
    public String createOrganization(Organization org) {
        String message = "";
        if(org.getOrgCode() == 0){
           orgRepo.save(org);
           message = "Institution Created Successfully";
        }
        else{
          Organization o = orgRepo.findByOrgCode(org.getOrgCode());
          o.setName(org.getName());
          o.setDescription(org.getDescription());
          o.setAddress(org.getAddress());
          o.setBox(org.getBox());
          o.setTelNo(org.getTelNo());
          o.setCellNo(org.getCellNo());
          o.setEmail(org.getEmail());
          o.setWebsite(org.getWebsite());
          o.setMission(org.getMission());
          o.setMotto(org.getMotto());
          o.setVision(org.getVision());
          if(org.getOrgLogo() != null){
              o.setOrgLogo(org.getOrgLogo());
          }
          orgRepo.save(o);
            message = "Institution Updated Successfully";
        }
        return message;
    }

    @Override
    public String createParameters(Parameters parameters) {
        String message = "";
        if(parameters.getParamCode() == 0) {
            paramRepo.save(parameters);
            message="Parameter created successfully";
        }
        else{
            Parameters p = paramRepo.findByParamCode(parameters.getParamCode());
            p.setParamName(parameters.getParamName());
            p.setParamValue(parameters.getParamValue());
            p.setParamUsed(parameters.getParamUsed());
            p.setParamDesc(parameters.getParamDesc());
            p.setParamType(parameters.getParamType());
            paramRepo.save(p);
            message="Parameter updated successfully";

        }
        return message;
    }

    @Override
    public List<Organization> getOrgs() {

        return orgRepo.findAll();

    }

    @Override
    public void deleteOrg(Long code) {
        orgRepo.deleteById(code);
    }

    @Override
    public void deleteParameters(Long code) {
        paramRepo.deleteById(code);
    }

    @Override
    public void deleteSequence(Long code) {
        seqRepo.deleteById(code);
    }

    @Override
    public List<Parameters> getParameters() {
        return paramRepo.findAll();
    }

    @Override
    public Long countParams() {
        return paramRepo.count();
    }

    @Override
    public List<Sequences> getSequences() {
        return seqRepo.findAll();
    }

    @Override
    public Long countSequences() {
        return seqRepo.count();
    }

    @Override
    public String createSequences(Sequences sequences) {
        String message = "";
        if(sequences.getSeqCode() == 0) {
            seqRepo.save(sequences);
            message="Sequence created successfully";
        }
        else{
            Sequences p = seqRepo.findBySeqCode(sequences.getSeqCode());
            p.setSeqName(sequences.getSeqName());
            p.setSeqValue(sequences.getSeqValue());
            p.setDepartment(sequences.getDepartment());
            seqRepo.save(p);
            message="Sequence updated successfully";

        }
        return message;
    }
}
