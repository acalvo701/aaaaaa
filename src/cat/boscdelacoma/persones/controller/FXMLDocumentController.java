/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package cat.boscdelacoma.persones.controller;

import cat.boscdelacoma.persones.model.business.entities.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Alex
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnDesar;
    @FXML
    private Button btnSaludar;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtEdat;

    @FXML
    private Label lblSaludem;

    private Persona p;
   

    @FXML
    private void btnDesarAction(ActionEvent event) {
        String nom = txtNom.getText();
        String dni = txtDni.getText();
        String edat = txtEdat.getText();
        p.setDni(dni);
        p.setNom(nom);
        p.setEdat(Integer.parseInt(edat));

    }

    @FXML
    private void btnSaludarAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("T'envio salutacions!!");
        alert.setHeaderText("Ets una gran persona "+p.getNom());
        alert.setContentText("El teu DNI és "+p.getDni()+" i tens "+p.getEdat()+" anys!");
        alert.showAndWait();
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = new Persona();
       
    }

}
