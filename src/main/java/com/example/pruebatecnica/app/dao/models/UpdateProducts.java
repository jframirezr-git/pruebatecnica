package com.example.pruebatecnica.app.dao.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UpdateProducts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    UserApp userApp;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    Product product;
}
