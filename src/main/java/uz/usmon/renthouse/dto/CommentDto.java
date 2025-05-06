package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Profile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String text;
    private String description;
    private Integer profile_id;
    private Integer like_count;
    private String grade;
}
