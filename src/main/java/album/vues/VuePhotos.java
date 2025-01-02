package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;

public class VuePhotos implements Observateur {
    @FXML
    private

    private SujetObserve[] sujetObserves;

    public VuePhotos(SujetObserve[] sujetObserves) {
        this.sujetObserves = sujetObserves;
    }

    @Override
    public void reagir() {

    }

    public void modifierNomGauche() {

    }

    public void modifierImageGauche() {

    }

    public void modifierNomDroit() {

    }

    public void modifierImageDroite() {

    }

    public void modifierNomAlbum() {

    }

    public void modifierPagesActuelles() {

    }

    public void deplacementGauche() {

    }

    public void deplacementDroit() {

    }

    public void creerPages() {

    }

    public void supprimerPages() {

    }
}
