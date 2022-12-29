package com.example.Ewallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntryDto {

    @Column(unique = true)
    private String userName;

    private String name;
    private String phoneNum;
    private String email;
    private String password;
}
