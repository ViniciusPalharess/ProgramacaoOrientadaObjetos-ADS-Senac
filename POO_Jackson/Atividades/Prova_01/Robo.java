package POO_Jackson.Atividades.Prova_01;

public abstract class Robo {

    public final int energiaInicio = 100;
    public final int energiaMaxima = 100;
    public final int energiaMinima = 30;
    public final int ataqueMinimo = 10;
    public final int ataqueMaximo = 30;
    public final int defesaMinima = 0;
    public final int defesaMaxima = 20;
    public final int danoMinimo = 5;
    public final int bonusRodadaPar = 5;
    public final int pontosVitoria = 3;
    public final int pontosEmpate = 1;
    public final int pontosFolga = 1;
    public final int energiaPorPonto = 10;

    private final int codigo;
    private final String nome;
    private final int ataque;
    private final int defesa;
    private int energiaAtual;
    private int vitorias;
    private int derrotas;
    private int empate;
    private int pontos;
    private int combatesRealizados;

    protected Robo(int codigo, String nome, int ataque, int defesa) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }

        if (ataque < ataqueMinimo || ataque > ataqueMaximo) {
            throw new IllegalArgumentException(
                    "O ataque deve estar entre " + ataqueMinimo + " e " + ataqueMaximo + ".");
        }

        if (defesa < defesaMinima || defesa > defesaMaxima) {
            throw new IllegalArgumentException(
                    "A defesa deve estar entre " + defesaMinima + " e " + defesaMaxima + ".");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;

        this.energiaAtual = energiaInicio;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empate = 0;
        this.pontos = 0;
        this.combatesRealizados = 0;
    }

    public abstract String getTipo();

    public int calcularAtaqueEfetivo() {
        return getAtaque();
    }

    public int reduzirDanoRecebido(int dano) {
        return dano;
    }

    public final int calcularDano(Robo alvo, int rodada) {
        int dano = calcularAtaqueEfetivo() - alvo.getDefesa();

        if (dano < danoMinimo) {
            dano = danoMinimo;
        }

        if (rodada % 2 == 0) {
            dano += bonusRodadaPar;
        }

        return alvo.reduzirDanoRecebido(dano);
    }

    public final int atacar(Robo alvo, int rodada) {
        int dano = calcularDano(alvo, rodada);
        alvo.receberDano(dano);
        return dano;
    }

    private void receberDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        }

        energiaAtual -= dano;

        if (energiaAtual < 0) {
            energiaAtual = 0;
        }
    }

    public void registrarVitoria() {
        vitorias++;
        pontos += pontosVitoria;
        combatesRealizados++;
    }

    public void registrarDerrota() {
        derrotas++;
        combatesRealizados++;
    }

    public void registrarEmpate() {
        empate++;
        pontos += pontosEmpate;
        combatesRealizados++;
    }

    public void registrarFolga() {
        pontos += pontosFolga;
    }

    public String validarRecuperacao(int quantidade) {
        if (quantidade <= 0) {
            return "A quantidade de energia deve ser positiva.";
        }

        if (quantidade % energiaPorPonto != 0) {
            return "A quantidade de energia deve ser múltipla de " + energiaPorPonto + ".";
        }

        if (energiaAtual + quantidade > energiaMaxima) {
            return "A energia final não pode ultrapassar " + energiaMaxima + ".";
        }

        if (pontos < quantidade / energiaPorPonto) {
            return "O robô não possui pontos suficientes.";
        }

        return null;
    }

    public boolean recuperarEnergia(int quantidade) {
        if (validarRecuperacao(quantidade) != null) {
            return false;
        }

        energiaAtual += quantidade;
        pontos -= quantidade / energiaPorPonto;
        return true;
    }

    public boolean isDisponivel() {
        return energiaAtual >= energiaMinima;
    }

    public String getSituacao() {
        return isDisponivel() ? "Disponivel" : "Em recuperacao";
    }

    public double getAproveitamento() {
        if (combatesRealizados == 0) {
            return 0;
        }
        return (double) vitorias / combatesRealizados * 100;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpate() {
        return empate;
    }

    public int getPontos() {
        return pontos;
    }

    public int getCombatesRealizados() {
        return combatesRealizados;
    }
}