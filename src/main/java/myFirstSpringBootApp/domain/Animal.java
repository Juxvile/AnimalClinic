package myFirstSpringBootApp.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data

public class Animal extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    @NotNull
    private String species;
    private String sex;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Column(updatable = false, unique = true)
    private boolean isDeleted = false;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;



    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Animal() {
    }

    public Animal(LocalDate birth, boolean isDeleted, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.birth = birth;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Animal(String name, String species, String sex) {
        this.name = name;
        this.species = species;
        this.sex = sex;

    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

}
