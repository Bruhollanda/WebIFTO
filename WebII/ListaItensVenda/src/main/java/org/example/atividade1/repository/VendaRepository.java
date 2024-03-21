package org.example.atividade1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade1.model.entity.Venda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaRepository {
    @PersistenceContext
    private EntityManager em;

    public Venda buscarVenda(Long id) { return em.find(Venda.class, id); }

    public List<Venda> listarVendas() {
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }
}
