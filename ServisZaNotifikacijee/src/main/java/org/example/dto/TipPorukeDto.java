package org.example.dto;

import org.example.domain.TipNotifikacije;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TipPorukeDto {

    private String text;
    private String kome;
    private LocalDate vremeKreiranja;
    private TipNotifikacije tipNotifikacije;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKome() {
        return kome;
    }

    public void setKome(String kome) {
        this.kome = kome;
    }

    public LocalDate getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(LocalDate vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public TipNotifikacije getTipNotifikacije() {
        return tipNotifikacije;
    }

    public void setTipNotifikacije(TipNotifikacije tipNotifikacije) {
        this.tipNotifikacije = tipNotifikacije;
    }
}
