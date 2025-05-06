package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Address;
import uz.usmon.renthouse.model.Photo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutUsDto {
    private Photo photo_id;
    private String description;
    private Integer address_id;
}
