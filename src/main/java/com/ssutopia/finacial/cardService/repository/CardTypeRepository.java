package com.ssutopia.finacial.cardService.repository;

import com.ssutopia.finacial.cardService.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType,Long> {
    Optional<CardType> findByCardName(String CardName);
}
