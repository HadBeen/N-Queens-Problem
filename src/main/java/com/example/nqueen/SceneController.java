package com.example.nqueen;


        import java.io.IOException;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.*;
        import javafx.scene.Parent;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.*;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.scene.control.*;
        import javafx.collections.*;



public class SceneController {

    int gener;
    int develop;
    int visited;
    long temps;


    String meth;

    @FXML
    private Pane Boardchess;
    @FXML
    private Pane paneStatic;
    @FXML
    private Pane MiniBoardchess;
    @FXML
    private TextField boardSize;
    @FXML
    private AnchorPane paneLwla;
    @FXML
    private Button lancer1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView queen;
    @FXML
    private Button Dashboard;
    @FXML
    private Text moreInfo;
    @FXML
    private  Text ChooseSize ;
    private int size = 8; // Default chessboard size
@FXML
private Label dev;
@FXML
private Label visit;
@FXML
private Label gen;
@FXML
private Label time;
@FXML
private Label choosensize;
@FXML
private Label chozenmethod;
    public void displayQueensSolutionDFS() {
        // Generate the n queens solution
        NQueen sol = generateQueensSolutionDFS(size);
        System.out.println(sol);
        System.out.println(size);
meth = "DFS";
        // Calculate the width and height of each square
        double squareWidth = Boardchess.getWidth() / size;
        double squareHeight = Boardchess.getHeight() / size;
        // Create an Image object from the queen image file
        Image queeen = queen.getImage();

        // Loop through the chessboard squares and add the queen images
        for (int row = 0; row < size; row++) {
                if (sol.getQueens()[row] != 0) {
                    System.out.println(sol.getQueens()[row]);
                    // Create a new ImageView for the queen
                    ImageView queenView = new ImageView(queeen);
                    // Set the position and size of the ImageView
                    queenView.setLayoutX((sol.getQueens()[row] -1 ) * squareWidth + 0.125*squareWidth);
                    queenView.setLayoutY(row*squareHeight + 0.125*squareHeight);
                    queenView.setFitWidth(squareWidth-13);
                    queenView.setFitHeight(squareHeight-13);

                    // Add the queen to the chessboard Pane
                    Boardchess.getChildren().add(queenView);
                }
        }
        boardSize.setVisible(false);
        lancer1.setVisible(false);
        ChooseSize.setVisible(false);
        Dashboard.setVisible(true);
        moreInfo.setVisible(true);


    }

    // Generate a random n queens solution
    private NQueen generateQueensSolutionDFS(int size) {
        NQueen prblm = new NQueen(size);
        Statistics sol = DFSolution.getSolutions(prblm);
        temps = sol.getExecutionTime();
        gener = sol.getGeneratedNodes();
        develop = sol.getDevelopedNodes();
        visited = sol.getVisitedNodes();
        return sol.getSolution();
    }


    public void displayQueensSolutionBFS() {
        // Generate the n queens solution
        NQueen sol = generateQueensSolutionDFS(size);
        System.out.println(sol);

        // Calculate the width and height of each square
        double squareWidth = Boardchess.getWidth() / size;
        double squareHeight = Boardchess.getHeight() / size;
        // Create an Image object from the queen image file
        Image queeen = queen.getImage();

        // Loop through the chessboard squares and add the queen images
        for (int row = 0; row < size; row++) {
            if (sol.getQueens()[row] != 0) {
                System.out.println(sol.getQueens()[row]);
                // Create a new ImageView for the queen
                ImageView queenView = new ImageView(queeen);
                // Set the position and size of the ImageView
                queenView.setLayoutX((sol.getQueens()[row] -1 ) * squareWidth + 0.125*squareWidth);
                queenView.setLayoutY(row*squareHeight + 0.125*squareHeight);
                queenView.setFitWidth(squareWidth-13);
                queenView.setFitHeight(squareHeight-13);

                // Add the queen to the chessboard Pane
                Boardchess.getChildren().add(queenView);

                //StackPane.setAlignment(newChessboard, Pos.BOTTOM_CENTER)
            }
        }
        boardSize.setVisible(false);
        lancer1.setVisible(false);
        ChooseSize.setVisible(false);
        Dashboard.setVisible(true);
        moreInfo.setVisible(true);
    }

