package album.vues;

import album.modele.SujetObserve;

public class VueVignettes implements Observateur {
    private SujetObserve sujetObserve;

    public VueVignettes(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
        sujetObserve.ajouterObservateur(this);
    }

    @Override
    public void reagir() {

    }
}
