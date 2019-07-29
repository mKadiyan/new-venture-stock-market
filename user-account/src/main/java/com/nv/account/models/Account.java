package com.nv.account.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_number_seq",
            sequenceName = "account_number_seq",
            allocationSize = 1,
            initialValue = 100000

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_number_seq")
    private Long id;

    @Column(columnDefinition = "balance")
    private Float balance = 0.0f;

    @Column(columnDefinition = "user_id")
    private Long userId;

    @Column(columnDefinition = "enabled")
    private Boolean enabled = Boolean.TRUE;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
