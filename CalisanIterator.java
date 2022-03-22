public class CalisanIterator implements IteratorNew {
    Calisan[] calisanArray;
    int indeks = 0;

    //constructor ile verilerin yüklendiği diziyi alır
    public CalisanIterator(Calisan[] calisanArray) {
        this.calisanArray = calisanArray;
    }

    @Override
    //iterate edilecek daha fazla eleman olup olmadığını kontrol eder
    public boolean hasNext() {
        if(indeks >= calisanArray.length || calisanArray[indeks] == null)
            return false;
        else
            return true;
    }

    @Override
    //sıradaki Çalışanı döndürür ve indeksi artırır
    public Calisan next() {
        Calisan calisan = calisanArray[indeks];
        indeks++;
        return calisan;
    }
}
