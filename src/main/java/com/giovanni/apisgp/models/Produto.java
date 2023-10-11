package com.giovanni.apisgp.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    private Integer estoque;

}
