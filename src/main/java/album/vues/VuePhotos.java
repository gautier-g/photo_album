package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class VuePhotos implements Observateur {
    @FXML
    private VBox self;
    @FXML
    private FlowPane listePhotos;

    private SujetObserve sujetObserve;
    private Stage stage;

    public VuePhotos(SujetObserve sujetObserve, Stage stage) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
        this.stage = stage;
    }

    @Override
    public void reagir() {
        if (this.sujetObserve.isMode_normal()) {
            self.setVisible(true);
            self.setManaged(true);
        }
        else {
            self.setVisible(false);
            self.setManaged(false);
        }
        listePhotos.getChildren().clear();
        for (int i = 0; i<sujetObserve.getPhotosAlbum().size(); i++) {
            ImageView imageView = new ImageView(sujetObserve.getPhotosAlbum().get(i).toString());
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            int finalI = i;
            imageView.setOnMouseClicked(mouseEvent -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Voulez-vous placer l'image à gauche ?");
                alert.setContentText("(si non: image à droite)");

                alert.showAndWait().ifPresent(response -> {
                    int index = this.sujetObserve.getPageAffichee();
                    if (response == ButtonType.OK) {
                        this.sujetObserve.getPagesAlbum().get(index).setCheminImageGauche(this.sujetObserve.getPhotosAlbum().get(finalI));
                    } else {
                        this.sujetObserve.getPagesAlbum().get(index).setCheminImageDroite(this.sujetObserve.getPhotosAlbum().get(finalI));
                    }
                    this.sujetObserve.notifierObservateurs();
                });
            });

            listePhotos.getChildren().add(imageView);
        }
    }

    @FXML
    public void ajouterPhotos() throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(this.stage);
        if (selectedFile != null) {
            sujetObserve.addPhotosAlbum(selectedFile.getAbsoluteFile().toURL());
        }
        reagir();
    }
}
