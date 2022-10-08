package com.example.projekt.Vakcina;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class VakcinaEntity {
    @Id
    @GeneratedValue
    private int id;
    private String nazov;
    private int pocet_davok;
}