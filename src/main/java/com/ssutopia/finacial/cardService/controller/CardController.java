package com.ssutopia.finacial.cardService.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ssutopia.finacial.cardService.entity.Card;
import com.ssutopia.finacial.cardService.entity.CardForm;
import com.ssutopia.finacial.cardService.service.CardService;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardService cardService;

	// receive card application form & print to console
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<?> applyForCard(@RequestBody CardForm newCardForm) {
		System.out.println("Received new card application form:");
		newCardForm.printFields();

		delay();

		Card card = cardService.createNewCard(newCardForm);
		System.out.println("Created a new card instance:");
		card.printFields();

		// set location header
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(card.getCardNum())
				.toUri();

		// return status code 201
		return ResponseEntity.created(location).build();
	}

	// get a single card instance
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<Card> getCard(@PathVariable Long id) {
		return cardService.getCard(id);
	}

	// pretend to think for a few seconds while processing the form
	private void delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	@GetMapping(path = "/test", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String Test(){
			return "Hi";
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
