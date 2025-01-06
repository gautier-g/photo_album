package album.vues;

import album.modele.SujetObserve;
import album.pages.DoublePage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VuePages implements Observateur {
    @FXML
    private VBox self;
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
        self.getChildren().add(new Label("Cliquez sur Image1 ou Image2 pour les modifier"));
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

        int pagesActuelles = sujetObserve.getPageAffichee();
        DoublePage doublePage = sujetObserve.getPagesAlbum().get(pagesActuelles);
        this.nomGauche.setText(doublePage.getTitreGauche());
        this.nomDroit.setText(doublePage.getTitreDroit());
        this.imageGauche.setImage(new Image(doublePage.getCheminImageGauche().toString()));
        this.imageDroite.setImage(new Image(doublePage.getCheminImageDroite().toString()));
        this.nomAlbum.setText("Album: " + sujetObserve.getNomAlbum());
        this.pagesActuelles.setText("Pages " + (pagesActuelles*2+1) + "-" + (pagesActuelles*2+2) + " sur " + sujetObserve.getPagesAlbum().size()*2);

        if (this.sujetObserve.getPagesAlbum().size() <= 2) {
            this.boutonMoins.setOpacity(0.2);
        }
        else {
            this.boutonMoins.setOpacity(1);
        }

        if (this.sujetObserve.getPagesAlbum().size() - 1 == this.sujetObserve.getPageAffichee()) {
            this.flecheDroite.setImage(new Image(getClass().getResource("/fleche_partielle.jpg").toString()));
        }
        else {
            this.flecheDroite.setImage(new Image(getClass().getResource("/fleche_remplie.jpg").toString()));
        }

        if (0 == this.sujetObserve.getPageAffichee()) {
            this.flecheGauche.setImage(new Image(getClass().getResource("/fleche_partielle.jpg").toString()));
        }
        else {
            this.flecheGauche.setImage(new Image(getClass().getResource("/fleche_remplie.jpg").toString()));
        }
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
            this.sujetObserve.getPagesAlbum().get(this.sujetObserve.getPageAffichee()).setTitreGauche(nom);
            reagir();
        }
    }

    @FXML
    public void modifierNomDroit() {
        String nom = creerPopUp();
        if (nom.length() > 20) {
            montrerAlerte("Nom trop long (20 charactères maximum)");
        }
        else {
            this.sujetObserve.getPagesAlbum().get(this.sujetObserve.getPageAffichee()).setTitreDroit(nom);
            reagir();
        }
    }

    @FXML
    public void deplacementGauche() {
        if (this.sujetObserve.getPageAffichee() > 0) {
            sujetObserve.setPageAffichee(this.sujetObserve.getPageAffichee()-1);
            reagir();
        }
    }

    @FXML
    public void deplacementDroit() {
        if (this.sujetObserve.getPageAffichee() < this.sujetObserve.getPagesAlbum().size() - 1) {
            sujetObserve.setPageAffichee(this.sujetObserve.getPageAffichee()+1);
            reagir();
        }
    }

    @FXML
    public void creerPages() {
        this.sujetObserve.addPageAlbum();
        this.sujetObserve.setPageAffichee(this.sujetObserve.getPagesAlbum().size() - 1);
        reagir();
    }

    @FXML
    public void supprimerPages() {
        this.sujetObserve.removePageAlbum(this.sujetObserve.getPageAffichee());
        this.sujetObserve.setPageAffichee(0);
        reagir();
    }
}
