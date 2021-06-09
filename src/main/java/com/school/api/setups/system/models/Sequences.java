package com.school.api.setups.system.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="sch_sys_sequences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sequences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seq_id")
    private Long seqCode;

    @Column(name="seq_name")
    private String seqName;

    @Column(name="seq_value")
    private String seqValue;

    @Column(name="seq_dept")
    private String department;

}
