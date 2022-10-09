package com.example.projekt.Osoba;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Osoba {
    private int id;
    private String meno;
    private String priezvisko;
    private String rok_nar;
    private String rod_cislo;
    private String bydlisko;
    private String pohlavie;
    private String tel_cislo;

}


