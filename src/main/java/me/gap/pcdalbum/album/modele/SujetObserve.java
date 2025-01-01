package me.gap.pcdalbum.album.modele;

import me.gap.pcdalbum.album.vues.*;
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
