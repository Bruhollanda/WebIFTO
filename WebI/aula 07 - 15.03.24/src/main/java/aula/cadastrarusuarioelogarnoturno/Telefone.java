package aula.cadastrarusuarioelogarnoturno;

import java.util.Objects;

public class Telefone {
    private int id;
    private String tipo, numero;

    public Telefone(int id, String tipo, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return tipo +": "+ numero;
    }
}
