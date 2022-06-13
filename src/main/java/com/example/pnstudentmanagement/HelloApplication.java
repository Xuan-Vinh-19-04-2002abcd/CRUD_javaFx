package com.example.pnstudentmanagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DBConnection connection = new DBConnection();
        VBox root = new VBox();
        VBox studentRoot = new VBox();

        HBox hInsertStudents = new HBox();
        TextField tfName = new TextField();
        TextField tfImg = new TextField();
        TextField tfPrice = new TextField();

        Button btnAdd = new Button("Add_Product");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                connection.insertProduct(new Product(tfName.getText(),tfPrice.getText(),tfImg.getText()));
                getThenDisplayStudents(studentRoot, connection);
            }
        });
        hInsertStudents.getChildren().addAll(tfName,tfImg,tfPrice,btnAdd);

        root.getChildren().addAll(hInsertStudents, studentRoot);

        getThenDisplayStudents(studentRoot, connection);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    void displayStudents(DBConnection connection, VBox root, List<Product> products) {
        root.getChildren().clear();
        for (int i = 0; i < products.size(); i++) {
            final int finialI = i;
            HBox studentBox = new HBox();
            Label lbId = new Label("" + products.get(i).id);
            Label lbName = new Label(products.get(i).name);
            Label lbScore = new Label("" + products.get(i).img);
//            Image image = new Image("");
//            ImageView imageView = new ImageView();
//            imageView.setImage(image);
//            imageView.setFitWidth(200);
//            imageView.setFitHeight(200);
            Label lbPrice = new Label("" + products.get(i).price);
            Button btnDelete = new Button("Delete");

            btnDelete.setOnAction(actionEvent -> {
                System.out.println("Click delete " + products.get(finialI).id);

                connection.deleteStudent(products.get(finialI).id);
                getThenDisplayStudents(root, connection);
            });

            studentBox.setSpacing(20);
            studentBox.getChildren().addAll(lbId, lbName,lbScore,lbPrice, btnDelete);
            root.getChildren().add(studentBox);
        }
    }

    private void getThenDisplayStudents(VBox root, DBConnection connection) {
        List<Product> products = connection.getProducts();
        displayStudents(connection, root, products);
    }

    public static void main(String[] args) {
        launch();
    }
}