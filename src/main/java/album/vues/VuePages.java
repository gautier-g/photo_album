package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VuePages implements Observateur {
    @FXML
    private Label ajouterPhotosTitre;

    private SujetObserve sujetObserve;

    public VuePages(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
    }

    @Override
    public void reagir() {

    }

    @FXML
    public void ajouterPhotos() {

    }
}
