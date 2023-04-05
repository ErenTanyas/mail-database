# Proje Özeti
Bu projenin amacı isim, soyisim ve email bilgilerine ve rütbelere sahip kullanıcıların bilgilerini bir dosyada tutan ve bu kullanıcı gruplarına topluca 
mail atabilme fonksiyonuna sahip bir veritabanı simüle etmektir. Bilgiler üzerindeki işlemler dosya işlemleriyle gerçekleşir.

# Gereksinimler
- Mail göndermede kullanacağınız gmail hesabınızın 2 adımlı doğrulaması olması
- Mail göndermede kullanacağınız gmail hesabınızın bir Uygulama Şifresine sahip olması

# Kullanıcı Arayüzü

## Ana Menü
Ana menüde kullanıcıyı 4 ana seçenek bekler: Veritabanınına elit üye ekleme, veritabanınına genel üye ekleme, mail gönderme menüsüne giriş ve 
programdan çıkış. Kullanıcı ana menüden çıkış yapmadığı sürece birden fazla işlem yapmakta özgürdür.

Kullanıcı, programda genel veya elit üye oluşturmak isterse bir üye için isim, soyisim ve email bilgisi girecektir. Elit üye ve genel üyenin arasında
bir üstünlük yoktur, iki üyenin de bilgileri aynı dosyada saklanacaktır. Sadece bu üyeler farklı başlıklar altında gruplanacaktır.

Kullanıcı bir üye oluşturduğunda, proje dizini içinde bir "kullanicilar.txt" dosyasi oluşacaktır ve dosya program aracılığıyla uygun biçimde yapılan-
dırılacaktır. Her üye eklendiğinde dosya otomatik olarak güncellenecektir. Kullanıcı programdan çıkış yapsa bile dosyadaki bilgiler kaybolmayacaktır.

## Mail Gönderme Menüsü

Kullanıcı üyeler oluşturduktan sonra üyelere mail göndermek isterse önüne bir mail gönderme menüsü çıkacaktır. Burada da 4 seçeneği olacaktır: Tüm
elit üyelere mail gönderme, Tüm genel üyelere mail gönderme, tüm üyelere mail gönderme ve ana menüye geri dönüş.

Kullanıcı tek bir kişiye mail gönderemez. Ancak bütün bir gruba toplu bir mail gönderebilir.

Kullanıcı seçtiği bir gruba mail göndermek istediğinde program onun kullanacağı gmail adresini ve gmail adresinin Uygulama Şifresini isteyecektir.
**Bu projede eğer gmail hesabınızın Uygulama Şifresi yoksa program sizin hesabınıza uzaktan bağlantı sağlayamayacak, dolayısıyla program istenildiği
gibi çalışmayacaktır.**

Kullanıcı gmail adresini ve şifresini girdiğinde birazcık beklerse mailler toplu olarak gönderilmiş olacaktır.

### Neden Uygulama Şifresi?
Çünkü Google gmail hesabınıza güvenilir olmayan uygulamaların uzaktan erişimini otomatik olarak engeller. Bu ayar Google Hesabı'nın Güvenlik bölümünde
olan "Güvenliği Düşük Uygulama Erişimi"dir. Artık o ayar tamamen kapalı durumda ve Google, hesabınıza uzaktan erişimi sağlamak için hesabınıza bir
Uygulama Şifresi oluşturmanızı istiyor. Ancak bunun için aynı zamanda hesabınızın 2 adımlı doğrulamasının da olması gerekiyor. 
Kısacası tüm bunlar Google'un yaptığı güvenlik önlemlerinin sonucudur.
