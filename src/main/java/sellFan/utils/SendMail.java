package sellFan.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class SendMail {

    public static void sendMailTo(String email, String subject, String message) throws MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sv18600207@gmail.com", "thanhphu4422");
            }
        };
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("sv18600207@gmail.com"));
        InternetAddress[] toAddresses = { new InternetAddress(email) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setContent(message, "text/html; charset=UTF-8");

        Transport.send(msg);
    }

    public static String formMailForgetPassword(HttpServletRequest req, Integer id, String code){

        return "<p>Xin chào cảm ơn bạn đã đăng ký vào website của chúng tôi</p>"
                +"<p><a href=\""+URLUtils.getSiteURL(req)+"/auth/fogetPassword/?&id="+id+"&code="+code+"\">Nhấp Vào Đây để xác nhận</a></p>";
    }

    public static String formMailRegister(HttpServletRequest req, Integer id, String code){

        return "<p>Xin chào, cảm ơn bạn đã đăng ký vào website của chúng tôi</p>"
                +"<p><a href=\""+URLUtils.getSiteURL(req)+"/auth\">Nhấp Vào Đây Vào trang đăng nhập</a></p>";
    }
}
