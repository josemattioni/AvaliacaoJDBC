package testes;

import dao.FilmeDao;
import modelo.Filme;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        int quantidadePorPagina;
        int paginaEscolhida;

        Scanner ler = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);
        filmeDao.cadastrarFilmes();

        System.out.printf("Em quantos filmes deseja ver por pagina?");
        quantidadePorPagina = ler.nextInt();

        System.out.printf("qual pagina deseja acessar?");
        paginaEscolhida = ler.nextInt();

        List<Filme> filmesLista = filmeDao.buscarTodos();

        if (quantidadePorPagina > filmesLista.size()) {
            quantidadePorPagina = filmesLista.size();
        }

        int numeroDePaginas = (filmesLista.size()/quantidadePorPagina)+1;
        if (quantidadePorPagina >= filmesLista.size()) {
            numeroDePaginas = 1;
        }

        int primeiroDapagina = quantidadePorPagina*(paginaEscolhida-1);

        if (paginaEscolhida == 2) {
            primeiroDapagina = quantidadePorPagina;
        }
        if (paginaEscolhida == 1) {
            primeiroDapagina = 0;
        }

        int ultimoDaPagina = paginaEscolhida*quantidadePorPagina;

        if (ultimoDaPagina > 20) {
            ultimoDaPagina = 20;
        }
        if (quantidadePorPagina > filmesLista.size()) {
            numeroDePaginas = filmesLista.size();
        }
        if (paginaEscolhida > numeroDePaginas) {
            System.out.printf("Pagina não existe");
        }else {
            for (int i = primeiroDapagina; i < ultimoDaPagina; i++) {
                System.out.println(filmesLista.get(i).getNome());
            }
        }
        em.close();
    }
}
