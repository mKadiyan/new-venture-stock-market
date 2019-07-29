package com.nv.account.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;

    private Float balance;

    private Long userId;

    private Boolean enabled = Boolean.TRUE;

    private List<TransactionDto> transactions;
}
