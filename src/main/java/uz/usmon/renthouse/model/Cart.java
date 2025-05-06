package uz.usmon.renthouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private double total_sum;
    @ManyToOne
    private Card card_id;
    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();

}
