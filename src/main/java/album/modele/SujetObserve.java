package album.modele;

import album.pages.DoublePage;
import album.vues.Observateur;
import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<DoublePage> pagesAlbum;
    private ArrayList<String> photosAlbum;
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

    public ArrayList<DoublePage> getPagesAlbum() {
        return pagesAlbum;
    }
    public void removePageAlbum(ArrayList<DoublePage> pagesAlbum, int index) {
        this.pagesAlbum.remove(pagesAlbum.get(index));
    }
    public void addPageAlbum(ArrayList<DoublePage> pagesAlbum) {
        this.pagesAlbum.add(new DoublePage("Image 1", getClass().getResource("/image_basique_1"), "Image 2", getClass().getResource("/image_basique_2")));
    }
    public ArrayList<String> getPhotosAlbum() {
        return photosAlbum;
    }
    public void addPhotosAlbum(String photo) {
        this.photosAlbum.add(photo);
    }

    public SujetObserve() {
        DoublePage doublePage1 = new DoublePage("Image 1", getClass().getResource("/image_basique_1.jpg"), "Image 2", getClass().getResource("/image_basique_2.jpg"));
        DoublePage doublePage2 = new DoublePage("Image 3", getClass().getResource("/image_basique_3.jpg"), "Image 4", getClass().getResource("/image_basique_4.jpg"));
        ArrayList<DoublePage> doublePages = new ArrayList<>();
        doublePages.add(doublePage1);
        doublePages.add(doublePage2);
        this.pagesAlbum = doublePages;
        this.pageAffichee = 0;
        this.observateurs = new ArrayList<>();
        this.photosAlbum = new ArrayList<>();
        this.photosAlbum.add(getClass().getResource("/image_basique_1.jpg").toString());
        this.photosAlbum.add(getClass().getResource("/image_basique_2.jpg").toString());
        this.photosAlbum.add(getClass().getResource("/image_basique_3.jpg").toString());
        this.photosAlbum.add(getClass().getResource("/image_basique_4.jpg").toString());
    }
}
