package com.example.javafx_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();//calling createMenu method
        rootNode.getChildren().add(0,menuBar);//Adding all the menus to menubar...
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        //creating File Menu
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItems=new MenuItem("New");//creating menu items...

        //adding actionListner to the Menu itmes...
        //EventHandler is an interface.
        newMenuItems.setOnAction(actionEvent -> {
            System.out.println("new item is clicked");
            //more code...
        });

        SeparatorMenuItem separatormenuitem=new SeparatorMenuItem();
        MenuItem quiteMenuItem=new MenuItem("Quit");//creating menu items...
        quiteMenuItem.setOnAction(event -> {
            Platform.exit();System.exit(0);
            //more code....
        });
        fileMenu.getItems().addAll(newMenuItems,separatormenuitem,quiteMenuItem);
        //creating Help Menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMenuItems=new MenuItem("About");//creating menu items...
        aboutMenuItems.setOnAction(actionEvent -> {
            aboutApp();
        });
        helpMenu.getItems().addAll(aboutMenuItems);
        //Creating Menu Bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first Dextop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon i will become pro and develop awesoem games"+"\n"+"developed by -: Abhijeet");
        ButtonType yesbtn=new ButtonType("yes");
        ButtonType nobtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);
        Optional<ButtonType> clickbtn=alertDialog.showAndWait();
        if(clickbtn.isPresent() && clickbtn.get()==yesbtn ){
            System.out.println("Yes button is clicked");
        }
        else {
            System.out.println("No button is clicked");
        }
    }
}
