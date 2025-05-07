package uz.usmon.renthouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
public class AboutUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Photo photo_id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Address address_id;

    public AboutUs(Integer id, Photo photo_id, String description, Address address_id) {
        this.id = id;
        this.photo_id = photo_id;
        this.description = description;
        this.address_id = address_id;
    }

    public AboutUs() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Address getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Address address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "AboutUs{" +
                "id=" + id +
                ", photo_id=" + photo_id +
                ", description='" + description + '\'' +
                ", address_id=" + address_id +
                '}';
    }
}
