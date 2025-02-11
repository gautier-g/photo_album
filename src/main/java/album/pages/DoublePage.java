package album.pages;

import com.google.gson.annotations.Expose;

import java.net.URL;

public class DoublePage {
    @Expose
    private String titreGauche;
    @Expose
    private URL cheminImageGauche;
    @Expose
    private String titreDroit;
    @Expose
    private URL cheminImageDroite;

    public String getTitreGauche() {
        return titreGauche;
    }
    public void setTitreGauche(String titreGauche) {
        this.titreGauche = titreGauche;
    }
    public URL getCheminImageGauche() {
        return cheminImageGauche;
    }
    public void setCheminImageGauche(URL cheminImageGauche) {
        this.cheminImageGauche = cheminImageGauche;
    }
    public String getTitreDroit() {
        return titreDroit;
    }
    public void setTitreDroit(String titreDroit) {
        this.titreDroit = titreDroit;
    }
    public URL getCheminImageDroite() {
        return cheminImageDroite;
    }
    public void setCheminImageDroite(URL cheminImageDroite) {
        this.cheminImageDroite = cheminImageDroite;
    }

    public DoublePage(String titreGauche, URL cheminImageGauche, String titreDroit, URL cheminImageDroite) {
        this.titreGauche = titreGauche;
        this.cheminImageGauche = cheminImageGauche;
        this.titreDroit = titreDroit;
        this.cheminImageDroite = cheminImageDroite;
    }
}
