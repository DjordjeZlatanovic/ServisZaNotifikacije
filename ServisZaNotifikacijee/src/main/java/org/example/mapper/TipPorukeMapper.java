package org.example.mapper;

import org.example.domain.TipPoruke;
import org.example.dto.TipPorukeDto;
import org.springframework.stereotype.Component;

@Component
public class TipPorukeMapper {

    public TipPorukeDto tipPorukeToTipPorukeDto(TipPoruke tipPoruke){
        TipPorukeDto tipPorukeDto = new TipPorukeDto();
        tipPorukeDto.setTipNotifikacije(tipPoruke.getTipNotifikacije());
        tipPorukeDto.setKome(tipPoruke.getKome());
        tipPorukeDto.setText(tipPoruke.getText());
        tipPorukeDto.setVremeKreiranja(tipPoruke.getVremeKreiranja());
        return tipPorukeDto;
    }
}
