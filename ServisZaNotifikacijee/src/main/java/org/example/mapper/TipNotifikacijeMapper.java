package org.example.mapper;

import org.example.domain.TipNotifikacije;
import org.example.dto.TipNotifikacijeDto;
import org.springframework.stereotype.Component;

@Component
public class TipNotifikacijeMapper {

    public TipNotifikacije tipNotifikacijeDtoToTipNotifikacije(TipNotifikacijeDto tipNotifikacijeDto){
        TipNotifikacije tipNotifikacije = new TipNotifikacije();
        tipNotifikacije.setIme(tipNotifikacijeDto.getIme());
        return tipNotifikacije;
    }
}
