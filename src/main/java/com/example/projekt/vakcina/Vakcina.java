package com.example.projekt.Vakcina;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Vakcina {

    private int id;
    private String nazov;
    private int pocet_davok;

}
