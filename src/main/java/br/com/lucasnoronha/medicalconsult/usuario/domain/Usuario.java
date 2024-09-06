package br.com.lucasnoronha.medicalconsult.usuario.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idUsuario;

    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    public Usuario() {

    }

}
