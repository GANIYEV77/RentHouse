package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductDto {
    private String name;
    private String description;
    private double price;
    private String phone_number;
    private String share;
    private Integer like_count;

    public ProductDto(String name, String description, double price, String phone_number, String share, Integer like_count) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.phone_number = phone_number;
        this.share = share;
        this.like_count = like_count;
    }

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", phone_number='" + phone_number + '\'' +
                ", share='" + share + '\'' +
                ", like_count=" + like_count +
                '}';
    }
}
