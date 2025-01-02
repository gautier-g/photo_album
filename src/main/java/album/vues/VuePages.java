package album.vues;

import album.modele.SujetObserve;

public class VuePages implements Observateur {
    private SujetObserve sujetObserve;

    public VuePages(SujetObserve sujetObserve) {
        this.sujetObserve = sujetObserve;
    }

    @Override
    public void reagir() {

    }
}
