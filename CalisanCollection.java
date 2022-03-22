import java.util.ArrayList;

public class CalisanCollection {
    Memur[] memurArray;
    Direktor[] direktorArray;

    public CalisanCollection() {
        direktorArray = new Direktor[99];
        memurArray = new Memur[99];
    }

    //Elemanları iki türe göre ayırır ve nesne halinde dizilere atar
    public void addCalisan(String dORm, String ad, String soyad, int maas, String kimeBagli) {

        if (dORm.equals("D")) {
            Direktor direktor = new Direktor(ad, soyad, maas, kimeBagli);
            int openSlot = 0; //Dizinin içindeki ilk boş yeri bulur
            for (int i = 0; i < direktorArray.length; i++) {
                if(direktorArray[i] == null) {
                    openSlot = i;
                    break;
                }
            }
            direktorArray[openSlot] = direktor;
        } else
            if (dORm.equals("M")) {
                Memur memur = new Memur(ad, soyad, maas, kimeBagli);
                int openSlot = 0;
                for (int i = 0; i < memurArray.length; i++) {
                    if(memurArray[i] == null) {
                        openSlot = i;
                        break;
                    }
                }
                memurArray[openSlot] = memur;
        }
    }

    protected int total = 0; //Total maliyet
    protected final ArrayList<Calisan> emredilenler = new ArrayList<Calisan>(); //Çalışanın emrindekilerin listesi

    //Direktörün kendi maaşı ve emrindekilerin maaşları toplamı
    public void direktorMaliyeti(String direktorAdi) {
        //Direktör bilgilerini yazdırırken gerekli
        String direktorSoyadi = null;
        //Döngüde daha önce bahsedilen direktörleri tutar
        var tempDirNames = new ArrayList<String>();

        for (Direktor d : direktorArray) {
            //NullPointer hatasında programın çökmeden devam etmesi için try-catch bloğu
            try {
                //Direktörün kendi maaşını eklemek için
                if (d.getAd().equals(direktorAdi))  {
                    direktorSoyadi = d.getSoyad();
                    total += d.getMaas();
                } else
                    //Direktöre ilk katmandan bağlı olan direktörleri eklemek için.
                    if (d.getKimeBagli().equals(direktorAdi)) {
                        emredilenler.add(d);
                        tempDirNames.add(d.getAd());
                        total += d.getMaas();
                } else
                    //Daha önceden alt katmanda olduğu bulunan direktörlere bağlı başka direktörlerin veya
                    //memurların varlığı için kontrol
                    if (tempDirNames.contains(d.getKimeBagli())) {
                        emredilenler.add(d);
                        total += d.getMaas();
                        hierarchyBelow(d.getAd());
                }
            } catch (NullPointerException e) {
                break;
            }
        }

        //İlk katmandan bağlı olan memurlar için
        for (Memur m : memurArray) {
            try {
                if (m.getKimeBagli().equals(direktorAdi)) {
                    emredilenler.add(m);
                    total += m.getMaas();
                }
            } catch (NullPointerException e) {
                break;
            }
        }

        System.out.println("\n" + direktorAdi + " " + direktorSoyadi +
                " adlı direktörün maliyeti:  ₺" + total + "\n");
        System.out.println(direktorAdi + " " + direktorSoyadi + "'in emrindekiler: ");

        //emrindekilerin listesinin yazdırılması
        for (var e : emredilenler) {
            if (e instanceof Direktor) {
                System.out.print("Direktör, ");
            } else
                System.out.print("Memur, ");
            System.out.println("Adı: " + e.getAd() + " " + e.getSoyad() +
                    ", Maaşı: " + e.getMaas() + ", Bağlı old. direktör: " + e.getKimeBagli());
        }
    }

    //Sadece memurun kendi maaşı
    public void memurMaliyeti(String memurAdi) {
        String memurSoyadi = null;
        for (var m : memurArray) {
            try {
                if (m.getAd().equals(memurAdi)) {
                    total = m.getMaas();
                    memurSoyadi = m.getSoyad();
                    break;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        System.out.println("\n" + memurAdi + " " + memurSoyadi + " adlı memurun maliyeti: ₺" + total);
    }

    //Aşağıya doğru hiyerarşide bulunan çalışanların emrindekiler listesine ve maaşlar toplamına eklenmesi
    public void hierarchyBelow(String tempDirektorAdi) {

        for (Direktor d : direktorArray) {
            try {
                if (d.getKimeBagli().equals(tempDirektorAdi)) {
                    emredilenler.add(d);
                    total += d.getMaas();
                }
            } catch (NullPointerException e) {
                break;
            }
        }

        for (Memur m : memurArray) {
            try {
                if (m.getKimeBagli().equals(tempDirektorAdi)) {
                    emredilenler.add(m);
                    total += m.getMaas();
                }
            } catch (NullPointerException e) {
                break;
            }
        }
    }


    public IteratorNew createCalisanIterator(Calisan[] calisanArray) {
        return new CalisanIterator(calisanArray);
    }

}
