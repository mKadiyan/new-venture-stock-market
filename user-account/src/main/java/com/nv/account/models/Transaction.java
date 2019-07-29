package com.nv.account.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "account_transaction")
public class Transaction extends AuditModel {

    @Id
    @SequenceGenerator(
            name = "account_transaction_id_seq",
            sequenceName = "account_transaction_id_seq",
            allocationSize = 1,
            initialValue = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_transaction_id_seq")
    private Long id;

    @Column(columnDefinition = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