    // Generate a random n queens solution
    private NQueen generateQueensSolutionBFS(int size) {
        NQueen prblm = new NQueen(size);
        Statistics sol = BFSolution.getSolution(prblm);
        return sol.getSolution();
    }
    public void displayQueensSolutionA1() {
        // Generate the n queens solution
        NQueen sol = generateQueensSolutionA1(size);
        System.out.println(sol);

        meth = "A* Heuristic 1";
        // Calculate the width and height of each square
        double squareWidth = Boardchess.getWidth() / size;
        double squareHeight = Boardchess.getHeight() / size;
        // Create an Image object from the queen image file
        Image queeen = queen.getImage();

        // Loop through the chessboard squares and add the queen images
        for (int row = 0; row < size; row++) {
            if (sol.getQueens()[row] != 0) {
                System.out.println(sol.getQueens()[row]);
                // Create a new ImageView for the queen
                ImageView queenView = new ImageView(queeen);
                // Set the position and size of the ImageView
                queenView.setLayoutX((sol.getQueens()[row] -1 ) * squareWidth + 0.125*squareWidth);
                queenView.setLayoutY(row*squareHeight + 0.125*squareHeight);
                queenView.setFitWidth(squareWidth-13);
                queenView.setFitHeight(squareHeight-13);

                // Add the queen to the chessboard Pane
                Boardchess.getChildren().add(queenView);

                //StackPane.setAlignment(newChessboard, Pos.BOTTOM_CENTER)
            }
        }
        boardSize.setVisible(false);
        lancer1.setVisible(false);
        ChooseSize.setVisible(false);
        Dashboard.setVisible(true);
        moreInfo.setVisible(true);
    }
    private NQueen generateQueensSolutionA1(int size) {
        NQueen prblm = new NQueen(size);
        Statistics sol = AStar1.getSolution(prblm);
        return sol.getSolution();
    }
    public void displayQueensSolutionA2() {
        // Generate the n queens solution
        NQueen sol = generateQueensSolutionA2(size);
        System.out.println(sol);

        // Calculate the width and height of each square
        double squareWidth = Boardchess.getWidth() / size;
        double squareHeight = Boardchess.getHeight() / size;
        // Create an Image object from the queen image file
        Image queeen = queen.getImage();

        // Loop through the chessboard squares and add the queen images
        for (int row = 0; row < size; row++) {
            if (sol.getQueens()[row] != 0) {
                System.out.println(sol.getQueens()[row]);
                // Create a new ImageView for the queen
                ImageView queenView = new ImageView(queeen);
                // Set the position and size of the ImageView
                queenView.setLayoutX((sol.getQueens()[row] -1 ) * squareWidth + 0.125*squareWidth);
                queenView.setLayoutY(row*squareHeight + 0.125*squareHeight);
                queenView.setFitWidth(squareWidth-13);
                queenView.setFitHeight(squareHeight-13);

                // Add the queen to the chessboard Pane
                Boardchess.getChildren().add(queenView);

                //StackPane.setAlignment(newChessboard, Pos.BOTTOM_CENTER)
            }
        }
        boardSize.setVisible(false);
        lancer1.setVisible(false);
        ChooseSize.setVisible(false);
        Dashboard.setVisible(true);
        moreInfo.setVisible(true);
    }
    private NQueen generateQueensSolutionA2(int size) {
        NQueen prblm = new NQueen(size);
        Statistics sol = AStar2.getSolution(prblm);
        return sol.getSolution();
    }


    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void switchToGameStart(ActionEvent event) throws IOException {
            //recuperation de la taille
            Stage mainWindow = (Stage) paneLwla.getScene().getWindow();
            String t = boardSize.getText();
            size = Integer.parseInt(t);

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
    @FXML
    public void miniSolution(ActionEvent event) throws IOException {

    }
    @FXML
    public void switchToSatics(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //-------------

        dev = (Label) scene.lookup("#dev");
        String dynamicText = Integer.toString(develop);
        dev.setText(dynamicText );
        //-------------

        time = (Label) scene.lookup("#time");
        dynamicText = Long.toString(temps);
        time.setText(dynamicText +" ms");
        //-------------

        gen = (Label) scene.lookup("#gen");
       dynamicText = Integer.toString(gener);
        gen.setText(dynamicText);
        //-------------

        visit = (Label) scene.lookup("#visit");
        dynamicText = Integer.toString(visited);
        visit.setText(dynamicText);
        //-------------

        chozenmethod = (Label) scene.lookup("#chozenmethod");
        dynamicText = meth;
        chozenmethod.setText(dynamicText);
        //-------------

        choosensize = (Label) scene.lookup("#choosensize");
       dynamicText = Integer.toString(size);
        choosensize.setText(dynamicText);



    }

}
