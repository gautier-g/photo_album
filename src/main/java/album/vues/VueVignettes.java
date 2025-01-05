package album.vues;

import album.modele.SujetObserve;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

public class VueVignettes implements Observateur {
    @FXML
    private ScrollPane self;
    private SujetObserve sujetObserve;

    public VueVignettes(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        if (this.sujetObserve.isMode_normal()) {
            self.setVisible(true);
        }
        else {
            self.setVisible(false);
        }
    }
}
