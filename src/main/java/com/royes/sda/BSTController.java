package com.royes.sda;

import implementations.BSTNode;
import implementations.BSTree;
import implementations.RBNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class BSTController {
    private final BSTree tree = new BSTree();
    @FXML
    private TextField insertValue;
    @FXML
    private Button insertButton;
    @FXML
    private TextField deleteValue;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField searchValue;
    @FXML
    private Button searchButton;
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane content;
    @FXML
    private Label bstNodes;

    // A Label for displaying status messages
    @FXML
    private Label statusLabel;

    // Method to update the status label
    private void updateStatusMessage(String message) {
        statusLabel.setText(message);
    }

    @FXML
    public void goBack() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = changeScene(stage, "home.fxml");
        HomeController controller = fxmlLoader.getController();
    }

    public FXMLLoader changeScene(Stage stage, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 720);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        return fxmlLoader;
    }

    @FXML
    void buttonPressed(ActionEvent event) {
        Alert alert;
        if (event.getSource() == insertButton) {
            if (insertValue.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un numar in casetă.");
                alert.showAndWait();
            } else if (!insertValue.getText().matches("^-?\\d{1,3}$")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                alert.showAndWait();
            } else {

                int value = Integer.parseInt(insertValue.getText());

                String node = insertValue.getText();
                if (bstNodes.getText().isEmpty()) {
                    bstNodes.setText(node);
                } else {
                    bstNodes.setText(bstNodes.getText() + "  " + node);
                }

                BSTNode bstNode = new BSTNode(value);
                insert(bstNode);
            }
            insertValue.setText("");
        } else if (event.getSource() == deleteButton) {
            if (deleteValue.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un numar in casetă.");
                alert.showAndWait();
            } else if (bstNodes.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Arborele este gol.");
                alert.showAndWait();
            } else if (!deleteValue.getText().matches("^-?\\d{1,3}$")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                alert.showAndWait();
            } else {
                int value = Integer.parseInt(deleteValue.getText());
                BSTNode bstNode = search(tree.getRoot(), value);
                if (bstNode != BSTNode.Nil) {
                    delete(bstNode);
                }
            }
            deleteValue.setText("");
        } else if (event.getSource() == searchButton) {
            if (searchValue.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un numar in casetă.");
                alert.showAndWait();
            } else if (!searchValue.getText().matches("^-?\\d{1,3}$")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Arborele este gol.");
                alert.showAndWait();
            } else if (bstNodes.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                alert.showAndWait();
            } else {
                int value = Integer.parseInt(searchValue.getText());
                BSTNode bstNode = search(tree.getRoot(), value);
            }
            searchValue.setText("");
        }
    }

    @FXML
    void inputPressed(javafx.scene.input.KeyEvent event) {
        Alert alert;
        if (event.getCode() == KeyCode.ENTER) {
            if (event.getSource() == insertValue) {
                if (insertValue.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un numar in casetă.");
                    alert.showAndWait();
                } else if (!insertValue.getText().matches("^-?\\d{1,3}$")) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                    alert.showAndWait();
                } else {

                    int value = Integer.parseInt(insertValue.getText());

                    String node = insertValue.getText();
                    if (bstNodes.getText().isEmpty()) {
                        bstNodes.setText(node);
                    } else {
                        bstNodes.setText(bstNodes.getText() + "  " + node);
                    }

                    BSTNode bstNode = new BSTNode(value);
                    insert(bstNode);
                }
                insertValue.setText("");
            } else if (event.getSource() == deleteValue) {
                if (deleteValue.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un numar in casetă.");
                    alert.showAndWait();
                } else if (bstNodes.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Arborele este gol.");
                    alert.showAndWait();
                } else if (!deleteValue.getText().matches("^-?\\d{1,3}$")) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                    alert.showAndWait();
                } else {
                    int value = Integer.parseInt(deleteValue.getText());
                    BSTNode bstNode = search(tree.getRoot(), value);
                    if (bstNode != BSTNode.Nil) {
                        delete(bstNode);
                    }
                }
                deleteValue.setText("");
            } else if (event.getSource() == searchValue) {
                if (searchValue.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un numar in casetă.");
                    alert.showAndWait();
                } else if (!searchValue.getText().matches("^-?\\d{1,3}$")) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Arborele este gol.");
                    alert.showAndWait();
                } else if (bstNodes.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                    alert.showAndWait();
                } else {
                    int value = Integer.parseInt(searchValue.getText());
                    BSTNode bstNode = search(tree.getRoot(), value);
                }
                searchValue.setText("");
            }
        }
    }


    public GridPane initializeGridPane(int rows, int columns) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: rgba(0,0,0,0);");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setPrefHeight(60);
                anchorPane.setPrefWidth(60);

                gridPane.add(anchorPane, j, i);
            }
        }
        if ((700 - (columns * 30)) > 0) {
            gridPane.setLayoutX(700 - (columns * 30));
        } else {
            gridPane.setLayoutX(0);
        }
        gridPane.setLayoutY(40);
        return gridPane;
    }

    public AnchorPane initializeAnchorPane() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: rgba(0,0,0,0);");
        anchorPane.setPrefWidth(1390);
        anchorPane.setPrefHeight(590);
        anchorPane.setLayoutX(0);
        anchorPane.setLayoutY(0);
        return anchorPane;
    }

    public ScrollPane initializeScrollPane() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(1400);
        scrollPane.setPrefHeight(600);
        scrollPane.setLayoutX(0);
        scrollPane.setLayoutY(0);
        scrollPane.setPannable(true);
        return scrollPane;
    }

    public void createStep(BSTNode... highlights) {
        generateLevels(tree.getRoot(), 1);

        int rows = depth(tree.getRoot());
        int columns = sumPower(depth(tree.getRoot()));

        ScrollPane scrollPane = initializeScrollPane();

        AnchorPane anchorPane = initializeAnchorPane();

        GridPane gridPane = initializeGridPane(rows, columns);

        // gridPane.setGridLinesVisible(true);

        generateGrid(anchorPane, gridPane, tree.getRoot(), 0, columns - 1, highlights);
        anchorPane.getChildren().add(gridPane);
        scrollPane.setContent(anchorPane);
        content.getChildren().add(scrollPane);
    }

    public void generateGrid(AnchorPane pane, GridPane gridPane, BSTNode BSTNode, int left, int right, BSTNode... highlights) {
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setCenterX(30);
        circle.setCenterY(30);
        circle.setStrokeWidth(2);
        circle.setStrokeType(StrokeType.INSIDE);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setFill(javafx.scene.paint.Color.WHITE);
        Label label = new Label(BSTNode.getKey() + "");
        label.setTextFill(javafx.scene.paint.Color.BLACK);
        label.setPrefHeight(40);
        label.setPrefWidth(40);
        label.setLayoutX(10);
        label.setLayoutY(10);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(18));

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(60);
        anchorPane.setPrefWidth(60);
        anchorPane.getChildren().addAll(circle, label);

        for (BSTNode highlight : highlights) {
            if (BSTNode == highlight) {
                Circle highlighter = new Circle();
                highlighter.setRadius(25);
                // highlighter.setFill(javafx.scene.paint.Color.GREEN);
                Shadow shadow = new Shadow();
                shadow.setBlurType(BlurType.GAUSSIAN);
                shadow.setColor(javafx.scene.paint.Color.LIGHTSEAGREEN);
                shadow.setHeight(20);
                shadow.setRadius(12);
                shadow.setWidth(20);
                highlighter.setEffect(shadow);
                highlighter.setCenterX(30);
                highlighter.setCenterY(30);
                if (anchorPane.getChildren().size() == 2) {
                    anchorPane.getChildren().add(0, highlighter);
                }
            }
        }

        int column = left + ((right - left) / 2);
        int row = BSTNode.getLevel() - 1;

        gridPane.add(anchorPane, column, row);

        if (BSTNode.getLeft() != implementations.BSTNode.Nil) {
            Line line = new Line();
            line.setStroke(javafx.scene.paint.Color.BLACK);
            line.setStrokeWidth(2);
            line.setLayoutX(gridPane.getLayoutX() + (left + ((column - 1 - left) / 2)) * 60 + 30);
            line.setLayoutY(gridPane.getLayoutY() + (row + 1) * 60 + 30);
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX((column - (left + ((column - left - 1) / 2))) * 60);
            line.setEndY(-60);
            pane.getChildren().add(line);

            generateGrid(pane, gridPane, BSTNode.getLeft(), left, column - 1, highlights);
        }
        if (BSTNode.getRight() != implementations.BSTNode.Nil) {
            Line line = new Line();
            line.setStroke(javafx.scene.paint.Color.BLACK);
            line.setStrokeWidth(2);
            line.setLayoutX(gridPane.getLayoutX() + ((column + 1) + ((right - column - 1) / 2)) * 60 + 30);
            line.setLayoutY(gridPane.getLayoutY() + (row + 1) * 60 + 30);
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX((column - (left + ((column - left - 1) / 2))) * (-60));
            line.setEndY(-60);
            pane.getChildren().add(line);

            generateGrid(pane, gridPane, BSTNode.getRight(), column + 1, right, highlights);
        }
    }

    public void generateLevels(BSTNode x, int level) {
        if (x != BSTNode.Nil) {
            generateLevels(x.getLeft(), level + 1);
            generateLevels(x.getRight(), level + 1);
            x.setLevel(level);
        }
    }

    public void leftRotate(BSTNode x) {
        BSTNode y = x.getRight();
        createStep(x, y);
        x.setRight(y.getLeft());
        if (y.getLeft() != BSTNode.Nil) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == BSTNode.Nil) {
            tree.setRoot(y);
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
        createStep(x, y);
        createStep();
    }

    public void rightRotate(BSTNode x) {
        BSTNode y = x.getLeft();
        createStep(x, y);
        x.setLeft(y.getRight());
        if (y.getRight() != BSTNode.Nil) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == BSTNode.Nil) {
            tree.setRoot(y);
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setRight(x);
        x.setParent(y);
        createStep(x, y);
        createStep();
    }

    public BSTNode maximum(BSTNode w) {
        BSTNode x = w;
        createStep(x);
        while (x.getRight() != BSTNode.Nil) {
            createStep(x.getRight());
            x = x.getRight();
        }
        createStep();
        return x;
    }

    public BSTNode minimum(BSTNode w) {
        BSTNode x = w;
        while (x.getLeft() != BSTNode.Nil) {
            x = x.getLeft();
        }
        return x;
    }

    BSTNode successor(BSTNode w) {
        if (w == BSTNode.Nil) {
            return w;
        }
        BSTNode x = w;
        if (x.getRight() != BSTNode.Nil) return minimum(x.getRight());
        BSTNode y = x.getParent();
        while (y != BSTNode.Nil && x == y.getRight()) {
            x = y;
            y = x.getParent();
        }
        return y;
    }

    BSTNode predecessor(BSTNode w) {
        if (w == BSTNode.Nil) {
            return w;
        }
        BSTNode x = w;
        if (x.getLeft() != BSTNode.Nil) {
            return maximum(x.getLeft());
        }
        BSTNode y = x.getParent();
        createStep(y);
        while (y != BSTNode.Nil && x == y.getLeft()) {
            x = y;
            y = x.getParent();
            createStep(y);
        }
        createStep();
        return y;
    }

    public void insert(BSTNode z) {
        BSTNode y = BSTNode.Nil;
        BSTNode x = tree.getRoot();

        while (x != BSTNode.Nil) {
            y = x;
            createStep(y);
            x = (z.getKey() < x.getKey()) ? x.getLeft() : x.getRight();
        }

        z.setParent(y);
        if (y == BSTNode.Nil) {
            tree.setRoot(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca rădăcină.");
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca fiu stâng al nodului " + y.getKey() + ".");
        } else {
            y.setRight(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca fiu drept al nodului " + y.getKey() + ".");
        }

        z.setLeft(BSTNode.Nil);
        z.setRight(BSTNode.Nil);
        createStep(z);
        createStep();
    }


    public void delete(BSTNode z) {
        BSTNode y = (z.getLeft() == BSTNode.Nil || z.getRight() == BSTNode.Nil) ? z : predecessor(z);
        BSTNode x = (y.getLeft() != BSTNode.Nil) ? y.getLeft() : y.getRight();
        createStep(x, y, z);
        x.setParent(y.getParent());
        if (y.getParent() == BSTNode.Nil) {
            tree.setRoot(x);
            updateStatusMessage("Nodul " + z.getKey() + " a fost șters. " + x.getKey() + " devine noua rădăcină.");
        } else {
            if (y == y.getParent().getLeft()) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
            updateStatusMessage("Nodul " + z.getKey() + " a fost șters din subarborele nodului " + y.getParent().getKey() + ".");
        }
        if (y != z) {
            z.setKey(y.getKey());
            updateStatusMessage("Cheia nodului " + y.getKey() + " a fost copiată în nodul șters.");
        }
        createStep(x, y, z);
        createStep();
    }


    public int depth(BSTNode BSTNode) {
        if (BSTNode == implementations.BSTNode.Nil) {
            return 0;
        } else {
            int lDepth = depth(BSTNode.getLeft());
            int rDepth = depth(BSTNode.getRight());
            return (lDepth < rDepth ? rDepth : lDepth) + 1;
        }
    }

    public int sumPower(int pow) {
        int sum = 0;
        for (int i = 0; i < pow; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }

    public BSTNode search(BSTNode w, int key) {
        createStep(w);
        if (w.getKey() == key) {
            updateStatusMessage("Nodul " + key + " a fost găsit.");
            return w;
        }
        else if(w == BSTNode.Nil)
        {
            updateStatusMessage("Nodul " + key + " NU a fost găsit.");
            return w;
        }
        return search((key < w.getKey()) ? w.getLeft() : w.getRight(), key);
    }

    public void display(BSTNode w, int indent) {
        if (w != BSTNode.Nil) {
            display(w.getRight(), indent + 5);
            for (int i = 0; i < indent; i++) {
                System.out.print(" ");
            }
            System.out.println(w.getLevel() + " : " + w.getKey());
            display(w.getLeft(), indent + 5);
        }
    }
}