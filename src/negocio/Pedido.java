package negocio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contadorDeIDs = 1;
    private int id;
    private List<Produto> produtos;

    public Pedido() {
        this.id = contadorDeIDs++;
        this.produtos = new ArrayList<>();
    }

    public void adicionaProduto(Produto produto) {
        if (produto != null) {
            this.produtos.add(produto);
        } else {
            System.out.println("Tentativa de adicionar um produto nulo ao pedido.");
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("Pedido [" + id + "] \n Produtos: \n");
        for (Produto produto : produtos) {
            resultado.append(produto).append("\n");
        }
        if (!produtos.isEmpty()) {
            resultado.setLength(resultado.length() - 2);
        }
        resultado.append(" ]");
        return resultado.toString();
    }

}


