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

                    if (roboUm.energiaAtual < 30 || roboDois.energiaAtual < 30) {
                        System.out.println(
                                "Os dois robôs precisam possuir pelo menos 30 de energia.");
                        break;
                    }

                    Robo atacante = definirAtacante(roboUm, roboDois);

                    Robo defensor;

                    if (atacante == roboUm) {
                        defensor = roboDois;
                    } else {
                        defensor = roboUm;
                    }

                    System.out.println("Combate!");
                    System.out.println("Primeiro a atacar: " + atacante.nome);

                    for (int rodada = 1; rodada <= 5; rodada++) {

                        System.out.println("Rodada: " + rodada);

                        realizarAtaque(atacante, defensor, rodada);

                        if (defensor.energiaAtual == 0) {
                            System.out.println(defensor.nome + " chegou a 0 de energia.");
                            break;
                        }

                        realizarAtaque(defensor, atacante, rodada);

                        if (atacante.energiaAtual == 0) {
                            System.out.println(atacante.nome + " chegou a 0 de energia.");
                            break;
                        }
                    }

                    registrarResultado(roboUm, roboDois);

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
        int ataqueRobo = entrada.nextInt();

        System.out.println("Informe a defesa do robô (0 à 20): ");
        int defesaRobo = entrada.nextInt();

        if (nomeRobo.isEmpty()) {
            System.out.println("O nome não pode estar vazio.");
            return;
        }

        if (ataqueRobo < 10 || ataqueRobo > 30) {
            System.out.println("O ataque deve estar entre 10 e 30.");
            return;
        }

        if (defesaRobo < 0 || defesaRobo > 20) {
            System.out.println("A defesa deve estar entre 0 e 20.");
            return;
        }

        Robo novoRobo = new Robo(
                codigoRobo,
                nomeRobo,
                ataqueRobo,
                defesaRobo);

        robo.add(novoRobo);

        System.out.println("Robô cadastrado com sucesso!");
    }

    public static void buscarRobo(Scanner entrada, ArrayList<Robo> robo) {

        System.out.println("Informe o código do robô: ");
        int codigoRobo = entrada.nextInt();

        for (Robo roboConsultado : robo) {
            if (roboConsultado.codigo == codigoRobo) {
                System.out.println("Codigo: " + roboConsultado.codigo);
                System.out.println("Nome: " + roboConsultado.nome);
                System.out.println("Ataque: " + roboConsultado.ataque);
                System.out.println("Defesa: " + roboConsultado.defesa);
                System.out.println("Energia: " + roboConsultado.energiaAtual);
                System.out.println("Vitorias: " + roboConsultado.vitorias);
                System.out.println("Derrotas: " + roboConsultado.derrotas);
                System.out.println("Pontos: " + roboConsultado.pontos);

                if (roboConsultado.energiaAtual >= 30) {
                    System.out.println("Situacao: Disponivel");
                } else {
                    System.out.println("Situacao: Em recuperacao");
                }
            }
        }

        System.out.println("Robô não encontrado.");
    }

    public static void listarRobos(ArrayList<Robo> robo) {

        for (Robo roboConsultado : robo) {
            System.out.println("\n\n\n ------------------------");
            System.out.println("Nome: " + roboConsultado.nome);
            System.out.println("Codigo: " + roboConsultado.codigo);
            System.out.println("Ataque: " + roboConsultado.ataque);
            System.out.println("Defesa: " + roboConsultado.defesa);
            System.out.println("Energia: " + roboConsultado.energiaAtual);
            System.out.println("Vitorias: " + roboConsultado.vitorias);
            System.out.println("Derrotas: " + roboConsultado.derrotas);
            System.out.println("Pontos: " + roboConsultado.pontos);

            if (roboConsultado.energiaAtual >= 30) {
                System.out.println("Situacao: Disponivel");
            } else {
                System.out.println("Situacao: Em recuperacao");
            }
        }
    }

    public static Robo buscarRoboPorCodigo(Scanner entrada, ArrayList<Robo> robo) {

        System.out.println("Informe o código do robô: ");
        int codigoRobo = entrada.nextInt();

        for (Robo r : robo) {
            if (r.codigo == codigoRobo) {
                return r;
            }
        }

        System.out.println("Robô não encontrado.");
        return null;
    }

    public static Robo definirAtacante(Robo roboUm, Robo roboDois) {

        if (roboUm.pontos < roboDois.pontos) {
            return roboUm;
        }

        if (roboDois.pontos < roboUm.pontos) {
            return roboDois;
        }

        if (roboUm.codigo < roboDois.codigo) {
            return roboUm;
        }

        return roboDois;
    }

    public static int calcularDano(Robo atacante, Robo defensor, int rodada) {

        int dano = atacante.ataque - defensor.defesa;

        if (dano < 5) {
            dano = 5;
        }

        if (rodada % 2 == 0) {
            dano += 5;
        }

        return dano;
    }

    public static void realizarAtaque(Robo atacante, Robo defensor, int rodada) {

        int dano = calcularDano(atacante, defensor, rodada);

        defensor.receberDano(dano);

        System.out.println(
                atacante.nome + " atacou " + defensor.nome +
                        " causando " + dano + " de dano.");

        System.out.println(
                "Energia de " + defensor.nome + ": " +
                        defensor.energiaAtual);
    }

    public static void registrarResultado(Robo roboUm, Robo roboDois) {

        if (roboUm.energiaAtual > roboDois.energiaAtual) {

            System.out.println("\nVencedor: " + roboUm.nome);

            roboUm.registrarVitoria();
            roboDois.registrarDerrota();

        } else if (roboDois.energiaAtual > roboUm.energiaAtual) {

            System.out.println("\nVencedor: " + roboDois.nome);

            roboDois.registrarVitoria();
            roboUm.registrarDerrota();

        } else {

            System.out.println("\nCombate terminou em empate.");

            roboUm.registrarEmpate();
            roboDois.registrarEmpate();
        }
    }
}
