package br.com.zup.edu.ZupFlix;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false)
    private Integer minutos;

    @Column(nullable = false)
    private Exibicao tipoExibicao;

    @Column(nullable = false)
    private LocalDate horaExibicao;

    public Palestra(String titulo, String tema, Integer minutos, Exibicao tipoExibicao, LocalDate horaExibicao) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.horaExibicao = horaExibicao;
    }

    @Deprecated
    public Palestra() {
    }

    public Long getId() {
        return id;
    }
}
