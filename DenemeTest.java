import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DenemeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
        //iteratörlerin yaratılabilmesi için koleksiyon oluşturulur
        var koleksiyon = new CalisanCollection();
        IteratorNew iteratorDir = koleksiyon.createCalisanIterator(koleksiyon.direktorArray);
        IteratorNew iteratorMem = koleksiyon.createCalisanIterator(koleksiyon.memurArray);
//        IteratorNew iteratorMem = null;

        //oluşturulan nesneler eğer null ise AssertionFailedError ile birlikte hata mesajı verir
        assertNotNull(koleksiyon, "koleksiyon oluşturulamadı!");
        assertNotNull(iteratorDir, "itertor-direktor oluşturulamadı!");
        assertNotNull(iteratorMem, "itertor-direktor oluşturulamadı!");
    }

    @Test
    void fileRead() {
        File file = new File("girdi.txt");
        Scanner scanner = null;
        try {
            //Önce bütün dosya seçilip scanner'da tutulur
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //nerede, hangi hatanın oluştuğunu yazdırır
        }
    }


}