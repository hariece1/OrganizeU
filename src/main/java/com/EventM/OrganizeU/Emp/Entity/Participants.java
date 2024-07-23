package com.EventM.OrganizeU.Emp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 70)
    private String college;

    @Column(nullable = false, unique = true, length = 15)
    private String rollno;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 25)
    private String mobile;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Column(nullable = false)
    private int status;

    private int eventno;


}
