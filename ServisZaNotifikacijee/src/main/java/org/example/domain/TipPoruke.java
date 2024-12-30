package org.example.domain;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class TipPoruke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String kome;
    private LocalDate vremeKreiranja;
    @ManyToOne
    private TipNotifikacije tipNotifikacije;

    public LocalDate getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(LocalDate vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public String getKome() {
        return kome;
    }

    public void setKome(String kome) {
        this.kome = kome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipNotifikacije getTipNotifikacije() {
        return tipNotifikacije;
    }

    public void setTipNotifikacije(TipNotifikacije tipNotifikacije) {
        this.tipNotifikacije = tipNotifikacije;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


