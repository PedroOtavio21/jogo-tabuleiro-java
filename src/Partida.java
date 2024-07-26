
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

        teclado.nextLine();
        clear.ClearConsole();

        for (Jogador x : tabuleiro.getJogadoresList()) {

            Tela tela = new Tela(tabuleiro);
            tela.HudSimples(x);

            if (x.podeJogar == false) {
                System.out.println(x.getCor() + ", não pode jogar nessa partida");
                continue;
            }


            System.out.println("Jogador: " + x.getCor());
            System.out.println("1. Rolar dados\t2. Passar a jogada");
            int jogadaEscolhida = teclado.nextInt();

            switch (jogadaEscolhida) {
                case 1 -> {
                    if (x.podeJogar == false) {
                        System.out.println(x.getCor() + ", não pode joga nessa rodada");
                    } else {
                        int valorDados = x.jogadarDados(dadoUm);
                        if (valorDados < 0)
                            continue;
                        tabuleiro.AndarNoTabuleiro(x, valorDados);
                        x.mover(valorDados);
                        x.setJogadas(1);

                        // x.setPosicao(13);
                        if (tabuleiro.VerificaCasa(x) == true) {
                            System.out.println("Jogada da casa especial feita");
                            teclado.nextLine();
                            System.out.print("Pressione ENTER para continuar");
                            teclado.nextLine();
                            clear.ClearConsole();
                        }
                        if (x.ganhou()) {
                            break;
                        }
                    }

                }
                case 2 -> {
                    System.out.println("Passando a jogada");
                    teclado.nextLine();
                    System.out.print("Pressione ENTER para continuar");
                    teclado.nextLine();
                    clear.ClearConsole();
                }
            }

            teclado.nextLine();
            tela.HudSimples(x);      
            System.out.println("Pressione ENTER para continuar");
            teclado.nextLine();
            clear.ClearConsole();
        }

        teclado.nextLine();
        System.out.println("Fim da rodada atual");
        teclado.nextLine();
        clear.ClearConsole();
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
