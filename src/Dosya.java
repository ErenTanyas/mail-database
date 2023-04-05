import java.io.*;

public class Dosya {
    public static void dosyaHazirla() throws IOException {
        File file = new File("kullanicilar.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Kullanıcılar dosyası oluşturuldu!");
        }
        String icerik = icerikAl(file);

        if (icerik.trim().isEmpty()) {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("ELİT ÜYELER\n\nGENEL ÜYELER\n");
            writer.close();
        }
    }
    public static String icerikAl(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String satir;
        String icerik = "";
        while ((satir = reader.readLine()) != null) {
            icerik += satir + "\n";
        }
        reader.close();
        return icerik;
    }
    public static void dosyaGuncelle(Uye uye, boolean elit) throws IOException {
        dosyaHazirla();
        File file = new File("kullanicilar.txt");
        File file2 = new File("temp.txt");

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        FileWriter fw = new FileWriter(file2, false);
        BufferedWriter writer = new BufferedWriter(fw);

        String satir;
        while ((satir = reader.readLine()) != null) {
            writer.write(satir + "\n");
            if (elit && satir.equals("ELİT ÜYELER")) {
                writer.write(uye.isim+"\t"+uye.soyisim+"\t"+uye.email+"\n");
            }
            else if (!elit && satir.equals("GENEL ÜYELER")) {
                writer.write(uye.isim+"\t"+uye.soyisim+"\t"+uye.email+"\n");
            }
        }
        file2.renameTo(file);
        writer.close();
        reader.close();
    }
    public static String[] mailAl(int yontem) throws IOException {
        File file = new File("kullanicilar.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        int uyeSayisi = Dosya.uyeSayisiAl(yontem);
        String[] mailler = new String[uyeSayisi];

        String satir;
        String[] kullaniciBilgisi;
        boolean elitlereUlasma = false, geneleUlasma = false;
        int i = 0;
        while ((satir = reader.readLine()) != null) {
            if ((yontem == 1 || yontem == 3) && satir.equals("ELİT ÜYELER")) {
                elitlereUlasma = true;
                geneleUlasma = false;
                continue;
            }
            else if (satir.equals("")) {
                elitlereUlasma = false;
                geneleUlasma = false;
                continue;
            }
            else if ((yontem == 2 || yontem == 3) && satir.equals("GENEL ÜYELER")) {
                geneleUlasma = true;
                elitlereUlasma = false;
                continue;
            }
            if ((yontem == 1 || yontem == 3) && elitlereUlasma) {
                i++;
                kullaniciBilgisi = satir.split("\\s+");
                mailler[i - 1] = kullaniciBilgisi[2];
            }
            else if ((yontem == 2 || yontem == 3) && geneleUlasma) {
                i++;
                kullaniciBilgisi = satir.split("\\s+");
                mailler[i - 1] = kullaniciBilgisi[2];
            }
        }

        return mailler;
    }
    public static int uyeSayisiAl(int yontem) throws IOException {
        File file = new File("kullanicilar.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String satir;
        int uyeSayisi=0;
        boolean elitlereUlasma = false, geneleUlasma=false;
        while((satir=reader.readLine())!=null) {
            if(satir.equals("ELİT ÜYELER")){
                elitlereUlasma = true;
                geneleUlasma = false;
                continue;
            }
            else if(satir.equals("")) {
                continue;
            }
            else if(satir.equals("GENEL ÜYELER")){
                geneleUlasma = true;
                elitlereUlasma = false;
                continue;
            }
            if((yontem==1 || yontem==3) && elitlereUlasma) {
                uyeSayisi++;
            }
            else if((yontem==2 || yontem==3) && geneleUlasma){
                uyeSayisi++;
            }
        }
        reader.close();
        return uyeSayisi;
    }
}
