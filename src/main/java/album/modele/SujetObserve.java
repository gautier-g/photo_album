package album.modele;

import album.pages.DoublePage;
import album.vues.Observateur;
import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<DoublePage> album;
    private int pageAffichee;

    private ArrayList<Observateur> observateurs;

    public void ajouterObservateur(Observateur obs) {
        this.observateurs.add(obs);
    }

    public void notifierObservateurs() {
        for (int i = 0; i < this.observateurs.size(); i++) {
            this.observateurs.get(i).reagir();
        }
    }

    public SujetObserve() {
        DoublePage doublePage1 = new DoublePage("Image 1", getClass().getResource("/image_basique_1"), "Image 2", getClass().getResource("/image_basique_2"));
        DoublePage doublePage2 = new DoublePage("Image 3", getClass().getResource("/image_basique_3"), "Image 4", getClass().getResource("/image_basique_4"));
        ArrayList<DoublePage> doublePages = new ArrayList<>();
        doublePages.add(doublePage1);
        doublePages.add(doublePage2);
        this.album = doublePages;
        this.pageAffichee = 0;
        this.observateurs = new ArrayList<>();
    }
}
