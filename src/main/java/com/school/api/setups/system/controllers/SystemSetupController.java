package com.school.api.setups.system.controllers;

import com.school.api.setups.system.models.Parameters;
import com.school.api.setups.system.models.Sequences;
import com.school.api.setups.system.service.SystemSetupService;
import com.school.api.utils.BadRequestException;
import com.school.api.utils.DataTable;
import com.school.api.utils.ResponseData;
import org.springframework.web.bind.annotation.*;
import com.school.api.setups.system.models.Organization;
import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/setups/system")
public class SystemSetupController {


    private SystemSetupService systemSetupService;

    public SystemSetupController(SystemSetupService systemSetupService) {
        this.systemSetupService = systemSetupService;
    }


    @PostMapping("/createOrganisation")
    @ResponseBody
    public ResponseData createOrganization(Organization org) throws ParseException, IOException {

        if (org.getLogo() != null) {
            org.setOrgLogo(org.getLogo().getBytes());
        }
        String message = systemSetupService.createOrganization(org);
        return new ResponseData("200", message);
    }
    @PostMapping("/createParameters")
    @ResponseBody
    public ResponseData createParameters(@RequestBody Parameters parameters) throws ParseException, IOException {
        if (parameters.getParamUsed().equalsIgnoreCase("true")){
            parameters.setParamUsed("Yes");
        }
        else{
            parameters.setParamUsed("No");
        }
        String message = systemSetupService.createParameters(parameters);

        return new ResponseData("200", message);
    }
    @PostMapping("/createSequences")
    @ResponseBody
    public ResponseData createSequences(@RequestBody Sequences sequences) throws ParseException, IOException {

        String message = systemSetupService.createSequences(sequences);

        return new ResponseData("200", message);
    }
    @GetMapping("/deleteParameter/{code}")
    @ResponseBody
    public ResponseData deleteParameters(@PathVariable Long code) {
       systemSetupService.deleteParameters(code);
        return new ResponseData("200", "Parameter Deleted successfully");
    }
    @GetMapping("/deleteSequence/{code}")
    @ResponseBody
    public ResponseData deleteSequence(@PathVariable Long code) {
        systemSetupService.deleteSequence(code);
        return new ResponseData("200", "Sequence Deleted successfully");
    }
    @GetMapping("/deleteOrganization/{code}")
    @ResponseBody
    public ResponseData deleteOrganization(@PathVariable Long code) {
        systemSetupService.deleteOrg(code);
        return new ResponseData("200", "Organization Deleted successfully");
    }

    @GetMapping("/getOrganization")
    @ResponseBody
    public Organization getOrganisations() {


        List<Organization> orgs = systemSetupService.getOrgs();
        if (orgs.isEmpty()) {
            Organization o = new Organization();
            o.setStatus("empty");
            return o;
        } else {
            Organization o = orgs.get(0);
            if (o.getOrgLogo() != null) {
                String encode = Base64.getEncoder().withoutPadding().encodeToString(o.getOrgLogo());
                o.setEncoded(encode);
            }
            o.setStatus("data");
            return o;
        }
    }

    @GetMapping("/getParameters")
    @ResponseBody
    public DataTable<Parameters> getParameters() {

        List<Parameters> params = systemSetupService.getParameters();
        Long count = systemSetupService.countParams();
        return new DataTable<>(count,params);
    }
    @GetMapping("/getSequences")
    @ResponseBody
    public DataTable<Sequences> getSequences() {

        List<Sequences> params = systemSetupService.getSequences();
        Long count = systemSetupService.countSequences();
        return new DataTable<>(count,params);
    }
}
