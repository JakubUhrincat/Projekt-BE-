package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Vakcina.VakcinaEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "OckovanieEntity")
public class OckovanieEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "osoba")
    private OsobaEntity osoba;
    @ManyToOne
    @JoinColumn(name = "vakcina")
    private VakcinaEntity vakcina;

    @Column(columnDefinition = "DATE")
    private LocalDate datum;

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
