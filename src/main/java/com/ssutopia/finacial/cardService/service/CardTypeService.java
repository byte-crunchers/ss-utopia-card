package com.ssutopia.finacial.cardService.service;

import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;

import java.util.List;

public interface CardTypeService {
    List<CardType> getAllCardTypes();
    CardType createNewCardType(CardTypeDto cardTypeDto);
}
