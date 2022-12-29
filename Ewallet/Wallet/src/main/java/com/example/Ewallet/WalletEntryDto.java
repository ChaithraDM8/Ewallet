package com.example.Ewallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntryDto {
    @Column(unique = true)
    private String userName;
    private String password;
    private int amount;
}
