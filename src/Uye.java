import java.io.IOException;

public class Uye {
    public String isim;
    public String soyisim;
    public String email;
    Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public static void uyeEkle(Uye uye, boolean elit) throws IOException {
        Dosya.dosyaGuncelle(uye, elit);
    }
}
