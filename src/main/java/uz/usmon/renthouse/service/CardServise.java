package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.CardDto;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.CardRepo;

import java.util.List;
import java.util.Optional;

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
        card.setNumber(cardDto.getNumber());
        card.setCvv(cardDto.getCvv());
        card.setExpiryDate(cardDto.getExpiryDate());
        cardRepo.save(card);
        return new Result(true, "Card created");
    }

    public Result update(Integer id ,CardDto cardDto) {
        Optional<Card> card = cardRepo.findById(id);
        if (card.isPresent()) {
            card.get().setNumber(cardDto.getNumber());
            card.get().setCvv(cardDto.getCvv());
            card.get().setExpiryDate(cardDto.getExpiryDate());
            cardRepo.save(card.get());
            return new Result(true, "Card updated");
        }
        return new Result(false, "Card not found");
    }
    public Result delete(Integer id) {
        Optional<Card> card = cardRepo.findById(id);
        if (card.isPresent()) {
            cardRepo.delete(card.get());
            return new Result(true, "Card deleted");
        }
        return new Result(false, "Card not found");
    }


}
