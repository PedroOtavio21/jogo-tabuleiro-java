
import java.util.Scanner;


public class Partida {
    // Atributos
    private Tabuleiro tabuleiro;
    private Dado dadoUm;
    Scanner teclado = new Scanner(System.in);
    ClearConsole clear = new ClearConsole();
    Tela hud = new Tela(tabuleiro);

    // Métodos
    public Partida(Tabuleiro tabuleiro, Dado dadoUm) {
        this.tabuleiro = tabuleiro;
        this.dadoUm = dadoUm;
    }

    public void Rodada(int rodadaAtual) {

        for (Jogador x : tabuleiro.getJogadoresList()) {
            if (x.podeJogar == false) {
                System.out.println("Não pode jogar nessa partida");
                continue;
            }
            System.out.println("Jogador: " + x.getCor());
            System.out.println("1. Rolar dados\t2. Passar a jogada");
            int jogadaEscolhida = teclado.nextInt();

            switch (jogadaEscolhida) {
                case 1 -> {

                    int valorDados = x.jogadarDados(dadoUm);

                    if (valorDados < 0) {
                        teclado.nextLine();
                        System.out.print("Pressione ENTER para continuar");
                        teclado.nextLine();
                        clear.ClearConsole();
                    } else {
                        tabuleiro.AndarNoTabuleiro(x, valorDados);

                        x.mover(valorDados);
                        x.setJogadas(1);

                        //x.setPosicao(13);
                        if (tabuleiro.VerificaCasa(x) == true) {

                            teclado.nextLine();
                            System.out.print("Pressione ENTER para continuar");
                            teclado.nextLine();
                            clear.ClearConsole();
                        }

                        teclado.nextLine();
                        System.out.print("Pressione ENTER para continuar");
                        teclado.nextLine();
                        clear.ClearConsole();
                    }
                    if (x.ganhou()) {
                        break;
                    }

                }
                case 2 -> {
                    teclado.nextLine();
                    System.out.print("Pressione ENTER para continuar");
                    teclado.nextLine();
                    clear.ClearConsole();
                }
            }
            System.out.print("Pressione ENTER para continuar");
            teclado.nextLine();
            clear.ClearConsole();
        }

    }

    public boolean PartidaAcabou() {
        for (Jogador x : tabuleiro.getJogadoresList()) {
            if (x.getPosicao() >= 40) {
                System.out.println("Jogo acabou, jogador " + x.getCor() + " ganhou!");
                return true;
            }
        }
        return false;
    }
}
