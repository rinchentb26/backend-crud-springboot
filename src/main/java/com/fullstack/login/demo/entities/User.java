package com.fullstack.login.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{

    @SequenceGenerator(name = "id_sequence",sequenceName = "id_sequence",allocationSize = 1,initialValue = 100)
    @GeneratedValue(generator = "id_sequence",strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="Name")
    private String userName;
    @Column(name="Emp_id",unique = true)
    private String userEmpId;
    @Column(name="Email",unique = true)
    private String emailId;
    @Column(name="Password")
    private String password;
}
