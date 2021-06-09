package com.school.api.setups.system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="sch_sys_organization")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="org_id")
    private Long orgCode;

    @Column(name="org_name")
    private String name;

    @Column(name="org_desc")
    private String description;

    @Column(name="org_location")
    private String address;

    @Column(name="org_postal_address")
    private String box;

    @Column(name="org_tel_no")
    private  String telNo;

    @Column(name="org_cell_no")
    private String cellNo;

    @Column(name="org_email")
    private  String email;

    @Column(name="org_website")
    private String website;

    @Column(name="org_motto")
    private String motto;

    @Column(name="org_mission")
    private String mission;

    @Column(name="org_vision")
    private String vision;

    @Lob
    @JsonIgnore
    @Column(name="org_logo")
    private byte[] orgLogo;

    @Transient
    private String status;

    @Transient
    private String encoded;

    @Transient
    private MultipartFile logo;
}
