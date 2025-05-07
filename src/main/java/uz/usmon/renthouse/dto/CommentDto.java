package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.usmon.renthouse.model.Profile;

public class CommentDto {
    private String text;
    private String description;
    private Integer profile_id;
    private Integer like_count;
    private String grade;

    public CommentDto(String text, String description, Integer profile_id, Integer like_count, String grade) {
        this.text = text;
        this.description = description;
        this.profile_id = profile_id;
        this.like_count = like_count;
        this.grade = grade;
    }

    public CommentDto() {
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

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
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

    @Override
    public String toString() {
        return "CommentDto{" +
                "text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", profile_id=" + profile_id +
                ", like_count=" + like_count +
                ", grade='" + grade + '\'' +
                '}';
    }
}
