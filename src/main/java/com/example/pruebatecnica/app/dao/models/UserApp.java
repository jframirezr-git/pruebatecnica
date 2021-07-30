package com.example.pruebatecnica.app.dao.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    private int year;

    private Date startDate;

    @OneToMany(mappedBy = "userApp")
    private List<Product> products;

    @OneToMany(mappedBy = "userApp")
    private List<UpdateProducts> updateProducts;

    @ManyToOne
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private Profile profile;
}
