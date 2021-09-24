package com.ssutopia.finacial.cardService.controller;

import com.ssutopia.finacial.cardService.entity.CardForm;
import com.ssutopia.finacial.cardService.dto.CardTypeDto;
import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.service.CardTypeService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

	// receive card application form & print to console
	@PostMapping(path = "/form", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> applyForCard(@RequestBody CardForm newCardForm) {
		System.out.println("Received new card application form:");
		System.out.println(newCardForm.toString());
		delay();
		return new ResponseEntity<>("", HttpStatus.CREATED);
	}

	// pretend to think for a few seconds while processing the form
	private void delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
