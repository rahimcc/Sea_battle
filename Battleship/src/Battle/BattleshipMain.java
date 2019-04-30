package Battle;

import java.util.Random;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import Battle.Board.Cell;

public class BattleshipMain extends Application {
    private boolean running = false;
    private Board enemyBoard, playerBoard;
    private int shipsToPlace = 0;
    private boolean enemyTurn = false;
    private Random random = new Random();


    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);

        enemyBoard = new Board(true, event -> {
            if (!running)
                return ;

            Cell cell = (Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (enemyBoard.ships == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (enemyTurn)
                enemyMove();
        });

        playerBoard = new Board(false, event -> {
            if (running)
                return;

            Cell cell = (Cell) event.getSource();
            int nS;
            nS = (shipsToPlace < 1) ? 5 : ((shipsToPlace < 3) ? 4 : ((shipsToPlace) < 5 ? 3 : ((shipsToPlace < 9) ? 2 : -1)));
            if (playerBoard.placeShip(new Ship(nS, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (++shipsToPlace == 9) {
                    startGame();
                }
            }
        });

        HBox hBox = new HBox(50, enemyBoard, playerBoard);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        root.setCenter(hBox);
        return root;
    }

    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            Cell cell = playerBoard.getCell(x, y);
            if (cell.wasShot)
                continue;

            enemyTurn = cell.shoot();

            if (playerBoard.ships == 0) {
                System.out.println("YOU LOSE");
                System.exit(0);
            }
        }
    }

    private void startGame() {
        // place enemy ships
        int type = 0;
        int nS;
        while (type < 9) {
            nS = (type < 1) ? 5 : ((type < 3) ? 4 : ((type) < 5 ? 3 : ((type < 9) ? 2 : -1)));
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (!enemyBoard.placeShip(new Ship(nS, Math.random() < 0.5), x, y)) {
                continue;
            }
            type++;
        }
        running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}