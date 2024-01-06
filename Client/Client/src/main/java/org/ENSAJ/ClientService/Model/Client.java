package org.ENSAJ.ClientService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long Id;

    private String Nom;
    private Float Age;

    public Client(long l, String Nom, float Age) {
        this.Id = l;
        this.Nom = Nom;
        this.Age = Age;
    }

    public Long getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public Float getAge() {
        return Age;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setAge(Float age) {
        Age = age;
    }
}
