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
public class UserApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int year;

    private Date startDate;

    @OneToMany(mappedBy = "userApp")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "ProfileId", referencedColumnName = "id")
    Profile profile;
}
