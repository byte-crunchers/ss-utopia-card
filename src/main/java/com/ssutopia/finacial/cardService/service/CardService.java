package com.ssutopia.finacial.cardService.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssutopia.finacial.cardService.entity.Card;
import com.ssutopia.finacial.cardService.entity.CardForm;
import com.ssutopia.finacial.cardService.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	private int accountsId = 1; // placeholder test account
	private Random rand = new Random();

	// generate a new card when form is submitted
	public Card createNewCard(CardForm form) {

		// generate 16 digit card number
		Long cardId = (long) (2319L * Math.pow(10, 12) + random4Digits() * Math.pow(10, 8)
				+ random4Digits() * Math.pow(10, 4) + random4Digits());

		// save new card instance
		Card card = new Card(cardId, accountsId, random4Digits(), random3Digits(), random3Digits(),
				LocalDate.now().plusYears(3), true);
		return cardRepository.save(card);
	}

	// get 1 card by card number
	public Optional<Card> getCard(Long id) {
		return cardRepository.findById(id);
	}

	private int random4Digits() {
		return 1000 + rand.nextInt(9000); // range 1000 - 9999;
	}

	private int random3Digits() {
		return 100 + rand.nextInt(900); // range 100 - 999;
	}
}
