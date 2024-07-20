import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {

        launch(args);
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


    private static Stage stage;

    private static Scene mainScene;
    private static Scene secondScene;
    private static Scene partidaScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;  

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("telaInicial.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlSecond = FXMLLoader.load(getClass().getResource("configurandoPeca.fxml"));
        secondScene = new Scene(fxmlSecond);

        Parent fxmlPartida = FXMLLoader.load(getClass().getResource("partida.fxml"));
        partidaScene = new Scene(fxmlPartida);
        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData){
        switch (scr) {
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "second":
                stage.setScene(secondScene);
                notifyAllListeners("second", userData);
                break;
            case "partida":
                stage.setScene(partidaScene);
                notifyAllListeners("partida", userData);
                break;
            default:
                break;
        }
    }
    public static void changeScreen(String scr){

        changeScreen(scr, null);
    }


    //------------------------------------------------------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);

    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);
        }
    }
}
