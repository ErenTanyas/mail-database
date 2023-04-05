import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EPostaci {
    private final String[] alicilar;
    private final String gmailAdresi;
    private final String uygSifresi;

    public EPostaci(String gmailAdresi, String uygSifresi, String[] alicilar) {
        this.gmailAdresi = gmailAdresi;
        this.uygSifresi = uygSifresi;
        this.alicilar = alicilar;
    }

    public void mailGonder(String baslik, String yazi) {
        System.out.println("Mailler gönderliyor, lütfen bekleyiniz...");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(gmailAdresi, uygSifresi);
                    }
                });

        try {
            for (String recipient : alicilar) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(gmailAdresi));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(recipient));
                message.setSubject(baslik);
                message.setText(yazi);

                Transport.send(message);
            }
            System.out.println("Mailler gönderildi!");
        } catch (MessagingException e) {
            System.out.println("Mail gönderirken hata oluştu: " + e.getMessage());
        }
    }
}
