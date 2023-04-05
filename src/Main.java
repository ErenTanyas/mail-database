import java.io.*;
import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    // scanner'ı main metodu ve diğer metotlarda kullanmak için

    public static void main(String[] args) throws IOException {
        int islem, islemMail;
        String[] mailler;
        boolean cikis = false;

        while (!cikis) {
            System.out.println("1- Elit üye ekleme");
            System.out.println("2- Genel üye ekleme");
            System.out.println("3- Mail gönderme");
            System.out.println("4- Çıkış");
            System.out.print("\nİşlem giriniz: ");

            islem = scanner.nextInt();
            scanner.nextLine(); //bir sonraki nextLine düzgün çalışsın diye temizlik

            switch (islem) {
                case 1:
                    uyeOlustur("elit");
                    break;
                case 2:
                    uyeOlustur("genel");
                    break;
                case 3:
                    System.out.println("1- Elit üyelere mail");
                    System.out.println("2- Genel üyelere mail");
                    System.out.println("3- Tüm üyelere mail");
                    System.out.println("4- Geri dön");
                    System.out.print("\nİşlem giriniz: ");

                    islemMail = scanner.nextInt();
                    scanner.nextLine();

                    if (islemMail == 1 || islemMail == 2 || islemMail == 3) {
                        mailler = Dosya.mailAl(islemMail);
                        topluMailGonder(mailler);
                    }
                    else if (islemMail == 4) {
                        System.out.println("Geri dönülüyor...");
                    }
                    else {
                        System.out.println("Yanlış girdi girildi! Geri dönülüyor...");
                    }

                    break;

                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    cikis = true;
                    break;

                default:
                    System.out.println("Yanlış girdi girildi!");
            }
        }
    }

    public static void uyeOlustur(String type) throws IOException {
        System.out.print("Kullanıcı ismi: ");
        String isim = scanner.nextLine();

        System.out.print("Kullanıcı soyismi: ");
        String soyisim = scanner.nextLine();

        System.out.print("Kullanıcı emaili: ");
        String email = scanner.nextLine();

        if(type.equals("elit")) {
            new ElitUye(isim, soyisim, email);
            // oluşturulan üye nesnesinin değişkenlere atanmasına gerek yok
        }
        else {
            new GenelUye(isim, soyisim, email);
        }
    }

    public static void topluMailGonder(String[] mailler) {
        System.out.print("Kullanacağınız mail adresi: ");
        String kullaniciMail = scanner.nextLine();

        System.out.print("Uygulama şifresi: ");
        String kullaniciSifre = scanner.nextLine();

        System.out.print("Mail başlığı: ");
        String mailBaslik = scanner.nextLine();

        System.out.println("Maile yazılacak yazı: ");
        String mailYazi = scanner.nextLine();

        EPostaci ePostaci = new EPostaci(kullaniciMail, kullaniciSifre, mailler);
        ePostaci.mailGonder(mailBaslik, mailYazi);
    }
}