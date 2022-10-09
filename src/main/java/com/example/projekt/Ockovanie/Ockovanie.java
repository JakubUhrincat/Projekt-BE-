package com.example.projekt.Ockovanie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class Ockovanie {
    private int id;
    private int osobaId;
    private int vakcinaId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datum;

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;

    }
}