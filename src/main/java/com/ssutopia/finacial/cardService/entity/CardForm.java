package com.ssutopia.finacial.cardService.entity;

import java.lang.reflect.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Stores form data when a user submits a card application form.
 */

@Getter
@Setter
@NoArgsConstructor
public class CardForm {

	private String cardType, firstName, lastName, address, address2, city, state, zip, email, phone;

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
