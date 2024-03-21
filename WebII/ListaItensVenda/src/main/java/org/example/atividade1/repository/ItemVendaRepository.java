package org.example.atividade1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade1.model.entity.ItemVenda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemVendaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ItemVenda> listarItensVenda(Long id) {
        Query query = em.createQuery("FROM ItemVenda WHERE venda.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

}
