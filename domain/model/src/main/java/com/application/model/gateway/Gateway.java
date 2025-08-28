package com.application.model.gateway;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Gateway {

    private Long userId;
    private String name;
    private String email;

}