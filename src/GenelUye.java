import java.io.IOException;

public class GenelUye extends Uye {
    GenelUye(String isim, String soyisim, String email) throws IOException {
        super(isim, soyisim, email);

        Uye.uyeEkle(this, false);
        System.out.println("Genel üye oluşturuldu!");
    }
}
