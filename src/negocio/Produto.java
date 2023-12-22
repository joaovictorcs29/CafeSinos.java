package negocio;

public class Produto {
    private int numeroProduto;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {
    }

    public Produto(int numeroProduto, String nome, double preco, int quantidade) {
        this.numeroProduto = numeroProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getNumeroProduto() {
        return numeroProduto;
    }

    public void setNumeroProduto(int numeroProduto) {
        this.numeroProduto = numeroProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double total(){
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format("[ Número: %d, Nome: %s, %.2f, Quantidade: %d, Total: %.2f]",
                numeroProduto, nome, preco, quantidade, total());
    }
}
