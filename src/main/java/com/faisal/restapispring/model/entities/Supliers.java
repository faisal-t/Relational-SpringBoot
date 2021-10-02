package com.faisal.restapispring.model.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supliers")
public class Supliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150,nullable = false)
    private String name;

    @Column(length = 200,nullable = false)
    private String address;

    @Column(length = 100,nullable = false, unique = true)
    private String email;

    @ManyToMany(mappedBy = "supliers")
    private Set<Product> products;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
