package org.example.repository;

import org.example.domain.TipPoruke;
import org.example.dto.TipPorukeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipPorukeRepository extends JpaRepository<TipPoruke, Long> {
    List<TipPoruke> findTipPorukeByKome(String kome);
}
