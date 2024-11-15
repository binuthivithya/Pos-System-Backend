package com.ijse.cmjdfinal.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemReqDto {

    private String name;
    private String description;
    private double price;
    private Long categoryId;
    private Long stockId;
}
