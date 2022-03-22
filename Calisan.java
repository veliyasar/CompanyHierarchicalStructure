
public abstract class Calisan {
    protected String ad;
    protected String soyad;
    protected int maas;
    protected String kimeBagli;

    public Calisan(String ad, String soyad, int maas, String kimeBagli) {
        this.ad = ad;
        this.soyad = soyad;
        this.maas = maas;
        this.kimeBagli = kimeBagli;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", maaş=" + maas +
                ", kimeBağlı='" + kimeBagli + '\'' +
                '}';
    }

    public String getKimeBagli() {
        return kimeBagli;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getMaas() {
        return maas;
    }

}
