package uz.usmon.renthouse.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CardDto {
    private Integer number;
    private String expiryDate;
    private Integer cvv;

    public CardDto(Integer number, String expiryDate, Integer cvv) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public CardDto() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "number=" + number +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
