package servicos;

import negocio.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class ControleDePedidos {

    Pedido pedido;
    private Queue<Pedido> filaDePedidos;

    public ControleDePedidos() {
        this.filaDePedidos = new LinkedList<>();
    }

    public Queue<Pedido> getFilaDePedidos() {
        return filaDePedidos;
    }

    public void adicionaPedido(Pedido pedido) {
        this.filaDePedidos.add(pedido);
    }

    public void entregaPedido() {
        Pedido pedidoEntregue = filaDePedidos.poll();
        if (pedidoEntregue == null) {
            System.out.println("Não há pedidos na fila");
        }
    }

    public void calculaPedido() {
        double totalDoPedido = 0;
        for (Pedido pedido : filaDePedidos) {
            for (int i = 0; i < pedido.getProdutos().size(); i++) {
                totalDoPedido += pedido.getProdutos().get(i).total();
            }
        }
        System.out.println(String.format("O valor total do pedido é:R$ %.2f", totalDoPedido));
    }

    public void exibirPedidos() {
        if (filaDePedidos.isEmpty()) {
            System.out.println("Não há pedidos na fila.");
        }

        if (filaDePedidos.size() == 1) {
            System.out.println("Existe " + filaDePedidos.size() + " pedido na fila.");
        }else
            for (Pedido pedido : filaDePedidos) {
                System.out.println(pedido.toString());
            }

        if (filaDePedidos.size() > 1) {
            System.out.println("Existem " + filaDePedidos.size() + " pedidos na fila.");
        } else
            for (Pedido pedido : filaDePedidos) {
            System.out.println(pedido.toString());
            calculaPedido();
            }
        }


    }
