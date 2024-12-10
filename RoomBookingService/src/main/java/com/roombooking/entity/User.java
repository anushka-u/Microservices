package com.roombooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="USER")  // Consider renaming to avoid SQL keyword conflict
@Data
@AllArgsConstructor
public class User {

    @Id
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String phoneNumber;
}
