package br.com.zup.edu.ZupFlix;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import javax.persistence.SecondaryTable;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Size(min = 1)
    private Set<Long> idZupper;


    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate horaExibicao;

    public PalestraRequest(String titulo, String tema, Integer minutos, Exibicao tipoExibicao, Set<Long> idZupper, LocalDate horaExibicao) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.idZupper = idZupper;
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

    public Set<Long> getIdZupper() {
        return idZupper;
    }

    public Palestra toModel(ZupperRepository zupperRepository) {

        Set<Zupper> zuppers = idZupper.stream().map(idZupper -> zupperRepository.
                findById(idZupper).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper inexistente")))
                .collect(Collectors.toSet());
        return new Palestra(titulo, tema, minutos, tipoExibicao, horaExibicao, zuppers);
    }
}
