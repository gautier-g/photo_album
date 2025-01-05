package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VuePhotos implements Observateur {
    @FXML
    private Label ajouterPhotosTitre;
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
        listePhotos.getChildren().clear();
        for (int i = 0; i<sujetObserve.getPhotosAlbum().size(); i++) {
            ImageView imageView = new ImageView(sujetObserve.getPhotosAlbum().get(i));
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            listePhotos.getChildren().add(imageView);
        }
    }

    @FXML
    public void ajouterPhotos() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(this.stage);
        if (selectedFile != null) {
            sujetObserve.addPhotosAlbum(selectedFile.toURI().toString());
        }
        reagir();
    }
}
