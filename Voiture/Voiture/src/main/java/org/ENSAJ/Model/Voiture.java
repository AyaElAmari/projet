package org.ENSAJ.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ENSAJ.Client;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue
    private Long Id;
    private String marque;
    private String matricule;
    private String model;
    private Long id_client;
    @Transient @ManyToOne
    private Client client;

    public Voiture(long l, String marque, String matricule, String model, long id_client, Client client) {
        this.Id = l ;
        this.marque = marque;
        this.matricule=matricule;
        this.model=model;
        this.id_client=id_client;
        this.client = client;
    }

    public Long getId() {
        return Id;
    }

    public String getMarque() {
        return marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getModel() {
        return model;
    }

    public Long getId_client() {
        return id_client;
    }

    public Client getClient() {
        return client;
    }
}
