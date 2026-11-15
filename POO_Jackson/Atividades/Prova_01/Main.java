package POO_Jackson.Atividades.Prova_01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Robo> robo = new ArrayList<>();
        int opcao = -1;

        do {
            System.out.println("=== Robô ===");
            System.out.println("(0)- Sair.");
            System.out.println("(1)- Cadastrar Robô: ");
            System.out.println("(2)- Consultar Robôs: ");
            System.out.println("(3)- Listar Todos Robôs: ");
            System.out.println("(4)- Realizar um Combate: ");
            System.out.println("(5)- Recuperar Energia: ");
            System.out.println("(6)- Executar uma Rodada Gera: ");
            System.out.println("(7)- Exibir a Classificação: ");
            System.out.println("(8)- Emitir Estatísticas: ");
            System.out.println("(9)- Excluir Participante: ");

            opcao = buscarOperacao(entrada);

            switch (opcao) {
                case 1:
                    cadastrarRobo(entrada, robo);
                    break;
                case 2:
                    buscarRobo(entrada, robo);

                    break;
                case 3:
                    listarRobos(robo);

                    break;

                case 4:
                    Robo roboUm = null;
                    Robo roboDois = null;

                    do {
                        roboUm = buscarRoboPorCodigo(entrada, robo);
                    } while (roboUm == null);

                    do {
                        roboDois = buscarRoboPorCodigo(entrada, robo);

                        if (roboDois == roboUm) {
                            System.out.println("Os robôs devem ser diferentes.");
                            roboDois = null;
                        }

                    } while (roboDois == null);

                    if (!roboUm.isDisponivel() || !roboDois.isDisponivel()) {
                        System.out.println(
                                "Os dois robôs precisam possuir pelo menos "
                                        + roboUm.energiaMinima + " de energia.");
                        break;
                    }

                    System.out.println("Combate!");

                    realizarCombate(roboUm, roboDois);

                    break;

                case 6:

                    executarRodadaGeral(robo);

                    break;

                case 5:

                    recuperarEnergia(entrada, robo);

                    break;

                case 7:

                    exibirClassificacao(robo);

                    break;

                case 8:

                    emitirEstatisticas(robo);

                    break;

                case 9:

                    excluirParticipante(entrada, robo);

                    break;

                case 0:

                    System.out.println("Saindo...");

                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (opcao != 0);

        entrada.close();
    }

    public static int buscarOperacao(Scanner entrada) {
        int opcao = -1;

        do {
            try {
                opcao = entrada.nextInt();
            } catch (InputMismatchException e) {
                entrada.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opcao = -1;
            }
        } while (opcao < 0);

        return opcao;
    }

    static int codigoInicio = 0;

    public static int regraCodigoPorRobo() {
        codigoInicio++;
        return codigoInicio;
    }

    public static void cadastrarRobo(Scanner entrada, ArrayList<Robo> robo) {

        int codigoRobo = regraCodigoPorRobo();
        System.out.println("O código do seu robô: " + codigoRobo + "\n");

        System.out.println("Informe o nome do robô: ");
        String nomeRobo = entrada.next();

        System.out.println("Informe o ataque do robô (10 à 30): ");
        int ataqueRobo;

        try {
            ataqueRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        System.out.println("Informe a defesa do robô (0 à 20): ");
        int defesaRobo;

        try {
            defesaRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        System.out.println("Informe o tipo do robô (1 - Ofensivo, 2 - Defensivo, 3 - Equilibrado): ");
        int tipoRobo;

        try {
            tipoRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        Robo novoRobo;

        try {
            switch (tipoRobo) {
                case 1:
                    novoRobo = new RoboOfensivo(codigoRobo, nomeRobo, ataqueRobo, defesaRobo);
                    break;
                case 2:
                    novoRobo = new RoboDefensivo(codigoRobo, nomeRobo, ataqueRobo, defesaRobo);
                    break;
                case 3:
                    novoRobo = new RoboEquilibrado(codigoRobo, nomeRobo, ataqueRobo, defesaRobo);
                    break;
                default:
                    System.out.println("Tipo de robô inválido.");
                    return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        robo.add(novoRobo);

        System.out.println("Robô cadastrado com sucesso!");
    }

    public static void buscarRobo(Scanner entrada, ArrayList<Robo> robo) {

        System.out.println("Informe o código do robô: ");

        int codigoRobo;

        try {
            codigoRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        for (Robo roboConsultado : robo) {
            if (roboConsultado.getCodigo() == codigoRobo) {
                System.out.println("Codigo: " + roboConsultado.getCodigo());
                System.out.println("Nome: " + roboConsultado.getNome());
                System.out.println("Tipo: " + roboConsultado.getTipo());
                System.out.println("Ataque: " + roboConsultado.getAtaque());
                System.out.println("Defesa: " + roboConsultado.getDefesa());
                System.out.println("Energia: " + roboConsultado.getEnergiaAtual());
                System.out.println("Vitorias: " + roboConsultado.getVitorias());
                System.out.println("Derrotas: " + roboConsultado.getDerrotas());
                System.out.println("Pontos: " + roboConsultado.getPontos());
                System.out.println("Situacao: " + roboConsultado.getSituacao());

                return;
            }
        }

        System.out.println("Robô não encontrado.");
    }

    public static void listarRobos(ArrayList<Robo> robo) {

        for (Robo roboConsultado : robo) {
            System.out.println("\n\n\n ------------------------");
            System.out.println("Nome: " + roboConsultado.getNome());
            System.out.println("Codigo: " + roboConsultado.getCodigo());
            System.out.println("Tipo: " + roboConsultado.getTipo());
            System.out.println("Ataque: " + roboConsultado.getAtaque());
            System.out.println("Defesa: " + roboConsultado.getDefesa());
            System.out.println("Energia: " + roboConsultado.getEnergiaAtual());
            System.out.println("Vitorias: " + roboConsultado.getVitorias());
            System.out.println("Derrotas: " + roboConsultado.getDerrotas());
            System.out.println("Pontos: " + roboConsultado.getPontos());
            System.out.println("Situacao: " + roboConsultado.getSituacao());
        }
    }

    public static Robo buscarRoboPorCodigo(Scanner entrada, ArrayList<Robo> robo) {

        System.out.println("Informe o código do robô: ");

        int codigoRobo;

        try {
            codigoRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return null;
        }

        for (Robo roboCadastrado : robo) {
            if (roboCadastrado.getCodigo() == codigoRobo) {
                return roboCadastrado;
            }
        }

        System.out.println("Robô não encontrado.");
        return null;
    }

    public static Robo definirAtacante(Robo roboUm, Robo roboDois) {

        if (roboUm.getPontos() < roboDois.getPontos()) {
            return roboUm;
        }

        if (roboDois.getPontos() < roboUm.getPontos()) {
            return roboDois;
        }

        if (roboUm.getCodigo() < roboDois.getCodigo()) {
            return roboUm;
        }

        return roboDois;
    }

    public static void realizarAtaque(Robo atacante, Robo defensor, int rodada) {

        int dano = atacante.atacar(defensor, rodada);

        System.out.println(
                atacante.getNome() + " atacou " + defensor.getNome() +
                        " causando " + dano + " de dano.");

        System.out.println(
                "Energia de " + defensor.getNome() + ": " +
                        defensor.getEnergiaAtual());
    }

    public static void registrarResultado(Robo roboUm, Robo roboDois) {

        if (roboUm.getEnergiaAtual() > roboDois.getEnergiaAtual()) {

            System.out.println("\nVencedor: " + roboUm.getNome());

            roboUm.registrarVitoria();
            roboDois.registrarDerrota();

        } else if (roboDois.getEnergiaAtual() > roboUm.getEnergiaAtual()) {

            System.out.println("\nVencedor: " + roboDois.getNome());

            roboDois.registrarVitoria();
            roboUm.registrarDerrota();

        } else {

            System.out.println("\nCombate terminou em empate.");

            roboUm.registrarEmpate();
            roboDois.registrarEmpate();
        }
    }

    public static void recuperarEnergia(Scanner entrada, ArrayList<Robo> robo) {

        Robo roboRecuperar = buscarRoboPorCodigo(entrada, robo);

        if (roboRecuperar == null) {
            return;
        }

        System.out.println("Informe a quantidade de energia desejada: ");

        int quantidadeEnergia;

        try {
            quantidadeEnergia = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        String problema = roboRecuperar.validarRecuperacao(quantidadeEnergia);

        if (problema != null) {
            System.out.println(problema);
            return;
        }

        roboRecuperar.recuperarEnergia(quantidadeEnergia);

        System.out.println("Energia recuperada com sucesso!");
        System.out.println("Energia atual: " + roboRecuperar.getEnergiaAtual());
        System.out.println("Pontos restantes: " + roboRecuperar.getPontos());
    }

    public static void ordenarPorClassificacao(ArrayList<Robo> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {

            for (int j = i + 1; j < lista.size(); j++) {

                Robo roboUm = lista.get(i);
                Robo roboDois = lista.get(j);

                boolean deveTrocar = false;

                if (roboDois.getPontos() > roboUm.getPontos()) {

                    deveTrocar = true;

                } else if (roboDois.getPontos() == roboUm.getPontos()) {

                    if (roboDois.getVitorias() > roboUm.getVitorias()) {

                        deveTrocar = true;

                    } else if (roboDois.getVitorias() == roboUm.getVitorias()) {

                        if (roboDois.getEnergiaAtual() > roboUm.getEnergiaAtual()) {

                            deveTrocar = true;

                        } else if (roboDois.getEnergiaAtual() == roboUm.getEnergiaAtual()) {

                            if (roboDois.getCodigo() < roboUm.getCodigo()) {

                                deveTrocar = true;

                            }

                        }

                    }

                }

                if (deveTrocar) {

                    lista.set(i, roboDois);
                    lista.set(j, roboUm);

                }

            }

        }
    }

    public static void exibirClassificacao(ArrayList<Robo> robo) {

        ArrayList<Robo> classificacao = new ArrayList<>();

        for (Robo r : robo) {
            classificacao.add(r);
        }

        ordenarPorClassificacao(classificacao);

        System.out.println("\n Classificacao: ");

        for (int i = 0; i < classificacao.size(); i++) {

            Robo r = classificacao.get(i);

            System.out.println(
                    (i + 1) + "º - " +
                            r.getNome() +
                            " \n Código: " + r.getCodigo() +
                            " \n Pontos: " + r.getPontos() +
                            " \n Vitórias: " + r.getVitorias() +
                            " \n Energia: " + r.getEnergiaAtual());
        }
    }

    public static void realizarCombate(Robo roboUm, Robo roboDois) {

        Robo atacante = definirAtacante(roboUm, roboDois);

        Robo defensor;

        if (atacante == roboUm) {
            defensor = roboDois;
        } else {
            defensor = roboUm;
        }

        System.out.println("Primeiro a atacar: " + atacante.getNome());

        for (int rodada = 1; rodada <= 5; rodada++) {

            System.out.println("Rodada: " + rodada);

            realizarAtaque(atacante, defensor, rodada);

            if (defensor.getEnergiaAtual() == 0) {

                System.out.println(defensor.getNome() + " chegou a 0 de energia.");

                break;
            }

            realizarAtaque(defensor, atacante, rodada);

            if (atacante.getEnergiaAtual() == 0) {

                System.out.println(atacante.getNome() + " chegou a 0 de energia.");

                break;
            }

        }

        registrarResultado(roboUm, roboDois);
    }

    public static void executarRodadaGeral(ArrayList<Robo> robo) {

        ArrayList<Robo> disponiveis = new ArrayList<>();

        for (Robo r : robo) {

            if (r.isDisponivel()) {
                disponiveis.add(r);
            }

        }

        if (disponiveis.size() < 2) {

            System.out.println("É necessário possuir pelo menos dois robôs disponíveis.");

            return;
        }

        exibirClassificacao(disponiveis);

        ArrayList<Robo> confrontos = new ArrayList<>();

        for (Robo r : disponiveis) {
            confrontos.add(r);
        }

        ordenarPorClassificacao(confrontos);

        System.out.println("\n=== RODADA GERAL ===");

        for (int i = 0; i < confrontos.size() - 1; i += 2) {

            Robo roboUm = confrontos.get(i);
            Robo roboDois = confrontos.get(i + 1);

            System.out.println("\nConfronto:");
            System.out.println(roboUm.getNome() + " x " + roboDois.getNome());

            realizarCombate(roboUm, roboDois);

        }

        if (confrontos.size() % 2 != 0) {

            Robo roboFolga = confrontos.get(confrontos.size() - 1);

            roboFolga.registrarFolga();

            System.out.println("\nRobô com folga: " + roboFolga.getNome());
            System.out.println("Recebeu " + roboFolga.pontosFolga + " ponto de folga.");

        }

    }

    public static void emitirEstatisticas(ArrayList<Robo> robo) {

        if (robo.isEmpty()) {
            System.out.println("Nenhum robô cadastrado.");
            return;
        }

        int somaEnergia = 0;

        for (Robo roboEnergia : robo) {
            somaEnergia += roboEnergia.getEnergiaAtual();
        }

        double mediaEnergia = (double) somaEnergia / robo.size();

        System.out.println("Quantidade de robôs: " + robo.size());
        System.out.println("Média de energia: " + mediaEnergia);

        System.out.println("\nRobôs em recuperação:");

        boolean possuiRecuperacao = false;

        for (Robo roboCadastrado : robo) {
            if (!roboCadastrado.isDisponivel()) {
                System.out.println("Código: " + roboCadastrado.getCodigo() + " \n Nome: " + roboCadastrado.getNome()
                        + " \n Energia: " + roboCadastrado.getEnergiaAtual());
                possuiRecuperacao = true;
            }
        }

        if (!possuiRecuperacao) {
            System.out.println("Nenhum robô em recuperação.");
        }

        double maiorAproveitamento = -1;

        for (Robo roboCadastrado : robo) {
            if (roboCadastrado.getCombatesRealizados() > 0) {
                double aproveitamento = roboCadastrado.getAproveitamento();

                if (aproveitamento > maiorAproveitamento) {
                    maiorAproveitamento = aproveitamento;
                }
            }
        }

        System.out.println("\nMaior aproveitamento:");

        if (maiorAproveitamento == -1) {
            System.out.println("Nenhum robô realizou combates.");
        } else {
            for (Robo roboCadastrado : robo) {
                if (roboCadastrado.getCombatesRealizados() > 0) {
                    double aproveitamento = roboCadastrado.getAproveitamento();

                    if (aproveitamento == maiorAproveitamento) {
                        System.out.println("Código: " + roboCadastrado.getCodigo() + " \n Nome: "
                                + roboCadastrado.getNome()
                                + " \n Aproveitamento: " + aproveitamento + "%");
                    }
                }
            }
        }
    }

    public static void excluirParticipante(Scanner entrada, ArrayList<Robo> robo) {
        System.out.println("Informe o código do robô que deseja excluir: ");
        int codigoRobo;

        try {
            codigoRobo = entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.next();
            System.out.println("Informe um número.");
            return;
        }

        Robo roboExcluir = null;

        for (Robo roboCadastrado : robo) {
            if (roboCadastrado.getCodigo() == codigoRobo) {
                roboExcluir = roboCadastrado;
                break;
            }
        }

        if (roboExcluir == null) {

            System.out.println("Robô não encontrado.");

            return;
        }

        if (roboExcluir.getCombatesRealizados() > 0) {

            System.out.println(
                    "O robô não pode ser excluído porque já participou de um combate.");

            return;
        }

        robo.remove(roboExcluir);

        System.out.println("Robô excluído com sucesso!");
    }
}