package com.ssutopia.finacial.cardService.controller;

import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(EndpointConstants.API_V_0_1_CARDTYPES)
public class CardTypeController {
    public static final String MAPPING = EndpointConstants.API_V_0_1_CARDTYPES;
    private final CardTypeService cardTypeService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CardType> createNewCardType(@Valid @RequestBody CardTypeDto cardTypeDto){
        var cardType = cardTypeService.createNewCardType(cardTypeDto);
        var uri = URI.create(MAPPING+"/"+cardType.getId());
        return ResponseEntity.created(uri).body(cardType);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CardType>> getAllCardTypes(){
        List<CardType> CardType = cardTypeService.getAllCardTypes();
        if(CardType.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CardType);
    }



}