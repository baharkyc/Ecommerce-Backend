package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Category;
import com.workintech.fizzystore.entity.CreditCard;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.CreditCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditCardServiceImplementation implements CreditCardService{

    private CreditCardRepository creditCardRepository;


    @Override
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard findById(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Credit card with id: " + id + " not found.", HttpStatus.NOT_FOUND));
        return creditCard;
    }

    @Override
    public CreditCard create(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(Long id, CreditCard creditCard) {
        CreditCard creditCardToUpdate = creditCardRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Credit card with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (creditCard.getNameOnCard() != null) {
            creditCardToUpdate.setNameOnCard(creditCard.getNameOnCard());
        }
        if (creditCard.getCardNo() != null) {
            creditCardToUpdate.setCardNo(creditCard.getCardNo());
        }
        if (creditCard.getUser() != null) {
            creditCardToUpdate.setUser(creditCard.getUser());
        }
        if (creditCard.getExpireYear() != null) {
            creditCardToUpdate.setExpireYear(creditCard.getExpireYear());
        }
        if (creditCard.getExpireMonth() != null) {
            creditCardToUpdate.setExpireMonth(creditCard.getExpireMonth());
        }

        return creditCardRepository.save(creditCardToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(!creditCardRepository.existsById(id)) {
            throw new FizzyStoreException("Credit card with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        creditCardRepository.deleteById(id);
    }
}
