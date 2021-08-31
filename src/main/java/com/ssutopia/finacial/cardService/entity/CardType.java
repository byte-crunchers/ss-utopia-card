package com.ssutopia.finacial.cardService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cardName;

    @Builder.Default
    private int annualFee = 0;

    @Builder.Default
    private float apr = 0.00f;

    @Builder.Default
    private float foodiesPointsPercentages = 0.0f;

    @Builder.Default
    private float cashBack = 0.00f;

    @Builder.Default
    private int lateFee = 0;


}
