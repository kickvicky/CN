import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

class MailSending{
    public static void send(String fromMailId,String pass,String toMailId,String msgSubject,String msg){
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.port", "465");
        pro.put("mail.smtp.socketFactory.port", "465");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(pro,new 
             Authenticator()
               {  protected PasswordAuthentication getPasswordAuthentication()
                {
                return new PasswordAuthentication(fromMailId, pass);
               }});
        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMailId));
            message.setSubject(msgSubject);
            message.setText(msg);
            Transport.send(message);
            System.out.println("\n----------------------------\n\nMail Sent Successfully!!");
        }
        catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
}

public class smtp{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        String fromMailId,toMailId,pass,msgSubject,msg;
        System.out.println("-------------------------------------");
        System.out.println("\tSimple Mail Transfer Protocol");
        System.out.println("-------------------------------------\n");
        System.out.print("Enter From Mail Id : ");
        fromMailId = s.nextLine();
        System.out.print("Enter Password : ");
        pass = s.nextLine();
        System.out.print("Enter To Mail Id : ");
        toMailId = s.nextLine();
        System.out.print("Enter Mail Subject : ");
        msgSubject = s.nextLine();
        System.out.print("Enter Message to be sent : ");
        msg = s.nextLine();
        MailSending.send(fromMailId, pass, toMailId, msgSubject, msg);
        s.close();
    }
}