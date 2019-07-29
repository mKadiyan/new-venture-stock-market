package com.nv.account.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateAccountDto {

    @NonNull
    private Long userId;

}
