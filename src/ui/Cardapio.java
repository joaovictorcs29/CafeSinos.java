package ui;
import negocio.Produto;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private final List<Produto> produtos;

        public void cardapioVisual() {

            System.out.println("\n                              ##--Cardápio Cafésinos--##");
            System.out.println("|------------------------------------------------------------------------------------------------------|");
            System.out.println("|                                     [ LANCHES ]                                                      |");
            System.out.println("| número 1 - *Sanduíche Natural* [R$ 7,50] (pão de forma,  ovo, 2 fatias de queijo, tomate e alface)   |");
            System.out.println("| número 2 - *Hamburguer Vegano* [R$ 19,99](pão australiano, tofu, geleia de pimenta, alface e tomate) |");
            System.out.println("| número 3 - *Pastel de Brócolis* [R$ 8,00] (massa integral, requeijão e brócolis)                     |");
            System.out.println("| número 4 - *Pão de Queijo Recheado* [R$ 6,50] (recheios: Requeijão, Goiabada ou Sem recheio)         |");
            System.out.println("|                                                                                                      |");
            System.out.println("|                                     [ BEBIDAS ]                                                      |");
            System.out.println("| número 5 - *Café Verão* [R$ 12,00] (café, mel e suco de laranja)                                     |");
            System.out.println("| número 6 - *Expresso* [R$ 5,00](café torra média)                                                    |");
            System.out.println("| número 7 - *Soda Italiana* [R$ 10,00](água com gás e xarope: Maçã verde, Morango ou Frutas vermelhas |");
            System.out.println("| número 8 - *Chá Gelado* [R$ 8](chás: Hibisco, Laranja, Frutas vermelhas, Cranberry ou Pêssego)       |");
            System.out.println("|                                                                                                      |");
            System.out.println("|                                   [ SOBREMESAS ]                                                     |");
            System.out.println("| número 9 - *Cookies* [R$ 7,00] (cookies: red velvet, chocolate amargo e chocolate ao leite)          |");
            System.out.println("| número 10 - *Bolo de chocolate*[R$ 12,00] (massa de chocolate e cobertura de chocolate)              |");
            System.out.println("|------------------------------------------------------------------------------------------------------|");
            System.out.println("|   [ Sugestões são sempre bem recebidas ( Fale com algum atendente ) :) ]                             |");
            System.out.println("|------------------------------------------------------------------------------------------------------|");
        }

        public Cardapio() {
            this.produtos = new ArrayList<>();
            inicializarCardapio();
        }

        private void adicionarProduto(String nome, double preco) {
            Produto produto = new Produto(produtos.size() + 1, nome, preco, 1);
            produtos.add(produto);
        }

        private void inicializarCardapio() {
            adicionarProduto("Sanduíche Natural", 7.50);
            adicionarProduto("Hamburguer Vegano", 19.99);
            adicionarProduto("Pastel de Brócolis", 8.00);
            adicionarProduto("Pão de Queijo Recheado", 6.50);

            adicionarProduto("Café Verão", 12.00);
            adicionarProduto("Expresso", 5.00);
            adicionarProduto("Soda Italiana", 10.00);
            adicionarProduto("Chá Gelado", 8.00);

            adicionarProduto("Cookies", 7.00);
            adicionarProduto("Bolo de chocolate", 12.00);
        }

         public Produto obtemProdutoPeloNumero(int numeroProduto) {
             if (numeroProduto >= 1 && numeroProduto <= produtos.size()) {
                return produtos.get(numeroProduto - 1);
            } else {
                throw new IllegalArgumentException("Número do produto fora do cardápio!");
            }
        }


}




