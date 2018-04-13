package com.company;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * <h1>GUI</h1>
 * Класс предназначенный для реализации графического пользовательского интерфейса для работы с программой
 * @author Nikolai Dik
 * @version 1.2
 * @since 25-03-2018
 */

public class GUI extends Application{

    private Patient patient;
    private Doctor doctorAngina;
    private Doctor doctorFlu;
    private boolean canHeal = false;

    public GUI() {

        patient = new Patient();
        doctorAngina = new Doctor("Haus", 46, "angina");
        doctorFlu = new Doctor("Emmy", 32, "flu");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hospital");

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 370, 400);
        //scene.getStylesheets().add("com/company/Text.css");

        VBox vBox1 = new VBox(10); // spacing between elements
        VBox vBox2 = new VBox(10);

        HBox hBox1 = new HBox(30);
        HBox hBox2 = new HBox(30);

        VBox vBox = new VBox(20);
        //hBox.setAlignment(Pos.CENTER);

//////////////
        Label enter = new Label("Registration");

        TextField nameTF = new TextField();
        nameTF.setPromptText("Enter your name:");
        TextField ageTF = new TextField();
        ageTF.setPromptText("Enter your age:");
        CheckBox anginaRadio = new CheckBox("I Have a Sore Throat");
        CheckBox lungsRadio = new CheckBox("I Feel Pain in my Lungs");

        Button submitEnter = new Button("I've entered all!");
////////////////
        Label card = new Label("MedCard");
        Label name = new Label("Name: ");
        Label age = new Label("Age: ");
        Label throat = new Label("Throat: ");
        Label lungs = new Label("Lungs: ");
        Label healthy = new Label("Healthy: ");
        Button complain = new Button("Complain!");
        Button complainDoctorAngina = new Button("Complain! (dr.Haus)");
        Button complainDoctorFlu = new Button("Complain! (dr.Emmy");
////////////////
        //Label result = new Label();
        Text result = new Text();
        //result.getStyleClass().add("fancytext");
        result.setId("fancytext");
        result.setFont(Font.font ("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        result.setFill(Color.BLACK);
////////////////

        vBox1.getChildren().addAll(enter, nameTF, ageTF, anginaRadio, lungsRadio, submitEnter);
        vBox1.setPadding(new Insets(10,0,20,20));

        vBox2.getChildren().addAll(card, name, age, throat, lungs, healthy, complainDoctorAngina, complainDoctorFlu);
        vBox2.setPadding(new Insets(10,20,20,0));

        hBox1.getChildren().addAll(vBox1,vBox2);

        hBox2.getChildren().addAll(result);
        hBox2.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox1, hBox2);

        root.setTop(vBox);

        submitEnter.setOnAction(event -> {
            if (nameTF.getText().trim().isEmpty())
            {
                errorMessage("Please, enter valid information");
            }
            else {
                canHeal = true;

                try {
                    Integer.parseInt(ageTF.getText());
                } catch (Exception el) {
                    errorMessage("Huh, you've entered invalid age!!");
                    canHeal = false;
                }

                if (canHeal) {
                    patient.setName(nameTF.getText());
                    patient.setAge(Integer.parseInt(ageTF.getText()));
                    if (anginaRadio.isSelected())
                        patient.setAngina(new Angina(patient));
                    else {  patient.setAngina(null);  patient.setThroatStatus("Healthy");}
                    if (lungsRadio.isSelected())
                        patient.setFlu(new Flu(patient));
                    else {  patient.setFlu(null);   patient.setLungsStatus("Healthy");  }

                    patient.checkHealth();
                    name.setText("Name: " + patient.getName());
                    age.setText("Age: " + patient.getAge());
                    throat.setText("Throat: " + patient.getThroatStatus());
                    lungs.setText("Lungs: " + patient.getLungsStatus());
                    healthy.setText("Healthy: " + patient.getIsHealthyStr());
                    if (patient.getIsHealthy())
                        result.setText("You are already Healthy!\nWhat are you doing here?");
                    else result.setText("");

                    //System.out.println(patient.getLungsStatus());
                }
            }
        });

        complainDoctorAngina.setOnAction(event -> {
            if (canHeal) {
                patient.Complain(doctorAngina);
                throat.setText("Throat: " + patient.getThroatStatus());
                //.setText("Lungs: " + patient.getLungsStatus());
                healthy.setText("Healthy: " + patient.getIsHealthyStr());
                if (patient.getIsHealthy())
                    result.setText("Congratulations, " + patient.getName() + "!\nYou are healthy now!");
                else result.setText(patient.getName() + "! Good work, but u r not\nabsolutely healthy yet...");
            }
            else errorMessage("Fill correctly your MedCard first!");
        });

        complainDoctorFlu.setOnAction(event -> {
            if (canHeal) {
                patient.Complain(doctorFlu);
                //throat.setText("Throat: " + patient.getThroatStatus());
                lungs.setText("Lungs: " + patient.getLungsStatus());
                healthy.setText("Healthy: " + patient.getIsHealthyStr());
                if (patient.getIsHealthy())
                    result.setText("Congratulations, " + patient.getName() + "!\nYou are healthy now!");
                else result.setText(patient.getName() + "! Good work, but u r not\nabsolutely healthy yet...");
            }
            else errorMessage("Fill correctly your MedCard first!");
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showing(){
        launch();
    }

    /**
     * <h1>Error Message</h1>
     * Метод, предназначенный для сокращения повторяющегося кода в программе.
     * Этот метод создает новое окно ошибки с заданным текстом
     * @author Nikolai Dik
     * @version 1.2
     * @since 25-03-2018
     */

    private void errorMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);
        alert.setContentText("Press 'OK' to continue");

        alert.showAndWait();
    }
    
}
