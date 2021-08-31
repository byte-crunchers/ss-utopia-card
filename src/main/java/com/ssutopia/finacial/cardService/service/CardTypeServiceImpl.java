package com.ssutopia.finacial.cardService.service;

import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.exception.DuplicateCardNameException;
import com.ssutopia.finacial.cardService.repository.CardTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CardTypeServiceImpl implements CardTypeService{

    private final CardTypeRepository cardTypeRepository;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    @Override
    public List<CardType> getAllCardTypes() {
        return cardTypeRepository.findAll();
    }

    @Override
    @Transactional
    public CardType createNewCardType(CardTypeDto cardTypeDto) {
        validateDto(cardTypeDto);
        log.debug("Create new account type=" + cardTypeDto.getCardName());
        cardTypeRepository.findByCardName(cardTypeDto.getCardName()).
                ifPresent(cardType -> {
                    throw new DuplicateCardNameException(cardTypeDto.getCardName());
                });

        var cardType = CardType.builder()
                .cardName(cardTypeDto.getCardName())
                .apr(cardTypeDto.getApr())
                .foodiesPointsPercentages(cardTypeDto.getFoodiesPointsPercentages())
                .annualFee(cardTypeDto.getAnnualFee())
                .lateFee(cardTypeDto.getLateFee())
                .cashBack(cardTypeDto.getCashBack())
                .build();

        cardType = cardTypeRepository.save(cardType);
        return  cardType;
    }

    private void validateDto(CardTypeDto cardTypeDto) {
        var violations = validator.validate(cardTypeDto);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid DTO " + cardTypeDto);
        }
    }
}
