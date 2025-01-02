package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.awt.*;

public class VueMenu implements Observateur {
    @FXML
    private MenuItem boutonSwitchMode;

    private SujetObserve sujetObserve;

    public VueMenu(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
    }

    @Override
    public void reagir() {

    }

    public void creerAlbum() {

    }

    public void ouvrirAlbum() {

    }

    public void sauvegarderAlbum() {

    }

    public void quitter() {

    }

    public void nommerAlbum() {

    }

    public void switchMode() {

    }
}
