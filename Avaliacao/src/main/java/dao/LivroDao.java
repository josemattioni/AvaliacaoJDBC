package dao;

import modelo.Livro;
import javax.persistence.EntityManager;

public class LivroDao {

    private EntityManager em;

    public LivroDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Livro livro) {
        this.em.persist(livro);
    }

    public Livro bucarPorId(Long id) {
        return em.find(Livro.class, id);
    }

    public void atualizar(Livro livro) {
        this.em.merge(livro);
    }

    public void remove(Livro Livro) {
        Livro = em.merge(Livro);
        this.em.remove(Livro);
    }
}