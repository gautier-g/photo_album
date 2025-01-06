import album.modele.SujetObserve;
import album.pages.DoublePage;
import album.vues.Observateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SujetObserveTest {

    private SujetObserve sujetObserve;

    @BeforeEach
    void setUp() {
        sujetObserve = new SujetObserve();
    }

    @Test
    void testSetPagesAlbum() {
        ArrayList<DoublePage> pages = new ArrayList<>();
        pages.add(new DoublePage("Image 5", getClass().getResource("/image_basique_5.jpg"), "Image 6", getClass().getResource("/image_basique_6.jpg")));

        sujetObserve.setPagesAlbum(pages);

        assertEquals(1, sujetObserve.getPagesAlbum().size());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testAddPageAlbum() {
        int initialSize = sujetObserve.getPagesAlbum().size();
        sujetObserve.addPageAlbum();

        assertEquals(initialSize + 1, sujetObserve.getPagesAlbum().size());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testRemovePageAlbum() {
        sujetObserve.removePageAlbum(0);

        assertEquals(1, sujetObserve.getPagesAlbum().size());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testSetPhotosAlbum() {
        ArrayList<URL> photos = new ArrayList<>();
        photos.add(getClass().getResource("/image_basique_5.jpg"));

        sujetObserve.setPhotosAlbum(photos);

        assertEquals(1, sujetObserve.getPhotosAlbum().size());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testAddPhotosAlbum() {
        URL newPhoto = getClass().getResource("/image_basique_5.jpg");
        sujetObserve.addPhotosAlbum(newPhoto);

        assertTrue(sujetObserve.getPhotosAlbum().contains(newPhoto));
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testSetPageAffichee() {
        sujetObserve.setPageAffichee(1);

        assertEquals(1, sujetObserve.getPageAffichee());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testSetNomAlbum() {
        sujetObserve.setNomAlbum("Nouveau nom");

        assertEquals("Nouveau nom", sujetObserve.getNomAlbum());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testSetModeNormal() {
        sujetObserve.setMode_normal(false);

        assertFalse(sujetObserve.isMode_normal());
        assertTrue(sujetObserve.isEst_modifie());
    }

    @Test
    void testSauvegarderDansFichierJSON() throws IOException {
        File file = new File("album_test.json");
        if (file.exists()) {
            file.delete();
        }

        sujetObserve.sauvegarderDansFichierJSON(file);

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    void testOuvrirAlbumDepuisJSON() throws IOException {
        File file = new File("album_test.json");
        sujetObserve.sauvegarderDansFichierJSON(file);

        SujetObserve loadedAlbum = SujetObserve.ouvrirAlbumDepuisJSON(file.getPath());

        assertNotNull(loadedAlbum);
        assertEquals(sujetObserve.getNomAlbum(), loadedAlbum.getNomAlbum());

        file.delete();
    }
}
