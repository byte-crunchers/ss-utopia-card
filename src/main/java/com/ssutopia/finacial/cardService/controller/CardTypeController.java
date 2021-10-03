package com.ssutopia.finacial.cardService.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.service.CardTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(EndpointConstants.API_V_0_1_CARDTYPES)
public class CardTypeController {
    public static final String MAPPING = EndpointConstants.API_V_0_1_CARDTYPES;
    private final CardTypeService cardTypeService;

    //create card type
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CardType> createNewCardType(@Valid @RequestBody CardTypeDto cardTypeDto){
        var cardType = cardTypeService.createNewCardType(cardTypeDto);
        var uri = URI.create(MAPPING+"/"+cardType.getId());
        return ResponseEntity.created(uri).body(cardType);
    }

    //get card type
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CardType>> getAllCardTypes(){
        List<CardType> CardType = cardTypeService.getAllCardTypes();
        if(CardType.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CardType);
    }

}
