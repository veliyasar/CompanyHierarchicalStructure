import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Deneme {
    public static void main(String[] args) {

        File file = new File("girdi.txt");
        Scanner scanner = null;
        try {
            //Önce bütün dosya seçilip scanner'da tutulur
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //nerede, hangi hatanın oluştuğunu yazdırır
        }

        //scanner'daki input tek bir String'e aktarılır
        String str = scanner.useDelimiter("\\A").next();
        //Virgüller boşluğa çevrilir
        str = str.replaceAll(",", " ");
        //Satır sonları ("\n" gibi) boşluğa çevrilir
        str = str.replaceAll(System.lineSeparator(), " ");
        //Bütün String boşluklara göre parçalanarak bir liste oluşturulur
        List<String> items = Arrays.asList(str.split(" "));

        //iteratörlerin yaratılabilmesi için koleksiyon oluşturulur
        var koleksiyon = calisanKoleksiyonuYarat(items);
        //koleksiyondaki veriler iteratörlere yüklenir
        IteratorNew iteratorDir = koleksiyon.createCalisanIterator(koleksiyon.direktorArray);
        IteratorNew iteratorMem = koleksiyon.createCalisanIterator(koleksiyon.memurArray);

        System.out.println("\n-----------Çalışanların Listesi-----------\n");
        //iteratörler ile iki veri tipi dolaşılıp yazdırılır
        while (iteratorMem.hasNext()) {
            Memur m = (Memur) iteratorMem.next();
            System.out.print(m);
        }
        System.out.println();
        while (iteratorDir.hasNext()) {
            Direktor d = (Direktor) iteratorDir.next();
            System.out.print(d);
        }

        System.out.println("\n\n-----------İstenilen Sorgular------------");

        //yeni bir sorgu girileceği zaman yeniden koleksiyon yaratılması gerekiyor
        calisanKoleksiyonuYarat(items).direktorMaliyeti("Mustafa");
        calisanKoleksiyonuYarat(items).direktorMaliyeti("Oguz");
        calisanKoleksiyonuYarat(items).memurMaliyeti("Ahmet");
    }


    //items listesindeki bütün kelimeler Direktör veya Memur nesneler oluşturulup dizilere atanır
    //Oluşturulan diziler sadece CalisanCollection'da gözükür
    public static CalisanCollection calisanKoleksiyonuYarat(List<String> items) {
        var koleksiyon = new CalisanCollection();

        //Girdinin formatına göre veriler uygun nesnelerin oluşturulmasında kullanılır
        for (int i = 0; i < items.size(); i += 5) {
            koleksiyon.addCalisan(items.get(i), items.get(i + 1), items.get(i + 2),
                    Integer.parseInt(items.get(i + 3)), items.get(i + 4));
        }
        return koleksiyon;
    }
}
