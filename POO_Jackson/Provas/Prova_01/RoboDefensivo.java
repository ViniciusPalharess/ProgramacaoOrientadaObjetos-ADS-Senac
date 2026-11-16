package POO_Jackson.Provas.Prova_01;

public class RoboDefensivo extends Robo {

    public final int reducaoDano = 3;
    public final int danoFinalMinimo = 2;

    public RoboDefensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Defensivo";
    }

    @Override
    public int reduzirDanoRecebido(int dano) {
        int danoReduzido = dano - reducaoDano;

        if (danoReduzido < danoFinalMinimo) {
            danoReduzido = danoFinalMinimo;
        }

        return danoReduzido;
    }
}