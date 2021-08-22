package testes;

import dao.ProdutoDao;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {

        int op = 5;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite 1 para cadastrar 3 produtos");
        System.out.println("Digite 2 para alterar o primeiro produto");
        System.out.println("Digite 3 para para excluir o segundo produto");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto1 = new Produto("xiaomi","redmi note",3,new BigDecimal("800"));
        Produto produto2 = new Produto("televisao","samsung",10,new BigDecimal("1500"));
        Produto produto3 = new Produto("notebook","dell",5,new BigDecimal("2000"));

        while (true){
            System.out.println("--------------------------------------------");
            System.out.println("Digite 1 para cadastrar 3 produtos");
            System.out.println("Digite 2 para alterar o primeiro produto");
            System.out.println("Digite 3 para para excluir o segundo produto");
            System.out.println("--------------------------------------------");
            op = ler.nextInt();
            if (op == 1){
                em.getTransaction().begin();
                produtoDao.cadastrar(produto1);
                produtoDao.cadastrar(produto2);
                produtoDao.cadastrar(produto3);
                em.getTransaction().commit();
                System.out.println("Foram cadastrados 3 produtos");
            }
            if (op == 2){
                em.getTransaction().begin();
                produto1.setQuantidade(10);
                produto1.setDataAlteracao(LocalDate.now());
                produtoDao.atualizar(produto1);
                em.getTransaction().commit();
                System.out.println("o primeiro produto cadastrado foi alterado");
            }
            if (op == 3){
                em.getTransaction().begin();
                produtoDao.remove(produto2);
                em.getTransaction().commit();
                System.out.println("o segundo produto cadastrado foi removido");
            }
            if (op == 0){
                System.out.println("Programa encerrado");
                em.close();
                break;
            }
        }

    }
}
