package testes;

import dao.LivroDao;
import modelo.Livro;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();
        LivroDao livroDao = new LivroDao(em);

        System.out.println("Digite o titulo do livro");
        String titulo = ler.nextLine();

        System.out.println("Digite a descricao do livro");
        String descricao = ler.nextLine();

        System.out.println("Digite o isbn do livro");
        Long isbn = ler.nextLong();

        Livro livro = new Livro(titulo,descricao,isbn);
        em.getTransaction().begin();
        livroDao.cadastrar(livro);
        em.getTransaction().commit();
        System.out.println("livro armazenado com sucesso");
        em.close();

    }

}
