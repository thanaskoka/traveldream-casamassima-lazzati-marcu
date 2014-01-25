package webTravel;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Emailer
{
final String senderEmailID = "traveldreamsviaggi@gmail.com";
final String senderPassword = "WebTravelDreams";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";

String receiverEmailID = null;
String emailSubject = null;
String emailBody = null;

public Emailer(String receiverEmailID, String emailSubject, String emailBody)
{
this.receiverEmailID=receiverEmailID;
this.emailSubject=emailSubject;
this.emailBody=emailBody;


Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");
// props.put("mail.smtp.debug", "true");
props.put("mail.smtp.socketFactory.port", emailServerPort);
props.put("mail.smtp.socketFactory.class",
"javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");

SecurityManager security = System.getSecurityManager();

try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
// session.setDebug(true);

MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO,
new InternetAddress(receiverEmailID));
Transport.send(msg);
}
catch (Exception mex)
{
mex.printStackTrace();
}


}
public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}

public static void main(String[] args)
{

Emailer mailSender=new Emailer("nicola1591@libero.it","SUCA","TI STO INVIANDO LA MAIL DI PROVA DA TRAVELDREAMS");
}

}