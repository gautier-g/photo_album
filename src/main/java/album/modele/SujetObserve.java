package album.modele;

import album.pages.DoublePage;
import album.pages.URLAdapter;
import album.vues.Observateur;

import java.beans.Transient;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class SujetObserve {
    @Expose
    private ArrayList<DoublePage> pagesAlbum;
    @Expose
    private ArrayList<URL> photosAlbum;
    @Expose
    private int pageAffichee;
    @Expose
    private String nomAlbum;
    @Expose
    private boolean mode_normal;
    private boolean est_modifie;

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

    public void setPagesAlbum(ArrayList<DoublePage> pagesAlbum) {
        this.pagesAlbum = pagesAlbum;
        this.est_modifie = true;
    }

    public void setPhotosAlbum(ArrayList<URL> photosAlbum) {
        this.photosAlbum = photosAlbum;
        this.est_modifie = true;
    }

    public void removePageAlbum(int index) {
        this.pagesAlbum.remove(this.pagesAlbum.get(index));
        this.est_modifie = true;
    }
    public void addPageAlbum() {
        this.pagesAlbum.add(new DoublePage("Image 1", getClass().getResource("/image_basique_1.jpg"), "Image 2", getClass().getResource("/image_basique_2.jpg")));
        this.est_modifie = true;
    }
    public ArrayList<URL> getPhotosAlbum() {
        return photosAlbum;
    }
    public void addPhotosAlbum(URL photo) {
        this.photosAlbum.add(photo);
        this.est_modifie = true;
    }

    public int getPageAffichee() {
        return pageAffichee;
    }
    public void setPageAffichee(int pageAffichee) {
        this.pageAffichee = pageAffichee;
        this.est_modifie = true;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }
    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
        this.est_modifie = true;
    }
    public boolean isMode_normal() {
        return mode_normal;
    }
    public void setMode_normal(boolean mode_normal) {
        this.mode_normal = mode_normal;
        this.est_modifie = true;
    }
    public boolean isEst_modifie() {
        return est_modifie;
    }
    public void setEst_modifie(boolean est_modifie) {
        this.est_modifie = est_modifie;
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
        this.est_modifie = false;
    }

    public void sauvegarderDansFichierJSON(File file) {
        Gson gson = new GsonBuilder().registerTypeAdapter(URL.class, new URLAdapter()).excludeFieldsWithoutExposeAnnotation().create();

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SujetObserve ouvrirAlbumDepuisJSON(String filename) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, SujetObserve.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
