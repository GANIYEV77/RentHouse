package uz.usmon.renthouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

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

    public Comment(Integer id, String text, String description, Profile profile_id, Integer like_count, String grade, LocalDateTime created_date) {
        this.id = id;
        this.text = text;
        this.description = description;
        this.profile_id = profile_id;
        this.like_count = like_count;
        this.grade = grade;
        this.created_date = created_date;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Profile profile_id) {
        this.profile_id = profile_id;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", profile_id=" + profile_id +
                ", like_count=" + like_count +
                ", grade='" + grade + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}
