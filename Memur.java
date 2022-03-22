
public class Memur extends Calisan {

    public Memur(String ad, String soyad, int maas, String kimeBagli) {
        super(ad, soyad, maas, kimeBagli);
    }

    @Override
    public String toString() {
        return " Memur{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", maaş=" + maas +
                ", kimeBağlı='" + kimeBagli + '\'' +
                '}';
    }
}
