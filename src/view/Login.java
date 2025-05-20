package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;


public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("Login");


        ImageView imageView = new ImageView(new Image("/view/resources/img/telalogin.jpg"));
        imageView.setFitWidth(450);
        imageView.setFitHeight(500);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label lbltitulo = new Label("Acesse Sua Conta:");
        lbltitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");
        grid.add(lbltitulo, 0, 0, 2, 1);
        lbltitulo.setAlignment(Pos.CENTER);
        lbltitulo.setPadding(new Insets(0, 0, 20, 0));
        lbltitulo.setMinWidth(200);
        lbltitulo.setMaxWidth(200);

        Label emailLabel = new Label("E-mail:");
        grid.add(emailLabel, 0, 1);

        TextField emailField = new TextField();
        emailField.setPromptText("example@domain.com");
        grid.add(emailField, 1, 1);

        Label passwordLabel = new Label("Senha:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("********");
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        grid.add(hbBtn, 1, 4);


        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(imageView);
        borderPane.setCenter(grid);


        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


