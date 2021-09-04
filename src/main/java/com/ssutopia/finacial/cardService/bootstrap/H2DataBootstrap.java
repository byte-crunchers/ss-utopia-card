package com.ssutopia.finacial.cardService.bootstrap;

import com.ssutopia.finacial.cardService.entity.CardType;
import com.ssutopia.finacial.cardService.entity.User;
import com.ssutopia.finacial.cardService.repository.CardTypeRepository;
import com.ssutopia.finacial.cardService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class H2DataBootstrap implements CommandLineRunner {
    private final CardTypeRepository cardTypeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public void run(String... args) throws Exception {
        if(cardTypeRepository.count()==0){
            loadAllCardType();
            loadUser();
        }
    }


    private void loadUser(){
        var User1 = User.builder()
                .id(1L)
                .username("dan")
                .password(passwordEncoder.encode("dan123"))
                .roles("USER")
                .permissions("")
                .build();

        userRepository.save(User1);

        var User2 = User.builder()
                .id(2L)
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .permissions("ACCESS_TEST1,ACCESS_TEST2")
                .build();

        userRepository.save(User2);

        var User3 = User.builder()
                .id(3L)
                .username("manager")
                .password(passwordEncoder.encode("manager123"))
                .roles("MANAGER")
                .permissions("ACCESS_TEST1")
                .build();

        userRepository.save(User3);

    }




    private void loadAllCardType(){
        var CardType1 = CardType.builder()
                .id(1L)
                .cardName("Lili Debit")
                .cardType("Debit")
                .annualFee(0)
                .cashBack(0.0f)
                .lateFee(0)
                .apr(0.0f)
                .foodiesPointsPercentages(0.00f)
                .build();
        cardTypeRepository.save(CardType1);

        var CardType2 = CardType.builder()
                .id(2L)
                .cardName("Bear Credit")
                .cardType("Credit")
                .annualFee(0)
                .cashBack(0.03f)
                .lateFee(29)
                .apr(0.15f)
                .foodiesPointsPercentages(0.00f)
                .build();
        cardTypeRepository.save(CardType2);

        var CardType3 = CardType.builder()
                .id(3L)
                .cardName("Platinum Credit")
                .cardType("Credit")
                .annualFee(200)
                .cashBack(0.08f)
                .lateFee(29)
                .apr(0.15f)
                .foodiesPointsPercentages(0.00f)
                .build();
        cardTypeRepository.save(CardType3);

        var CardType4 = CardType.builder()
                .id(4L)
                .cardName("Plus Credit")
                .cardType("Credit")
                .annualFee(0)
                .cashBack(0.01f)
                .lateFee(29)
                .foodiesPointsPercentages(0.00f)
                .apr(0.0499f)
                .build();
        cardTypeRepository.save(CardType4);

        var CardType5 = CardType.builder()
                .id(5L)
                .cardName("Foodies Credit")
                .cardType("Credit")
                .annualFee(0)
                .cashBack(0.01f)
                .lateFee(29)
                .apr(0.0499f)
                .foodiesPointsPercentages(0.004f)
                .build();
        cardTypeRepository.save(CardType5);
    }

}
