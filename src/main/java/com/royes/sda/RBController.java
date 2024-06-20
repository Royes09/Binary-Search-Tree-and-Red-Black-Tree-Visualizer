package com.royes.sda;

import implementations.Color;
import implementations.RBNode;
import implementations.RBTree;
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

public class RBController {
    private final RBTree tree = new RBTree();
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
    private Label rbNodes;

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
                if (rbNodes.getText().isEmpty()) {
                    rbNodes.setText(node);
                } else {
                    rbNodes.setText(rbNodes.getText() + "  " + node);
                }

                RBNode rbNode = new RBNode(value);
                insert(rbNode);
            }
            insertValue.setText("");
        } else if (event.getSource() == deleteButton) {
            if (deleteValue.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un numar in casetă.");
                alert.showAndWait();
            } else if (rbNodes.getText().isEmpty()) {
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
                RBNode rbNode = search(tree.getRoot(), value);
                if (rbNode != RBNode.Nil) {
                    delete(rbNode);
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
            } else if (rbNodes.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                alert.showAndWait();
            } else {
                int value = Integer.parseInt(searchValue.getText());
                RBNode rbNode = search(tree.getRoot(), value);
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
                    if (rbNodes.getText().isEmpty()) {
                        rbNodes.setText(node);
                    } else {
                        rbNodes.setText(rbNodes.getText() + "  " + node);
                    }

                    RBNode rbNode = new RBNode(value);
                    insert(rbNode);
                }
                insertValue.setText("");
            } else if (event.getSource() == deleteValue) {
                if (deleteValue.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un numar in casetă.");
                    alert.showAndWait();
                } else if (rbNodes.getText().isEmpty()) {
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
                    RBNode rbNode = search(tree.getRoot(), value);
                    if (rbNode != RBNode.Nil) {
                        delete(rbNode);
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
                } else if (rbNodes.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Trebuie introdus un număr de maxim 3 cifre.");
                    alert.showAndWait();
                } else {
                    int value = Integer.parseInt(searchValue.getText());
                    RBNode rbNode = search(tree.getRoot(), value);
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

    public void createStep(RBNode... highlights) {
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

    public void generateGrid(AnchorPane pane, GridPane gridPane, RBNode RBNode, int left, int right, RBNode... highlights) {
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setCenterX(30);
        circle.setCenterY(30);
        circle.setStrokeWidth(2);
        circle.setStrokeType(StrokeType.INSIDE);
        if (RBNode.getColor() == Color.BLACK) {
            circle.setStroke(javafx.scene.paint.Color.BLACK);
            circle.setFill(javafx.scene.paint.Color.DARKSLATEGREY);
        } else {
            circle.setStroke(javafx.scene.paint.Color.DARKRED);
            circle.setFill(javafx.scene.paint.Color.RED);
        }

        Label label = new Label(RBNode.getKey() + "");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
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

        for (RBNode highlight : highlights) {
            if (RBNode == highlight) {
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
        int row = RBNode.getLevel() - 1;

        gridPane.add(anchorPane, column, row);

        if (RBNode.getLeft() != implementations.RBNode.Nil) {
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

            generateGrid(pane, gridPane, RBNode.getLeft(), left, column - 1, highlights);
        }
        if (RBNode.getRight() != implementations.RBNode.Nil) {
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

            generateGrid(pane, gridPane, RBNode.getRight(), column + 1, right, highlights);
        }
    }

    public void generateLevels(RBNode x, int level) {
        if (x != RBNode.Nil) {
            generateLevels(x.getLeft(), level + 1);
            generateLevels(x.getRight(), level + 1);
            x.setLevel(level);
        }
    }

    public void leftRotate(RBNode x) {
        RBNode y = x.getRight();
        createStep(x, y);
        x.setRight(y.getLeft());
        if (y.getLeft() != RBNode.Nil) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == RBNode.Nil) {
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

    public void rightRotate(RBNode x) {
        RBNode y = x.getLeft();
        createStep(x, y);
        x.setLeft(y.getRight());
        if (y.getRight() != RBNode.Nil) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == RBNode.Nil) {
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

    public RBNode maximum(RBNode w) {
        RBNode x = w;
        createStep(x);
        while (x.getRight() != RBNode.Nil) {
            createStep(x.getRight());
            x = x.getRight();
        }
        createStep();
        return x;
    }

    public RBNode minimum(RBNode w) {
        RBNode x = w;
        while (x.getLeft() != RBNode.Nil) {
            x = x.getLeft();
        }
        return x;
    }

    RBNode successor(RBNode w) {
        if (w == RBNode.Nil) {
            return w;
        }
        RBNode x = w;
        if (x.getRight() != RBNode.Nil) return minimum(x.getRight());
        RBNode y = x.getParent();
        while (y != RBNode.Nil && x == y.getRight()) {
            x = y;
            y = x.getParent();
        }
        return y;
    }

    RBNode predecessor(RBNode w) {
        if (w == RBNode.Nil) {
            return w;
        }
        RBNode x = w;
        if (x.getLeft() != RBNode.Nil) {
            return maximum(x.getLeft());
        }
        RBNode y = x.getParent();
        createStep(y);
        while (y != RBNode.Nil && x == y.getLeft()) {
            x = y;
            y = x.getParent();
            createStep(y);
        }
        createStep();
        return y;
    }

    public void insert(RBNode z) {
        RBNode y = RBNode.Nil;
        RBNode x = tree.getRoot();

        while (x != RBNode.Nil) {
            y = x;
            createStep(y);
            x = (z.getKey() < x.getKey()) ? x.getLeft() : x.getRight();
        }

        z.setParent(y);
        if (y == RBNode.Nil) {
            tree.setRoot(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca rădăcină.");
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca fiu stâng al nodului " + y.getKey() + ".");
        } else {
            y.setRight(z);
            updateStatusMessage("Nodul " + z.getKey() + " a fost inserat ca fiu drept al nodului " + y.getKey() + ".");
        }

        z.setLeft(RBNode.Nil);
        z.setRight(RBNode.Nil);
        z.setColor(Color.RED);
        createStep(z);
        createStep();
        insertFixup(z);
    }

    public void insertFixup(RBNode z) {
        while (z.getParent().getColor() == Color.RED) {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                RBNode y = z.getParent().getParent().getRight();
                if (y.getColor() == Color.RED) {
                    createStep(z.getParent(), y, z.getParent().getParent());
                    z.getParent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    z.getParent().getParent().setColor(Color.RED);
                    createStep(z.getParent(), y, z.getParent().getParent());
                    createStep();
                    z = z.getParent().getParent();
                    updateStatusMessage("Cazul 1: Părintele și unchiul lui " + z.getKey() + " sunt roșii.");
                } else {
                    if (z == z.getParent().getRight()) {
                        z = z.getParent();
                        leftRotate(z);
                        updateStatusMessage("Cazul 2: Nodul " + z.getKey() + " este fiu drept. Se aplică o rotație la stânga.");
                    }
                    createStep(z.getParent(), z.getParent().getParent());
                    z.getParent().setColor(Color.BLACK);
                    z.getParent().getParent().setColor(Color.RED);
                    createStep(z.getParent(), z.getParent().getParent());
                    createStep();
                    rightRotate(z.getParent().getParent());
                    updateStatusMessage("Cazul 3: Părintele lui " + z.getKey() + " este roșu, dar unchiul este negru.");
                }
            } else {
                RBNode y = z.getParent().getParent().getLeft();
                if (y.getColor() == Color.RED) {
                    createStep(z.getParent(), y, z.getParent().getParent());
                    z.getParent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    z.getParent().getParent().setColor(Color.RED);
                    createStep(z.getParent(), y, z.getParent().getParent());
                    createStep();
                    z = z.getParent().getParent();
                    updateStatusMessage("Cazul 1: Părintele și unchiul lui " + z.getKey() + " sunt roșii. Recolorare și urcarea în arbore.");
                } else {
                    if (z == z.getParent().getLeft()) {
                        z = z.getParent();
                        rightRotate(z);
                        updateStatusMessage("Cazul 2: Nodul " + z.getKey() + " este fiul stâng. Se aplică o rotație la dreapta.");
                    }
                    createStep(z.getParent(), z.getParent().getParent());
                    z.getParent().setColor(Color.BLACK);
                    z.getParent().getParent().setColor(Color.RED);
                    createStep(z.getParent(), z.getParent().getParent());
                    createStep();
                    leftRotate(z.getParent().getParent());
                    updateStatusMessage("Cazul 3: Părintele lui " + z.getKey() + " este roșu, iar unchiul este negru. Se aplică o rotație la stânga.");
                }
            }
        }
        if (tree.getRoot().getColor() == Color.RED) {
            createStep(tree.getRoot());
            tree.getRoot().setColor(Color.BLACK);
            createStep(tree.getRoot());
            createStep();
            updateStatusMessage("Rădăcina arborelui a fost setată la negru.");
        }
    }

    public void delete(RBNode z) {
        RBNode y = (z.getLeft() == RBNode.Nil || z.getRight() == RBNode.Nil) ? z : predecessor(z);
        RBNode x = (y.getLeft() != RBNode.Nil) ? y.getLeft() : y.getRight();
        createStep(x, y, z);
        x.setParent(y.getParent());
        if (y.getParent() == RBNode.Nil) {
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
        if (y.getColor() == Color.BLACK) {
            deleteFixup(x);
        }
    }

    public void deleteFixup(RBNode x) {
        RBNode w;
        while (x != tree.getRoot() && x.getColor() == Color.BLACK) {
            if (x == x.getParent().getLeft()) {
                w = x.getParent().getRight();
                if (w.getColor() == Color.RED) {
                    createStep(w, x.getParent());
                    w.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    createStep(w, x.getParent());
                    createStep();
                    leftRotate(x.getParent());
                    w = x.getParent().getRight();
                    updateStatusMessage("Fratele nodului " + x.getKey() + " este roșu. Se aplică rotație la stânga pe părintele nodului " + x.getKey() + ".");
                }
                if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
                    createStep(w);
                    w.setColor(Color.RED);
                    createStep(w);
                    createStep();
                    x = x.getParent();
                    updateStatusMessage("Ambii copii ai fratelui nodului " + x.getKey() + " sunt negri. Se setează fratele nodului " + x.getKey() + " la roșu.");
                } else {
                    if (w.getRight().getColor() == Color.BLACK) {
                        createStep(w.getRight(), w);
                        w.getRight().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        createStep(w.getRight(), w);
                        createStep();
                        rightRotate(w);
                        w = x.getParent().getRight();
                        updateStatusMessage("Copilul drept al fratelui nodului " + x.getKey() + " este negru. Se aplică rotație la dreapta pe fratele nodului " + x.getKey() + ".");
                    }
                    createStep(w, x.getParent(), w.getRight());
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    w.getRight().setColor(Color.BLACK);
                    createStep(w, x.getParent(), w.getRight());
                    createStep();
                    leftRotate(x.getParent());
                    x = tree.getRoot();
                    updateStatusMessage("Se repară echilibrul de culoare după ștergerea nodului.");
                }
            } else {
                w = x.getParent().getLeft();
                if (w.getColor() == Color.RED) {
                    createStep(w, x.getParent());
                    w.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    createStep(w, x.getParent());
                    createStep();
                    rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                    updateStatusMessage("Fratele nodului " + x.getKey() + " este roșu. Se aplică rotație la dreapta pe părintele nodului " + x.getKey() + ".");
                }
                if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
                    createStep(w);
                    w.setColor(Color.RED);
                    createStep(w);
                    createStep();
                    x = x.getParent();
                    updateStatusMessage("Ambii copii ai fratelui nodului " + x.getKey() + " sunt negri. Se setează fratele nodului " + x.getKey() + " la roșu.");
                } else {
                    if (w.getLeft().getColor() == Color.BLACK) {
                        createStep(w.getRight(), w);
                        w.getRight().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        createStep(w.getRight(), w);
                        createStep();
                        leftRotate(w);
                        w = x.getParent().getLeft();
                        updateStatusMessage("Copilul stâng al fratelui nodului " + x.getKey() + " este negru. Se aplică rotație la stânga pe fratele nodului " + x.getKey() + ".");
                    }
                    createStep(w, x.getParent(), w.getLeft());
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    w.getLeft().setColor(Color.BLACK);
                    createStep(w, x.getParent(), w.getLeft());
                    createStep();
                    rightRotate(x.getParent());
                    x = tree.getRoot();
                    updateStatusMessage("Se repară echilibrul de culoare după ștergerea nodului " + x.getKey() + ".");
                }
            }
        }
        if (x.getColor() == Color.RED) {
            createStep(x);
            x.setColor(Color.BLACK);
            createStep(x);
            createStep();
            //updateStatusMessage("Se setează culoarea nodului " + x.getKey() + " la negru pentru finalizarea procesului de ștergere.");updateStatusMessage("Se setează culoarea nodului " + x.getKey() + " la negru pentru finalizarea procesului de ștergere.");
        }
    }


    public int depth(RBNode RBNode) {
        if (RBNode == implementations.RBNode.Nil) {
            return 0;
        } else {
            int lDepth = depth(RBNode.getLeft());
            int rDepth = depth(RBNode.getRight());
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

    public RBNode search(RBNode w, int key) {
        createStep(w);
        if (w.getKey() == key) {
            updateStatusMessage("Nodul " + key + " a fost găsit.");
            return w;
        }
        else if(w == RBNode.Nil)
        {
            updateStatusMessage("Nodul " + key + " NU a fost găsit.");
            return w;
        }
        return search((key < w.getKey()) ? w.getLeft() : w.getRight(), key);
    }

    public void display(RBNode w, int indent) {
        if (w != RBNode.Nil) {
            display(w.getRight(), indent + 5);
            for (int i = 0; i < indent; i++) {
                System.out.print(" ");
            }
            System.out.println(w.getLevel() + " : " + w.getKey() + " " + w.getColor().toString());
            display(w.getLeft(), indent + 5);
        }
    }
}