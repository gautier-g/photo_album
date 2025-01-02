package album.vues;

import album.modele.SujetObserve;

public class VueVignettes implements Observateur {
    private SujetObserve sujetObserve;

    public VueVignettes(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
    }

    @Override
    public void reagir() {

    }
}
