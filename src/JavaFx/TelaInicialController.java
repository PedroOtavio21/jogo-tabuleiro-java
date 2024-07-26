import Main;
package JavaFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import javafx.scene.Scene;

public class TelaInicialController {

    @FXML
    private Button campoIniciar;

    @FXML
    private RadioButton campoPlayer2;

    @FXML
    private RadioButton campoPlayer3;

    @FXML
    private RadioButton campoPlayer4;

    @FXML
    private RadioButton campoPlayer5;

    @FXML
    private RadioButton campoPlayer6;

    @FXML
    private ToggleGroup grupoJogadores;

    @FXML
    void acaoDoBotao(ActionEvent event) {

        RadioButton selectedRadioButton = (RadioButton) grupoJogadores.getSelectedToggle();
        if (selectedRadioButton == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Você deve selecionar um número de jogadores");
            alert.show();
            return;
        }

        Main.changeScreen("second", selectedRadioButton.getText());

    }

}
