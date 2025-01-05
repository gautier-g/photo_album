package album.vues;

import album.modele.SujetObserve;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

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
        if (this.sujetObserve.isMode_normal()) {
            this.boutonSwitchMode.setText("Mode Vignettes");
        }
        else {
            this.boutonSwitchMode.setText("Mode Normal");
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

    public void creerAlbum() {

    }

    public void ouvrirAlbum() {

    }

    public void sauvegarderAlbum() {

    }

    public void quitter() {
        Platform.exit();
    }

    public void nommerAlbum() {
        String nom = creerPopUp();
        if (nom.length() > 20) {
            montrerAlerte("Nom trop long (20 charactères maximum)");
        }
        else {
            this.sujetObserve.setNomAlbum(nom);
            this.sujetObserve.notifierObservateurs();
        }
    }

    public void switchMode() {
        this.sujetObserve.setMode_normal(!this.sujetObserve.isMode_normal());
        this.sujetObserve.notifierObservateurs();
    }
}
