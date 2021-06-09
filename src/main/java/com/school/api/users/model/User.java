package com.school.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="sch_sys_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_username")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="user_firstname")
    private String firstName;

    @Column(name="user_othernames")
    private String otherNames;

    @Column(name="user_type")
    private String userType;

    @Column(name="user_password")
    private String password;

    @Column(name="user_active")
    private String active;

    @Column(name="user_gender")
    private String gender;

    @Column(name="user_phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name="user_superior")
    private User reportsTo;



}
