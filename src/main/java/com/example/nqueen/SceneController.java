package com.example.nqueen;


        import java.io.IOException;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.*;
        import javafx.scene.Parent;
        import javafx.scene.layout.*;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;
        import javafx.collections.*;
        import javafx.scene.control.*;



public class SceneController {


    @FXML
    private Pane Boardchess;

    @FXML
    private TextField boardSize;


    @FXML
    private Rectangle chess;

    @FXML
    private Button lancer;

    @FXML
    private ChoiceBox<?> method;


    @FXML
    private AnchorPane paneLwla;

    @FXML
    private AnchorPane pane;


    private Stage stage;
    private Scene scene;
    private Parent root;
    private int size = 8;




    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToGameStart(ActionEvent event) throws IOException {
            //recuperation de la taille
            Stage mainWindow = (Stage) paneLwla.getScene().getWindow();
            String t = boardSize.getText();
            int size = Integer.parseInt(t);
            //affiche du resultat dans l'interface
            float rV = (float) (Boardchess.getWidth()/size);
            float rV1 = (float) (Boardchess.getHeight()/size);
            ObservableList<Node> items = Boardchess.getChildren();
            items.clear();
            // Create a new chessboard with the new size
            GridPane newChessboard = new GridPane();
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    Rectangle square = new Rectangle(rV, rV);
                    if ((row + col) % 2 == 0) {
                        square.setFill(Color.web("#201F1F"));
                    } else {
                        square.setFill(Color.web("#F9F1F1"));
                    }

                    newChessboard.add(square, col, row);

                }
            }
            // Add the new chessboard to the pane
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(newChessboard);

            // Set the alignment of the StackPane to center
            //StackPane.setAlignment(newChessboard, Pos.BOTTOM_CENTER)

            // Add the StackPane to the SplitPane
            items.add(stackPane);
            // items.add(newChessboard);
    }
    public void switchToGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActualGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSatics(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
