package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class VueMenu implements Observateur {
    @FXML
    private MenuItem boutonSwitchMode;

    private SujetObserve sujetObserve;

    public VueMenu(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
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
