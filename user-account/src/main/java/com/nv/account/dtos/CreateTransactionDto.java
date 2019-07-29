package com.nv.account.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateTransactionDto {

    private Float amount;

}
