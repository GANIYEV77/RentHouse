package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Product product;
    private Integer quantity;
    private double total_sum;
    private Integer card_id;
}
