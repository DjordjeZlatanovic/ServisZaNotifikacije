package org.example.repository;

import org.example.domain.TipNotifikacije;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipNotifikacijeRepository extends JpaRepository<TipNotifikacije, Long> {
    Optional<TipNotifikacije> findTipNotifikacijeByIme(String name);
    Optional<TipNotifikacije> findTipNotifikacijeById(Long id);
}
