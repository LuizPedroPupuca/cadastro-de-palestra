package br.com.zup.edu.ZupFlix;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private LocalDateTime horaExibicao;

    @ManyToMany
    private Set<Zupper> zuppers = new HashSet<>();

    public Palestra(String titulo, String tema, Integer minutos, Exibicao tipoExibicao, LocalDateTime horaExibicao, Set<Zupper> zuppers) {
        this.titulo = titulo;
        this.tema = tema;
        this.minutos = minutos;
        this.tipoExibicao = tipoExibicao;
        this.horaExibicao = horaExibicao;
        this.zuppers = zuppers;
    }

    @Deprecated
    public Palestra() {
    }

    public Long getId() {
        return id;
    }
}
