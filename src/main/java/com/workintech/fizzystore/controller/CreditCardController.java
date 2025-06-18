package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.CreditCardRequestDto;
import com.workintech.fizzystore.dto.CreditCardResponseDto;
import com.workintech.fizzystore.entity.CreditCard;
import com.workintech.fizzystore.service.CreditCardService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController (CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("")
    public List<CreditCardResponseDto> getCreditCards() {

        return creditCardService.getAll()
                .stream()
                .map(card -> new CreditCardResponseDto(
                        card.getId(),
                        card.getNameOnCard(),
                        card.getCardNo(),
                        card.getExpireMonth(),
                        card.getExpireYear(),
                        card.getUser().getId()
                )).toList();
    }

    @GetMapping("/{id}")
    public CreditCardResponseDto getCreditCardById(@Positive @PathVariable Long id) {
        CreditCard creditCard = creditCardService.findById(id);

        return new CreditCardResponseDto(
                creditCard.getId(),
                creditCard.getNameOnCard(),
                creditCard.getCardNo(),
                creditCard.getExpireMonth(),
                creditCard.getExpireYear(),
                creditCard.getUser().getId());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreditCardResponseDto saveCreditCard(@Validated @RequestBody CreditCardRequestDto creditCardRequestDto) {

        CreditCard card = new CreditCard();
        card.setNameOnCard(creditCardRequestDto.getNameOnCard());
        card.setCardNo(creditCardRequestDto.getCardNo());
        card.setExpireMonth(creditCardRequestDto.getExpireMonth());
        card.setExpireYear(creditCardRequestDto.getExpireYear());
        card.setUser(creditCardRequestDto.getUser());


        CreditCard savedCard = creditCardService.create(card);

        return new CreditCardResponseDto(
                card.getId(),
                card.getNameOnCard(),
                card.getCardNo(),
                card.getExpireMonth(),
                card.getExpireYear(),
                card.getUser().getId()
        );
    }

    @PutMapping("/{id}")
    public CreditCardResponseDto updateCreditCard(@Positive @PathVariable Long id, @Validated @RequestBody CreditCardRequestDto creditCardRequestDto) {

        CreditCard creditCard = new CreditCard();

        if(creditCardRequestDto.getNameOnCard() != null)
            creditCard.setNameOnCard(creditCardRequestDto.getNameOnCard());

        if(creditCardRequestDto.getCardNo() != null)
            creditCard.setCardNo(creditCardRequestDto.getCardNo());

        if(creditCardRequestDto.getExpireMonth() != null)
            creditCard.setExpireMonth(creditCardRequestDto.getExpireMonth());

        if(creditCardRequestDto.getExpireYear() != null)
            creditCard.setExpireYear(creditCardRequestDto.getExpireYear());

        if(creditCardRequestDto.getUser() != null)
            creditCard.setUser(creditCardRequestDto.getUser());


        CreditCard updatedCreditCard = creditCardService.update(id, creditCard);

        return new CreditCardResponseDto(updatedCreditCard.getId(),
                updatedCreditCard.getNameOnCard(),
                updatedCreditCard.getCardNo(),
                updatedCreditCard.getExpireMonth(),
                updatedCreditCard.getExpireYear(),
                updatedCreditCard.getUser().getId());
    }

    @DeleteMapping("{id}")
    public void deleteCreditCard(@Positive @PathVariable Long id) {

        creditCardService.deleteById(id);
    }
}
