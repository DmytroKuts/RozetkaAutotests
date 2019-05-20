package Actions;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail {
    private String username;
    private String password;
    private Properties props;

    public SendMail(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public void send(String subject, String text, String fromEmail, String toEmail, String filepath){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Multipart mmp = new MimeMultipart();
            MimeMessage message = new MimeMessage(session);
            // From
            message.setFrom(new InternetAddress(fromEmail));
            //To
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //Subject
            message.setSubject(subject);
            //Texr
            message.setText(text);
            // Attachment
            MimeBodyPart mbr = createFileAttachment(filepath);
            mmp.addBodyPart(mbr);
            message.setContent(mmp);

            //Send email
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    private MimeBodyPart createFileAttachment(String filepath)
            throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();
        // File content
        FileDataSource fds = new FileDataSource(filepath);
        mbp.setDataHandler(new DataHandler(fds));
        mbp.setFileName(fds.getName());
        return mbp;
    }
}


