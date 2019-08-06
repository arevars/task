package springboot1.task.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;


    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date createdAt;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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



}
