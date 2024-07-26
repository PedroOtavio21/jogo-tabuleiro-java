package JavaFx;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PartidaController {

    ArrayList<String> jogadores = new ArrayList<>();
    ArrayList<Jogador> jogadoresObj = new ArrayList<>();

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("partida")) {
                    System.out.println("nova tela: " + newScreen + " ," + userData);
                    if (userData instanceof ArrayList) {
                        System.out.println("entrou no if da partidaCOntroller");
                        jogadoresObj = (ArrayList) userData;

                        jogador1.setText("");
                        jogador2.setText("");
                        jogador3.setText("");
                        jogador4.setText("");
                        jogador5.setText("");
                        jogador6.setText("");

                        posicao1.setText("");
                        posicao2.setText("");
                        posicao3.setText("");
                        posicao4.setText("");
                        posicao5.setText("");
                        posicao6.setText("");

                        atualizarMenuDeLado();

                    } else {
                        System.out.println("O userData não é um ArrayList<String>");
                    }
                    tabuleiro.adicionarJogadores();
                    atualizarVezDoJogador();
                }
            }
        });
    }

    @FXML
    private Circle corDoJogador;

    @FXML
    private Label dado1;

    @FXML
    private Label dado2;

    @FXML
    private Label jogador1;

    @FXML
    private Label jogador2;

    @FXML
    private Label jogador3;

    @FXML
    private Label jogador4;

    @FXML
    private Label jogador5;

    @FXML
    private Label jogador6;

    @FXML
    private Button passarJogada;

    @FXML
    private Label qualRodada;

    @FXML
    private Button rolarDados;

    @FXML
    private Label vezDoJogadorX;

    @FXML
    private Label posicao1;

    @FXML
    private Label posicao2;

    @FXML
    private Label posicao3;

    @FXML
    private Label posicao4;

    @FXML
    private Label posicao5;

    @FXML
    private Label posicao6;

    @FXML
    private Label posicaoJogadorAtual;

    @FXML
    private Label somaDosDados;

    int rodadaAtual = 1;
    int jogadorAtual = 0;
    boolean fimDeJogo = false;

    @FXML
    void passarJogadaAction(ActionEvent event) {
        jogadorAtual++;
        if (jogadorAtual >= jogadoresObj.size()) {
            jogadorAtual = 0;
            rodadaAtual++;
        }
        atualizarMenuDeLado();
        atualizarVezDoJogador();
    }

    public void atualizarMenuDeLado() {
        int i = 0;
        for (Jogador jogador : jogadoresObj) {
            switch (i) {
                case 0:
                    jogador1.setText(jogador.getNome());
                    posicao1.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 1:
                    jogador2.setText(jogador.getNome());
                    posicao2.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 2:
                    jogador3.setText(jogador.getNome());
                    posicao3.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 3:
                    jogador4.setText(jogador.getNome());
                    posicao4.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 4:
                    jogador5.setText(jogador.getNome());
                    posicao5.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 5:
                    jogador6.setText(jogador.getNome());
                    posicao6.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                default:
                    break;
            }
            i++;
        }

        dado1.setText("Dado 1 ->");
        dado2.setText("Dado 2 ->");
        somaDosDados.setText("Soma dos dados: ");
    }

    public void atualizarVezDoJogador() {

        ArrayList<String> cores = new ArrayList<>() {
            {
                add("azul");
                add("preto");
                add("amarelo");
                add("roxo");
                add("verde");
            }
        };

        vezDoJogadorX.setText("Vez do jogador " + jogadoresObj.get(jogadorAtual).getNome());
        posicaoJogadorAtual.setText("Posição atual: " + jogadoresObj.get(jogadorAtual).getPosicao());
        /*
         * String[] jogadorDados = jogadores.get(jogadorAtual).split(", ");
         * String cor = jogadorDados[1];
         * System.out.println(cor);
         */

        for (String x : cores) {
            if (jogadoresObj.get(jogadorAtual).getCor().equals(x)) {
                switch (x) {
                    case "azul":
                        corDoJogador.setFill(Color.BLUE);
                        break;
                    case "preto":
                        corDoJogador.setFill(Color.BLACK);
                        break;
                    case "amarelo":
                        corDoJogador.setFill(Color.YELLOW);
                        break;
                    case "roxo":
                        corDoJogador.setFill(Color.PURPLE);
                        break;
                    case "verde":
                        corDoJogador.setFill(Color.GREEN);
                        break;

                    default:
                        break;
                }
            }
        }
        qualRodada.setText("Rodada " + rodadaAtual);

    }

    private Tabuleiro tabuleiro = new Tabuleiro(jogadoresObj.size());

    @FXML
    void rolarDadosAction(ActionEvent event) {
        Dado dado = new Dado(6);
        int valorDado1 = dado.rolarDado();
        int valorDado2 = dado.rolarDado();

        if (valorDado1 == valorDado2) {
            // chamar método para jogar de novo
        }
        int somaDosValores = valorDado1 + valorDado2;

        String stringDado1 = Integer.toString(valorDado1);
        String stringDado2 = Integer.toString(valorDado2);
        String somaDados = Integer.toString(somaDosValores);

        dado1.setText("Dado 1 ->" + stringDado1);
        dado2.setText("Dado 2 ->" + stringDado2);
        somaDosDados.setText("Soma dos dados: " + somaDados);

        tabuleiro.AndarNoTabuleiro(jogadoresObj.get(jogadorAtual), somaDosValores);

        // tabuleiro.VerificaCasa(jogadoresObj.get(jogadorAtual));

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> passarJogadaAction(event));
        delay.play();

    }

}
