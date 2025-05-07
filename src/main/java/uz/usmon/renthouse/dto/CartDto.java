package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Product;


public class CartDto {
    private Product product;
    private Integer quantity;
    private double total_sum;
    private Integer card_id;

    public CartDto(Product product, Integer quantity, double total_sum, Integer card_id) {
        this.product = product;
        this.quantity = quantity;
        this.total_sum = total_sum;
        this.card_id = card_id;
    }

    public CartDto() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", total_sum=" + total_sum +
                ", card_id=" + card_id +
                '}';
    }
}
