package JavaFx;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ConfigurandoPecaController {

    private int jogadorAtual = 1;
    private int numeroDeJogadores;

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("second")) {
                    String nome = (String) userData;
                    String[] vect = nome.split(" ");
                    numeroDeJogadores = Integer.parseInt(vect[0]);
                    campoQuantidadeJogadores.setText(nome);
                    campoQuantidadeJogadores1.setText("Jogador " + jogadorAtual);
                    System.out.println("nova tela: " + newScreen + " ," + userData);
                }

            }

        });
    }

    @FXML
    private RadioButton amarelo;

    @FXML
    private RadioButton azul;

    @FXML
    private Button btnContinuar;

    @FXML
    private TextField campoNome;

    @FXML
    private Label campoQuantidadeJogadores;

    @FXML
    private Label campoQuantidadeJogadores1;

    @FXML
    private ToggleGroup grupoCOr;

    @FXML
    private RadioButton preto;

    @FXML
    private RadioButton roxo;

    @FXML
    private RadioButton verde;

    ArrayList<String> jogadores = new ArrayList<>();

    ArrayList<Jogador> jogadoresObj = new ArrayList<>();

    @FXML
    void onActionBtn(ActionEvent event) {

        System.out.println(jogadorAtual);
        System.out.println(numeroDeJogadores);

        String nome = campoNome.getText();
        RadioButton selectedRadioButton = (RadioButton) grupoCOr.getSelectedToggle();

        if (selectedRadioButton != null && !nome.isEmpty()) {
            String cor = selectedRadioButton.getText();
            System.out.println("Nome: " + nome + "|cor: " + cor);
            System.out.println("jogador cadastrado");
            String jogador = nome + ", " + cor;

            Random random = new Random();
            int tipoDePeca = random.nextInt(3) + 1;
            Jogador jogadorCriado;

            switch (tipoDePeca) {
                case 1 -> {
                    jogadorCriado = new JogadorAzarado(nome, cor, 0, 0);
                    jogadoresObj.add(jogadorCriado);
                }

                case 2 -> {
                    jogadorCriado = new JogadorSortudo(nome, cor, 0, 0);
                    jogadoresObj.add(jogadorCriado);
                }

                case 3 -> {
                    jogadorCriado = new JogadorComun(nome, cor, 0, 0);
                    jogadoresObj.add(jogadorCriado);
                }

            }

            jogadores.add(jogador);

            jogadorAtual++;

            if (jogadorAtual <= numeroDeJogadores) {
                campoQuantidadeJogadores1.setText("Jogador " + jogadorAtual);
                campoNome.setText("");
                grupoCOr.selectToggle(null);
                selectedRadioButton.setDisable(true);
            } else {
                Object x = (Object) jogadores;
                Object jogadoresCriador = (Object) jogadoresObj;
                Main.changeScreen("partida", jogadoresObj);
            }

            System.out.println(jogadorAtual);

        } else {
            System.out.println("Preencha o nome e selecione uma cor");
        }

    }

    @FXML
    void onActionCancelar(ActionEvent event) {
        campoNome.setText("");

        for (Toggle x : grupoCOr.getToggles()) {
            RadioButton rb = (RadioButton) x;
            rb.setDisable(false);
            rb.setSelected(false);
        }
        jogadorAtual = 1;
        Main.changeScreen("main");
    }

}
