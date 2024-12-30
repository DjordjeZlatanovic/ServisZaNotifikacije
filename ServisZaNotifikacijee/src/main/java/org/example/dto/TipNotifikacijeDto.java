package org.example.dto;

import org.example.domain.TipNotifikacije;
import org.springframework.stereotype.Component;


public class TipNotifikacijeDto {

    private String ime;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
