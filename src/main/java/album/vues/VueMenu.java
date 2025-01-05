package album.vues;

import album.modele.SujetObserve;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VueMenu implements Observateur {
    @FXML
    private MenuItem boutonSwitchMode;

    private SujetObserve sujetObserve;
    private Stage stage;

    public VueMenu(SujetObserve sujetObserve, Stage stage) {
        this.sujetObserve = sujetObserve;
        this.stage = stage;
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
        this.sujetObserve = new SujetObserve();
    }

    public void ouvrirAlbum() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers JSON", "*.json"));

        File selectedFile = fileChooser.showOpenDialog(this.stage);
        if (selectedFile != null) {
            SujetObserve sujetObserve2 = SujetObserve.ouvrirAlbumDepuisJSON(selectedFile.getAbsolutePath());
            this.sujetObserve.setPagesAlbum(sujetObserve2.getPagesAlbum());
            this.sujetObserve.setMode_normal(sujetObserve2.isMode_normal());
            this.sujetObserve.setPhotosAlbum(sujetObserve2.getPhotosAlbum());
            this.sujetObserve.setPageAffichee(sujetObserve2.getPageAffichee());
            this.sujetObserve.setNomAlbum(sujetObserve2.getNomAlbum());
        }
        this.sujetObserve.notifierObservateurs();
    }

    public void sauvegarderAlbum() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choisir un dossier pour sauvegarder le fichier");

        File selectedDirectory = directoryChooser.showDialog(this.stage);

        if (selectedDirectory != null) {
            File file = new File(selectedDirectory, "album.json");
            this.sujetObserve.sauvegarderDansFichierJSON(file);
        }
        this.sujetObserve.notifierObservateurs();
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
