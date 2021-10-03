package com.ssutopia.finacial.cardService.entity;

import java.lang.reflect.Field;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * A card is generated when a user submits a card application form.
 * Stored in the 'cards' table in the database.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {

	// all columns in the cards table
	@Id
	private Long cardNum;
	private Integer accountsId;
	private Integer pin, cvc1, cvc2;
	private LocalDate expDate;
	private Boolean isActive;

	public Card(Long cardNum, Integer accountsId, Integer pin, Integer cvc1, Integer cvc2, LocalDate expDate,
			Boolean isActive) {
		super();
		this.cardNum = cardNum;
		this.accountsId = accountsId;
		this.pin = pin;
		this.cvc1 = cvc1;
		this.cvc2 = cvc2;
		this.expDate = expDate;
		this.isActive = isActive;
	}

	// print all variables to console
	public void printFields() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append("{" + newLine);

		// determine fields declared in this class only (no fields of superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names paired with their values
		for (Field field : fields) {
			try {
				result.append("    " + field.getName() + " = " + field.get(this) + newLine);
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
		}
		result.append("}");

		System.out.println(result.toString());
	}

}
