package org.example.service;

import org.example.dto.TipNotifikacijeDto;
import org.example.dto.TipPorukeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotifikacijaService {
    Page<TipPorukeDto> findAllAdmin(Pageable pageable);
    List<TipPorukeDto> findAllUser(Long id, String authorization);
    List<TipPorukeDto> findAllMenadzer(Long id, String authorization);
    TipNotifikacijeDto addNewNotification(TipNotifikacijeDto tipNotifikacijeDto);
    void deleteNotification(Long id);
}
