package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePages implements Observateur {
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

    public VuePages(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
    }

    @FXML
    private void initialize() {
        flecheGauche.setImage(new Image(String.valueOf(getClass().getResource("/fleche_partielle.jpg"))));
        flecheDroite.setImage(new Image(String.valueOf(getClass().getResource("/fleche_remplie.jpg"))));
        boutonPlus.setImage(new Image(String.valueOf(getClass().getResource("/symbole_plus.jpg"))));
        boutonMoins.setImage(new Image(String.valueOf(getClass().getResource("/symbole_moins.jpg"))));
        boutonMoins.setOpacity(0.2);
    }

    @Override
    public void reagir() {

    }

    public String creerPopUp() {
        TextInputDialog dialogue = new TextInputDialog();
        dialogue.setTitle("Entrée de texte");
        dialogue.setHeaderText("Entrez une valeur :");
        dialogue.setContentText("Valeur :");

        return dialogue.showAndWait().get();
    }

    public void montrerAlerte(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void modifierNomGauche() {
        String nom = creerPopUp();
        if (nom.length() > 20) {
            montrerAlerte("Nom trop long (20 charactères maximum)");
        }
        else {
            this.nomGauche.setText(nom);
        }
    }

    @FXML
    public void modifierImageGauche() {

    }

    @FXML
    public void modifierNomDroit() {
        String nom = creerPopUp();
        if (nom.length() > 20) {
            montrerAlerte("Nom trop long (20 charactères maximum)");
        }
        else {
            this.nomDroit.setText(nom);
        }
    }

    @FXML
    public void modifierImageDroite() {

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
