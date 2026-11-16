package POO_Jackson.Provas.Prova_01;

public class RoboOfensivo extends Robo {

    public final int bonusDeAtaque = 5;

    public RoboOfensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Ofensivo";
    }

    @Override
    public int calcularAtaqueEfetivo() {
        return getAtaque() + bonusDeAtaque;
    }
}