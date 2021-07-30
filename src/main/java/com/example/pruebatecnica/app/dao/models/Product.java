package com.example.pruebatecnica.app.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    private String product;

    private int quantity;

    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserApp userApp;

    @OneToMany(mappedBy = "product")
    private List<UpdateProducts> updateProductsList;

}
