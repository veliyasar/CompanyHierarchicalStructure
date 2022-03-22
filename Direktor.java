
public class Direktor extends Calisan {

    public Direktor(String ad, String soyad, int maas, String kimeBagli) {
        super(ad, soyad, maas, kimeBagli);
    }

    @Override
    public String toString() {
        return " Direktor{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", maaş=" + maas +
                ", kimeBağlı='" + kimeBagli + '\'' +
                '}';
    }
}
