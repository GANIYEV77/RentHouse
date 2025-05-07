package uz.usmon.renthouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.CartDto;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Cart;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.repository.CardRepo;
import uz.usmon.renthouse.repository.CartRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    CardRepo cardRepo;

    public List<Cart> findAll() {
        return cartRepo.findAll();
    }
    public Cart findById(Integer id) {
        return cartRepo.findById(id).get();
    }

    public Result create(CartDto cartDto) {
       boolean exists = cartRepo.existsById(cartDto.getCard_id());
        if (exists) {
            return new Result(false, "Card already exists");
        }

        Cart cart = new Cart();
        cart.setProduct(cartDto.getProduct());
        cart.setQuantity(cartDto.getQuantity());
        cart.setTotal_sum(cartDto.getTotal_sum());
        Optional<Card> cardOptional = cardRepo.findById(cartDto.getCard_id());
        Card card = cardOptional.get();
        cart.setCard_id(card);

        cartRepo.save(cart);
        return new Result(true, "Cart created");
    }

    public Result update(Integer id ,CartDto cartDto) {
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()) {
           Cart cart = cartOptional.get();
            cart.setProduct(cartDto.getProduct());
            cart.setQuantity(cartDto.getQuantity());
            cart.setTotal_sum(cartDto.getTotal_sum());

            Optional<Card> cardOptional = cardRepo.findById(cartDto.getCard_id());
            Card card = cardOptional.get();
            cart.setCard_id(card);

            cartRepo.save(cartOptional.get());
            return new Result(true, "Cart updated");
        }
        return new Result(false, "Cart not found");
    }
    public Result delete(Integer id) {
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()) {
            cartRepo.delete(cartOptional.get());
            return new Result(true, "Cart deleted");

        }
        return new Result(false, "Cart not found");
    }

}
