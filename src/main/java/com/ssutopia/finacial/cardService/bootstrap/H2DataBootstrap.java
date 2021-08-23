package com.ssutopia.finacial.cardService.bootstrap;

import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.repository.CardTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class H2DataBootstrap implements CommandLineRunner {
    private final CardTypeRepository cardTypeRepository;
    @Override
    public void run(String... args) throws Exception {
        if(cardTypeRepository.count()==0){
            loadAllCardType();
        }
    }

    private void loadAllCardType(){
        var CardType1 = CardType.builder()
                .id(1L)
                .cardName("Debit")
                .annualFee(0)
                .cashBack(0.0f)
                .lateFee(0)
                .apr(0.0f)
                .build();
        cardTypeRepository.save(CardType1);

        var CardType2 = CardType.builder()
                .id(2L)
                .cardName("Credit")
                .annualFee(0)
                .cashBack(0.03f)
                .lateFee(29)
                .apr(0.15f)
                .build();
        cardTypeRepository.save(CardType2);

        var CardType3 = CardType.builder()
                .id(3L)
                .cardName("Platinum Credit")
                .annualFee(200)
                .cashBack(0.08f)
                .lateFee(29)
                .apr(0.15f)
                .build();
        cardTypeRepository.save(CardType3);

        var CardType4 = CardType.builder()
                .id(4L)
                .cardName("Plus Credit")
                .annualFee(0)
                .cashBack(0.01f)
                .lateFee(29)
                .apr(0.0499f)
                .build();
        cardTypeRepository.save(CardType4);
    }

}
