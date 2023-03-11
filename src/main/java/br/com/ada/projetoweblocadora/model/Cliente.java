package br.com.ada.projetoweblocadora.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @Size(min = 11, message = "Documento de identificação deve conter no mínimo 11 (onze) caracteres.")
    private String documento;
    @NotBlank(message = "Campo de preenchimento obrigatório.")
    @NotEmpty(message = "Nome do cliente não pode ser vazio.")
    private String nome;
}
