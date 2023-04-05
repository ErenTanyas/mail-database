import java.io.IOException;

public class ElitUye extends Uye {
    ElitUye(String isim, String soyisim, String email) throws IOException {
        super(isim, soyisim, email);

        Uye.uyeEkle(this, true);
        System.out.println("Elit üye oluşturuldu!");
    }
}
