package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VuePhotos implements Observateur {
    @FXML
    private Label ajouterPhotosTitre;

    private SujetObserve sujetObserve;

    public VuePhotos(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
    }

    @Override
    public void reagir() {

    }

    @FXML
    public void ajouterPhotos() {

    }
}
