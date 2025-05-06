package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.CardDto;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.CardRepo;

import java.util.List;

@Service
public class CardServise {
    @Autowired
    CardRepo cardRepo;

    public List<Card> findAll() {
        return cardRepo.findAll();
    }
    public Card findById(Integer id) {
        return cardRepo.findById(id).get();
    }
    public Result create(CardDto cardDto) {
        Card card = new Card();
        card.setCvv(cardDto.getCvv());
        card.setNumber();
    }
}
