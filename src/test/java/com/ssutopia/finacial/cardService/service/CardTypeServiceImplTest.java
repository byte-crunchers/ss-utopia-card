package com.ssutopia.finacial.cardService.service;

import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.exception.DuplicateCardNameException;
import com.ssutopia.finacial.cardService.repository.CardTypeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CardTypeServiceImplTest {
    private static CardType card1, card2, card3;
    private static CardTypeDto cardTypeDto;
    private final CardTypeRepository repository = Mockito.mock(CardTypeRepository.class);
    private final CardTypeService service = new CardTypeServiceImpl(repository);

    @BeforeAll
    static void beforeAll(){
        card1 = CardType.builder()
                .id(1L)
                .cardName("test1")
                .build();

        card2 = CardType.builder()
                .id(2L)
                .cardName("test2")
                .build();


        card3 = CardType.builder()
                .id(3L)
                .cardName("test3")
                .build();

    }

    @BeforeEach
    void beforeEach() {
        Mockito.reset(repository);
    }

    @Test
    void test_createNewCardTypes_ReturnsCardTypesWithExpectedValuesOnSuccess() {
        when(repository.save(any(CardType.class))).thenReturn(card1);
        var result = service.createNewCardType(cardTypeDto.builder()
                .cardName(card1.getCardName())
                .build())
                ;
        assertEquals(card1, result);
    }
    @Test
    void test_getAllCardTypes_ReturnsAllCardTypes() {
        when(repository.findAll()).thenReturn(List.of(card1,card2,card3));

        var cardTypes = service.getAllCardTypes();
        var expectedCardTypes = List.of(card1,card2,card3);

        assertEquals(expectedCardTypes, cardTypes);
    }

    @Test
    void test_createNewCardType_ThrowsDuplicateCardTypeNameExceptionOnDuplicateLoanTypeNameRecord() {
        when(repository.findByCardName(card1.getCardName())).thenReturn(Optional.of(card1));

//        repository.save(loan2);
        assertThrows(DuplicateCardNameException.class,
                () -> service.createNewCardType(cardTypeDto.builder()
                        .cardName(card1.getCardName())
                        .build()));
    }

}
