package view;

import controller.QuartosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelButtons;
import view.components.Sidebar;

import javax.swing.*;

public class CadQuarto extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage janela) throws Exception {
        PainelButtons buttons = new PainelButtons();
        Sidebar menu = new Sidebar();


        Label lblTitulo = new Label("Cadastro dos Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 25px; -fx-font-weight: bold");

        BorderPane mainPainel = new BorderPane();
        mainPainel.setLeft(menu);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblNumero = new Label("Numero: ");
        TextField txtNumero= criarMascaraCampo("(##) #####-####");

        Label lblPreco = new Label("Preço:");
        TextField txtPreco = criarMascaraCampo("R$###,##");

        Label lblSol = new Label("Cama de Solterio");
        Spinner<Integer> spinnerQuantidadeSolteiro = new Spinner(1,2,1);
        spinnerQuantidadeSolteiro.setStyle("-fx-background-color: #D6C388FF;" +
                " -fx-border-width: 2px; -fx-border-radius: 5px;");
        spinnerQuantidadeSolteiro.setMaxWidth(100);

        Label lblCasal = new Label("Cama de Casal");
        Spinner<Integer> spinnerQuantidadeCasal = new Spinner(1,2,1);
        spinnerQuantidadeCasal.setStyle("-fx-background-color: #D6C388FF;" +
                " -fx-border-width: 2px; -fx-border-radius: 5px;");
        spinnerQuantidadeCasal.setMaxWidth(100);

        ComboBox<String> BoxQuartos = new ComboBox<>();
        BoxQuartos.setPromptText("Tipo de Quarto");
        BoxQuartos.getItems().addAll("Solteiro","Casal",
                "Suite","Suite Master","Luxuoso");

        ComboBox<String> BoxDisponivel = new ComboBox<>();
        BoxDisponivel.setPromptText("Disponivel");
        BoxDisponivel.getItems().addAll("Sim","Nâo");


        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome,1,0); FormGrid.add(lblNome,0,0); FormGrid.add(BoxQuartos,2,0);

        FormGrid.add(txtNumero, 1, 1); FormGrid.add(lblNumero,0 ,1);

        FormGrid.add(txtPreco, 1,2); FormGrid.add(lblPreco,0,2);

        FormGrid.add(spinnerQuantidadeSolteiro,1,3); FormGrid.add(lblSol,0,3);

        FormGrid.add(spinnerQuantidadeCasal,1,4); FormGrid.add(lblCasal,0,4);

        FormGrid.add(BoxDisponivel,1,5);

        FormGrid.add(buttons,1,6);



        FormGrid.setPadding(new Insets(20, 20, 20, 20));
        FormGrid.setHgap(10);
        FormGrid.setVgap(10);
        FormGrid.setAlignment(Pos.CENTER);

        HBox tituloBox = new HBox(lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);tituloBox.setPadding(new Insets(20, 20, 20,20));
        tituloBox.setAlignment(Pos.CENTER);

        buttons.btnCadastrar.setOnAction(evento ->{
            String nome = txtNome.getText();
            String numero = txtNumero.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int camaCasal = spinnerQuantidadeCasal.getValue();
            int camaSolteiro = spinnerQuantidadeSolteiro.getValue();
            String disponivel = (String) BoxDisponivel.getSelectionModel().getSelectedItem();

            boolean isDispovivel;
            if (disponivel.equals("Disponivel")) {
                isDispovivel = true;
            } else  {
                isDispovivel = false;
            }
            QuartosController quartosController = new QuartosController();

            boolean sucessoInsercao = quartosController.verificarInfosQuartos(nome,numero,camaCasal,camaSolteiro,isDispovivel,preco);
            if (sucessoInsercao) {
                System.out.println("Quarto realizado com sucesso!");
            } else {
                System.out.println("Não foi possivel cadastrar quarto!");
            }
        });

        VBox layout = new VBox(10,tituloBox,FormGrid);
        layout.setAlignment(Pos.CENTER);
        mainPainel.setCenter(layout);

        BorderPane borderPane = new BorderPane();


        Scene scene = new Scene(mainPainel, 850, 500);
        janela.setScene(scene);
        janela.getIcons().add(new Image("/view/resources/img/bed.png"));
        janela.show();
        janela.setResizable(false);
        janela.show();
    }
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

}
