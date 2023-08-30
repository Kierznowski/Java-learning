package com.AutoMarketdatabase.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auto {
    private int id;
    private String name;
    private String model;
    private int power;
}
