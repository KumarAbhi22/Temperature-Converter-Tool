package com.example.javafx_app;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button button1;
    @FXML
    public Label label2;
    @FXML
    public TextField textField2;


    public static final String C_to_F="Celsius to Fahrenheit";
    public static final String F_to_C="Fahrenheit to Celsius";
    boolean c_to_f;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(C_to_F);
        choiceBox.getItems().add(F_to_C);
        choiceBox.setValue(C_to_F);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(C_to_F)){
                c_to_f=true;
            }
            else{
                c_to_f=false;
            }
        });
        button1.setOnAction(actionEvent->{
                convert();
        });
    }

    private void convert() {
        float newTemp=0.0f;
        float enteredTemp=0.0f;
        String input=textField.getText();
        try{
             enteredTemp = Float.parseFloat(input);
        }
        catch(Exception exception){
            warnUser();
            return;//after return keyword there is no code will excute in this method
        }
        if(c_to_f){
             newTemp=enteredTemp*9/5+32;
        }
        else {
            newTemp=(enteredTemp-32)*5/9;
        }
        display(newTemp);
    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature Entered...");
        alert.setContentText("Please enter a valid Temperature");
        alert.show();
    }

    private void display(float newTemp) {
        String unit=c_to_f?" F":" C";
        System.out.println("The Converted Temperature is-: "+newTemp+unit);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The Converted Temperature is-: "+newTemp+unit);
        alert.show();
        String output=Float.toString(newTemp);//for converting to string
        textField2.setText(output+unit);//displaying in output text-field
    }
}
