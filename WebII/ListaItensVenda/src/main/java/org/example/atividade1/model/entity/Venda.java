package org.example.atividade1.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDateTime data;

    @OneToMany(mappedBy = "venda")
    List<ItemVenda> itemVendas = new ArrayList<>();

    public BigDecimal total() {
        BigDecimal soma = BigDecimal.valueOf(0);
        for(ItemVenda i: itemVendas) {
            soma = soma.add(i.total());
        }
        return soma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
