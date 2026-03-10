package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public Produit(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Produit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
