package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class VuePhotos implements Observateur {
    @FXML
    private Label nomGauche;
    @FXML
    private ImageView imageGauche;
    @FXML
    private Label nomDroit;
    @FXML
    private ImageView imageDroite;
    @FXML
    private Label nomAlbum;
    @FXML
    private Label pagesActuelles;
    @FXML
    private ImageView flecheGauche;
    @FXML
    private ImageView flecheDroite;
    @FXML
    private ImageView boutonPlus;
    @FXML
    private ImageView boutonMoins;

    private SujetObserve sujetObserve;

    public VuePhotos(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
    }

    @Override
    public void reagir() {

    }

    @FXML
    public void modifierNomGauche() {

    }

    @FXML
    public void modifierImageGauche() {

    }

    @FXML
    public void modifierNomDroit() {

    }

    @FXML
    public void modifierImageDroite() {

    }

    @FXML
    public void modifierNomAlbum() {

    }

    @FXML
    public void modifierPagesActuelles() {

    }

    @FXML
    public void deplacementGauche() {

    }

    @FXML
    public void deplacementDroit() {

    }

    @FXML
    public void creerPages() {

    }

    @FXML
    public void supprimerPages() {

    }
}
