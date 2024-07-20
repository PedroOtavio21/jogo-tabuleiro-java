import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class PartidaController {

    ArrayList<String> jogadores = new ArrayList<>();

    @FXML
    protected void initialize(){
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("partida")){
                    System.out.println("nova tela: "+newScreen+" ,"+userData);
                    if(userData instanceof ArrayList){
                        jogadores = (ArrayList)userData;

                        jogador1.setText("");
                        jogador2.setText("");
                        jogador3.setText("");
                        jogador4.setText("");
                        jogador5.setText("");
                        jogador6.setText("");

                        int i = 0;
                        for(String jogador : jogadores){
                            switch (i) {
                                case 0:
                                    jogador1.setText(jogador);
                                    break;
                                case 1:
                                    jogador2.setText(jogador);
                                    break;
                                case 2:
                                    jogador3.setText(jogador);
                                    break;
                                case 3:
                                    jogador4.setText(jogador);
                                    break;
                                case 4:
                                    jogador5.setText(jogador);
                                    break;
                                case 5:
                                    jogador6.setText(jogador);
                                    break;
                                default:
                                    break;
                            }
                            i++;
                        }
                    }
                    else{
                        System.out.println("O userData não é um ArrayList<String>");
                    }

                    partida();
                }
                    
            }
        });
    }

    int rodadaAtual = 1;
    int jogadorAtual = 0;

    private void atualizarTela(){
        
    }

    boolean fimDeJogo = false;

    private void partida(){

        while(fimDeJogo != true){

        }

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
    void passarJogadaAction(ActionEvent event) {

    }

    @FXML
    void rolarDadosAction(ActionEvent event) {
        Dado dado = new Dado(6);
        int valorDado1 = dado.rolarDado();
        int valorDado2 = dado.rolarDado();
        int somaDosValores = valorDado1 + valorDado2;

        String stringDado1 = Integer.toString(valorDado1);
        String stringDado2 = Integer.toString(valorDado2);
        String somaDados = Integer.toString(somaDosValores);

        dado1.setText(stringDado1);
        dado2.setText(stringDado2);
    }

}
