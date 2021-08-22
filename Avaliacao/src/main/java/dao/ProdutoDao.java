package dao;

import modelo.Produto;
import javax.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
    public Produto bucarPorId(Long id){
        return em.find(Produto.class, id);
    }
    public  void atualizar(Produto produto){
        this.em.merge(produto);
    }
    public  void remove(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }

}
