package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Address;
import uz.usmon.renthouse.model.Photo;


public class AboutUsDto {
    private Photo photo_id;
    private String description;
    private Integer address_id;

    public AboutUsDto(Photo photo_id, String description, Integer address_id) {
        this.photo_id = photo_id;
        this.description = description;
        this.address_id = address_id;
    }

    public AboutUsDto() {
    }

    public Photo getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Photo photo_id) {
        this.photo_id = photo_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "AboutUsDto{" +
                "photo_id=" + photo_id +
                ", description='" + description + '\'' +
                ", address_id=" + address_id +
                '}';
    }
}
