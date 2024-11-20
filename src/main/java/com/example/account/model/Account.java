package com.example.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="accounts")
@ToString
public class Account implements Serializable {
    @Id
    private Long accountNumber;
    @Column(nullable = false, length = 100)
    private String accountName;
    private String userEmail;
    private  Double balance;

}
