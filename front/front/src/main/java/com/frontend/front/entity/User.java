package com.frontend.front.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long userId;
    private String name;
    private String dob;
    private String gender;
    private String email;
    private String password;

}
