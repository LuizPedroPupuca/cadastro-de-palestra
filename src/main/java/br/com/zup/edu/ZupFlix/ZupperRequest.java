package br.com.zup.edu.ZupFlix;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ZupperRequest {

    @NotBlank
    private String nome;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAdmissao;

    @NotBlank
    @Email
    private String email;

    public ZupperRequest(String nome, LocalDate dataAdmissao, String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public ZupperRequest() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public Zupper toModel() {
        return new Zupper(nome, dataAdmissao, email);
    }
}
