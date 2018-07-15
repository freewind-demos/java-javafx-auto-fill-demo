package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().addAll(
                    new HBox() {{
                        this.setPrefHeight(100);
                        this.setStyle("-fx-background-color: GREEN");
                        getChildren().add(new Button("Auto Fill Button 1") {{
                            // only work with HBox/VBox
                            setMaxWidth(Double.MAX_VALUE);
                            setPrefHeight(Double.MAX_VALUE);
                        }});
                        setHgrow(getChildren().get(0), Priority.ALWAYS);
                    }},
                    new Pane() {{
                        final Pane self = this;
                        this.setPrefHeight(100);
                        this.setStyle("-fx-background-color: RED");
                        getChildren().add(new Button("Auto Fill Button 2") {{
                            // work with all panes
                            this.prefHeightProperty().bind(self.heightProperty());
                            this.prefWidthProperty().bind(self.widthProperty());
                        }});
                    }}
            );
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}