package album.modele;

import album.pages.DoublePage;
import album.vues.Observateur;

import java.net.URL;
import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<DoublePage> pagesAlbum;
    private ArrayList<URL> photosAlbum;
    private int pageAffichee;
    private String nomAlbum;
    private boolean mode_normal;

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
    public void removePageAlbum(int index) {
        this.pagesAlbum.remove(this.pagesAlbum.get(index));
    }
    public void addPageAlbum() {
        this.pagesAlbum.add(new DoublePage("Image 1", getClass().getResource("/image_basique_1.jpg"), "Image 2", getClass().getResource("/image_basique_2.jpg")));
    }
    public ArrayList<URL> getPhotosAlbum() {
        return photosAlbum;
    }
    public void addPhotosAlbum(URL photo) {
        this.photosAlbum.add(photo);
    }

    public int getPageAffichee() {
        return pageAffichee;
    }
    public void setPageAffichee(int pageAffichee) {
        this.pageAffichee = pageAffichee;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }
    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
    }
    public boolean isMode_normal() {
        return mode_normal;
    }
    public void setMode_normal(boolean mode_normal) {
        this.mode_normal = mode_normal;
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
        this.photosAlbum.add(getClass().getResource("/image_basique_1.jpg"));
        this.photosAlbum.add(getClass().getResource("/image_basique_2.jpg"));
        this.photosAlbum.add(getClass().getResource("/image_basique_3.jpg"));
        this.photosAlbum.add(getClass().getResource("/image_basique_4.jpg"));
        this.nomAlbum = "Mon album photo";
        this.mode_normal = true;
    }
}
