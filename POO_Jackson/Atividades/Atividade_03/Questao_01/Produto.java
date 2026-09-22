package POO_Jackson.Atividades.Atividade_03.Questao_01;

public class Produto {
    String nome;
    float preco;
    int quantidade;

    Produto(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int adicionarEstoque(int quantidade) {
        return this.quantidade += quantidade;
    }

    public int removerEstoque(int quantidade) {
        return this.quantidade -= quantidade;
    }

    public float calcularValorEstoque() {
        return this.preco * this.quantidade;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade: " + this.quantidade);
    }
}
