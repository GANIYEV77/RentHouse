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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Profile profile_id;
    @Column(nullable = false)
    private Integer like_count;
    @Column(nullable = false)
    private String grade;
    @CreatedDate
    private LocalDateTime created_date;


}
