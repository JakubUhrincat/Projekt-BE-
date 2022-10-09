package com.example.projekt.Osoba;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class OsobaEntity {
    @Id
    @GeneratedValue
    private int id;
    private String meno;
    private String priezvisko;
    private String rok_nar;
    private String rod_cislo;
    private String bydlisko;
    private String pohlavie;
    private String tel_cislo;

}