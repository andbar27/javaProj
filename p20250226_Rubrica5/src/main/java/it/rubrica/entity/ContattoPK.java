package it.rubrica.entity;

import java.io.Serializable;
import java.util.Objects;

public class ContattoPK implements Serializable {
	
    private static final long serialVersionUID = 1L; // Aggiunto serialVersionUID
    
    private String nome;
    private String cognome;

    public ContattoPK() {}

    public ContattoPK(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContattoPK that = (ContattoPK) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }
}

