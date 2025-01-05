package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueVignettes implements Observateur {
    @FXML
    private ScrollPane self;
    @FXML
    private FlowPane flowPane;
    private SujetObserve sujetObserve;

    public VueVignettes(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        if (this.sujetObserve.isMode_normal()) {
            self.setVisible(false);
            self.setManaged(false);
        }
        else {
            self.setVisible(true);
            self.setManaged(true);
        }
        this.flowPane.getChildren().clear();
        for (int i = 0; i<this.sujetObserve.getPagesAlbum().size(); i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(30);
            hBox.setMinWidth(270);
            hBox.setMaxWidth(270);
            hBox.setMinHeight(140);
            hBox.setMaxHeight(140);
            hBox.setPadding(new Insets(20));
            HBox.setMargin(hBox, new Insets(20));
            hBox.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            ImageView imageView1 = new ImageView(this.sujetObserve.getPagesAlbum().get(i).getCheminImageGauche().toString());
            imageView1.setFitHeight(100);
            imageView1.setFitWidth(100);
            ImageView imageView2 = new ImageView(this.sujetObserve.getPagesAlbum().get(i).getCheminImageDroite().toString());
            imageView2.setFitHeight(100);
            imageView2.setFitWidth(100);
            hBox.getChildren().add(imageView1);
            hBox.getChildren().add(imageView2);
            int finalI = i;
            hBox.setOnMouseClicked(mouseEvent -> {
                this.sujetObserve.setPageAffichee(finalI);
                this.sujetObserve.setMode_normal(true);
                this.sujetObserve.notifierObservateurs();
            });
            this.flowPane.getChildren().add(hBox);
        }
    }
}
