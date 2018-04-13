package com.company;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Doctor doctor;
    private boolean canHeal = false;

    public GUI() {

        patient = new Patient();
        doctor = new Doctor("Haus", 46);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        listTest();

        primaryStage.setTitle("Hospital");

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 350, 300);
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
        TextField symptomsTF = new TextField();
        symptomsTF.setPromptText("Enter your symptoms:");

        Button submitEnter = new Button("I've entered all!");
////////////////
        Label card = new Label("MedCard");
        Label name = new Label("Name: ");
        Label age = new Label("Age: ");
        Label symptoms = new Label("Symptoms: ");
        Label healthy = new Label("Healthy: ");
        Button complain = new Button("Complain!");
////////////////
        //Label result = new Label();
        Text result = new Text();
        //result.getStyleClass().add("fancytext");
        result.setId("fancytext");
        result.setFont(Font.font ("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        result.setFill(Color.BLACK);
////////////////

        vBox1.getChildren().addAll(enter, nameTF, ageTF, symptomsTF, submitEnter);
        vBox1.setPadding(new Insets(10,0,20,20));

        vBox2.getChildren().addAll(card, name, age, symptoms, healthy, complain);
        vBox2.setPadding(new Insets(10,20,20,0));

        hBox1.getChildren().addAll(vBox1,vBox2);

        hBox2.getChildren().addAll(result);
        hBox2.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox1, hBox2);

        root.setTop(vBox);

        submitEnter.setOnAction(event -> {
            if (nameTF.getText().trim().isEmpty() || symptomsTF.getText().trim().isEmpty())
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
                    patient.setSymptoms(symptomsTF.getText());

                    name.setText("Name: " + patient.getName());
                    age.setText("Age: " + patient.getAge());
                    symptoms.setText("Symptoms: " + patient.getSymptoms());
                    healthy.setText("Healthy: " + patient.getHealthyStr());
                    result.setText("");
                }
            }
        });

        complain.setOnAction(event -> {
            if (canHeal) {
                patient.setHealthy(true);
                patient.Complain(doctor);
                healthy.setText("Healthy: " + patient.getHealthyStr());
                result.setText("Congratulations, " + patient.getName() + "!\nYou are healthy now!");
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

    private void listTest()
    {
        long start;
// поиск смысла жизни ...
        long finish;
        long timeConsumedMillis;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();



        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            arrayList.add(i);
            //linkedList.add(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to fill ARRAYLIST with 1kk int's = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            //arrayList.add(i);
            linkedList.add(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to fill LINKEDLIST with 1kk int's = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 1000; i < 1900; i++){
            arrayList.remove(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to remove from ARRAYLIST 900 elems from 1000 to 1900 = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 1000; i < 1900; i++){
            linkedList.remove(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to remove from LINKEDLIST 900 elems from 1000 to 1900 = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 999; i > 100; i--){
            arrayList.remove(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to remove from ARRAYLIST 900 elems from 999 to 100 = " + (finish - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 999; i > 100; i--){
            linkedList.remove(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time to remove from LINKEDLIST 900 elems from 999 to 100 = " + (finish - start) + " ms");
    }
}
