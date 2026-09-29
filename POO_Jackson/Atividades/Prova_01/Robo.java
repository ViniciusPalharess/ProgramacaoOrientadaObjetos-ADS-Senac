package POO_Jackson.Atividades.Prova_01;

public class Robo {
    int codigo;
    String nome;
    int ataque;
    int defesa;
    int energiaAtual;
    int vitorias;
    int derrotas;
    int empate;
    int pontos;
    int combatesRealizados;

    public Robo(int codigo, String nome, int ataque, int defesa) {
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;

        energiaAtual = 100;
        vitorias = 0;
        derrotas = 0;
        empate = 0;
        pontos = 0;
        combatesRealizados = 0;
    }

    public void receberDano(int dano) {
        energiaAtual -= dano;

        if (energiaAtual < 0) {
            energiaAtual = 0;
        }
    }

    public void registrarVitoria() {
        vitorias++;
        pontos += 3;
        combatesRealizados++;
    }

    public void registrarDerrota() {
        derrotas++;
        combatesRealizados++;
    }

    public void registrarEmpate() {
        empate++;
        pontos++;
        combatesRealizados++;
    }
}