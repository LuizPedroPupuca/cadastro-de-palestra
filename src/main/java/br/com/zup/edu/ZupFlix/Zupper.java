package br.com.zup.edu.ZupFlix;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zupper {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    private String email;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Palestra> palestras = new HashSet<>();

    public Zupper(String nome, LocalDate dataAdmissao, String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    @Deprecated
    public Zupper() {
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Palestra palestra) {
        this.palestras.add(palestra);
    }
}
