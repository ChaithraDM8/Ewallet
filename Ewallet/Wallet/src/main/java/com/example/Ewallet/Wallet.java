package com.example.Ewallet;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column(unique = true)
    private String userName;

    private String password;
    private int amount;
}
