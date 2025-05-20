package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelButtons;
import view.components.Sidebar;

public class CadUsuario extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage janela) throws Exception {

        PainelButtons buttons = new PainelButtons();

        Sidebar menu = new Sidebar();

        BorderPane mainPainel = new BorderPane();

        mainPainel.setLeft(menu);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();

        Label lblSetor = new Label("Informe seu setor: ");

        ComboBox<String> BoxSetor = new ComboBox<>();
        BoxSetor.setPromptText("Selecionar");

        BoxSetor.getItems().addAll("TI","admin","Segurança","Cozinha","Teste");

        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome,1,0);
        FormGrid.add(lblNome,0,0);

        FormGrid.add(txtEmail, 1, 1);
        FormGrid.add(lblEmail,0 ,1);

        FormGrid.add(BoxSetor,1 ,3);
        FormGrid.add(lblSetor,0, 3);
        FormGrid.setPadding(new Insets(20, 20, 20, 20));

        FormGrid.setHgap(10);
        FormGrid.setVgap(10);
        FormGrid.setAlignment(Pos.CENTER);

        FormGrid.add(buttons, 1, 4);

        VBox layout = new VBox(10, FormGrid);
        layout.setAlignment(Pos.CENTER);
        mainPainel.setCenter(layout);



        Scene scene = new Scene(mainPainel, 740, 400);
        janela.setTitle("Grand Hotel");
        janela.setScene(scene);
        janela.show();

    }

}

