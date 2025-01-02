package album.modele;

import album.vues.Observateur;
import album.vues.*;
import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur> observateurs;

    public void ajouterObservateur(Observateur obs) {
        this.observateurs.add(obs);
    }

    public void notifierObservateurs() {
        for (int i = 0; i < this.observateurs.size(); i++) {
            this.observateurs.get(i).reagir();
        }
    }
}
