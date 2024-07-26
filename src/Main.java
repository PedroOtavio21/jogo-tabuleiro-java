import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean jogoComeca = false;
        int quantidadeJogadores;

        do {
            System.out.print("Insira o número de jogadores: ");
            Scanner teclado = new Scanner(System.in);
            quantidadeJogadores = teclado.nextInt();
            if (quantidadeJogadores > 6 || quantidadeJogadores < 2) {
                System.out.println("Quantidade de jogadores errada");
            } else {
                jogoComeca = true;
            }
        } while (jogoComeca == false);

        Tabuleiro tabuleiro = new Tabuleiro(quantidadeJogadores);
        tabuleiro.adicionarJogadores();
        Tela hud = new Tela(tabuleiro);
        hud.HudInicial();
        Scanner teclado = new Scanner(System.in);
        ClearConsole clear = new ClearConsole();

        System.out.print("Pressione ENTER para continuar");
        teclado.nextLine();
        clear.ClearConsole();

        Dado dado1 = new Dado(6);
        int rodadaAtual = 0;
        boolean fimDeJogo = false;

        while (fimDeJogo == false) {
            hud.HudCompleto(rodadaAtual);

            Partida partida = new Partida(tabuleiro, dado1);
            partida.Rodada(rodadaAtual);
            fimDeJogo = partida.PartidaAcabou();
            if (fimDeJogo == false) {
                for (Jogador x : tabuleiro.getJogadoresList()) {
                    if (x.podeJogar == true) {
                        System.out.println(x.getCor() + " pode jogar");
                        x.setRodadasSemJogar(0);
                    } else {
                        x.podeJogar();
                    }
                }
            }
            rodadaAtual++;

        }

        System.out.println("Fim de jogo. Até a próxima");
    }

}
