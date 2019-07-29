package com.nv.account.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionDto {
    private Long id;
    private Float amount;
    private Date createdAt;
}
