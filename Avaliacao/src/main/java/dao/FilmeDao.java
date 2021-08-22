package dao;

import modelo.Filme;
import util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class FilmeDao {

    private EntityManager em;

    public FilmeDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Filme filme){
        this.em.persist(filme);
    }
    public Filme bucarPorId(Long id){
        return em.find(Filme.class, id);
    }
    public  void atualizar(Filme filme){
        this.em.merge(filme);
    }
    public  void remove(Filme filme){
        filme = em.merge(filme);
        this.em.remove(filme);
    }
    public void cadastrarFilmes(){
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);

        for (int i = 0; i<20; i++){
            em.getTransaction().begin();
            Filme filme = new Filme("velozes e furiosos"+i,"alguma coisa",2000+i);
            filmeDao.cadastrar(filme);
            em.getTransaction().commit();
        }
    }
    public List<Filme> buscarTodos(){
        String jpql = "SELECT f FROM Filme f";
        return em.createQuery(jpql, Filme.class).getResultList();
    }
}
