package br.com.zup.edu.ZupFlix;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PalestraRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String tema;

    @NotNull
    @Min(30)
    private Integer minutos;

    @NotNull
    private Exibicao tipoExibicao;


    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate horaExibicao;

    public PalestraRequest(String titulo, String tema, Integer minutos, Exibicao tipoExibicao, LocalDate horaExibicao) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.horaExibicao = horaExibicao;
    }

    public PalestraRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public Exibicao getTipoExibicao() {
        return tipoExibicao;
    }

    public LocalDate getHoraExibicao() {
        return horaExibicao;
    }

    public Palestra toModel() {
        return new Palestra(titulo, tema, minutos, tipoExibicao, horaExibicao);
    }
}
