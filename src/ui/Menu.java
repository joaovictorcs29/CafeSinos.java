package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import negocio.Pedido;
import negocio.Produto;
import servicos.ControleDePedidos;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static void menuCafeSinos(Cardapio cardapio, ControleDePedidos controleDePedidos) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha pendente

                validarOpcao(opcao, cardapio, controleDePedidos);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.\n");
                sc.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);


    }

    private static void exibirMenu() {
        System.out.println("\n     ##--Menu do Cafésinos--##");
        System.out.println("|---------------------------------------|");
        System.out.println("| Opção 1 - Mostrar cardápio            |");
        System.out.println("| Opção 2 - Mostrar a fila de pedidos   |");
        System.out.println("| Opção 3 - Solicitar o pedido          |");
        System.out.println("| Opção 4 - Entregar o pedido           |");
        System.out.println("| Opção 0 - (sair)                      |");
        System.out.println("|---------------------------------------|");
    }

    public static void validarOpcao(int opcao, Cardapio cardapio, ControleDePedidos controleDePedidos) {
        switch (opcao) {
            case 1:
                mostrarCardapio(cardapio);
                break;
            case 2:
                mostrarFilaDePedidos(controleDePedidos);
                break;
            case 3:
                solicitarPedido(cardapio, controleDePedidos);
                break;
            case 4:
                entregarPedido(controleDePedidos);
                break;
            case 0:
                System.out.println("bye bye!");
                break;
        }
    }

    private static void mostrarCardapio(Cardapio cardapio) {
        System.out.println("\nProdutos no Cardápio:");
        cardapio.cardapioVisual();
    }

    private static void mostrarFilaDePedidos(ControleDePedidos controleDePedidos) {
        System.out.println("\nPedidos na Fila:");
        controleDePedidos.exibirPedidos();
    }

    private static void solicitarPedido(Cardapio cardapio, ControleDePedidos controleDePedidos) {
        boolean continuarPedido = true;
        Pedido novoPedido = new Pedido();

        while (continuarPedido) {
            try {
                System.out.print("\nDigite o número do produto que deseja pedir (ou 0 para encerrar o pedido): ");
                int numeroProduto = sc.nextInt();

                if (numeroProduto == 0) {
                    continuarPedido = false;
                    break;
                }

                while (numeroProduto < 1 || numeroProduto > 10) {
                    System.out.print("Número do produto inválido! Digite novamente: ");
                    numeroProduto = sc.nextInt();
                    if (numeroProduto == 0) {
                        break;
                    }
                }

                Produto produtoSelecionado = cardapio.obtemProdutoPeloNumero(numeroProduto);

                if (produtoSelecionado == null) {
                    System.out.println("Produto indisponível no momento!");
                    continue;
                }

                System.out.println("Produto disponível!");

                System.out.print("Digite a quantidade desse produto: ");
                int quantidade = sc.nextInt();

                while (quantidade <= 0) {
                    System.out.print("Quantidade inválida! Digite novamente: ");
                    quantidade = sc.nextInt();
                }

                produtoSelecionado.setQuantidade(quantidade);

                novoPedido.adicionaProduto(produtoSelecionado);

                System.out.println("Produto adicionado ao pedido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
            }
        }

        controleDePedidos.adicionaPedido(novoPedido);
        System.out.println("Pedido concluído. Obrigado!");
    }

    private static void entregarPedido(ControleDePedidos controleDePedidos) {
        System.out.println("\nEntregando pedido...");
        controleDePedidos.entregaPedido();
    }
}
