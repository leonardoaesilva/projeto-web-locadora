package br.com.ada.projetoweblocadora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientela")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private String documento;
    private String nome;
}
