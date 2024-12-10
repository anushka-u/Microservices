package com.roombooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name="booking_id",nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private LocalDate paymentDate;
    @Column(nullable = false)
    private String paymentStatus;
    @Column(nullable = false)
    private int amountToPay;
}
