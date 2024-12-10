package com.roombooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column(nullable = false)
    private int roomNumber;
    @Column(nullable = false)
    private String roomType;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private String status;
}
