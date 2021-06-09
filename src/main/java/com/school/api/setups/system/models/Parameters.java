package com.school.api.setups.system.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="sch_sys_parameters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parameters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="param_id")
    private Long paramCode;

    @Column(name="param_name")
    private String paramName;

    @Column(name="param_desc")
    private String paramDesc;

    @Column(name="param_value")
    private String paramValue;

    @Column(name="param_type")
    private String paramType;

    @Column(name="param_used")
    private String paramUsed;

}
