package space.zero.common.mail;

import space.zero.common.utils.PropertiesUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 8/19/18
 * TIME: 11:24 AM
 */
public class MailSender {
    private static MailEntity mail = new MailEntity();

    public MailSender title(String title) {
        mail.setTitle(title);
        return this;
    }

    public MailSender content(String content) {
        mail.setContent(content);
        return this;
    }

    public MailSender contentType(MailContentTypeEnum type) {
        mail.setContentType(type.getType());
        return this;
    }

    public void sender() throws Exception {
        if (mail.getContentType() == null) {
            mail.setContentType(MailContentTypeEnum.HTML.getType());
        }

        if (mail.getTitle() == null || mail.getTitle().length() == 0) {
            throw new Exception("Mail's title is empty!");
        }

        if (mail.getContent() == null || mail.getContent().length() == 0) {
            throw new Exception("Mail's content is empty!");
        }

        final PropertiesUtils propertiesUtils = new PropertiesUtils("mail");
        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", propertiesUtils.getValue("mail.smtp.service"));
//        properties.put("mail.smtp.port", propertiesUtils.getValue("mail.smtp.port"));
        properties.put("mail.user", propertiesUtils.getValue("mail.address"));
        properties.put("mail.password", propertiesUtils.getValue("mail.password"));

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = properties.getProperty("mail.user");
                String password = properties.getProperty("mail.password");
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(properties, authenticator);
        MimeMessage message = new MimeMessage(session);
        String nickName = MimeUtility.encodeText(propertiesUtils.getValue("mail.nickName"));
        InternetAddress from = new InternetAddress(nickName + "<" + properties.getProperty("mail.user") + ">");
        message.setFrom(from);
        message.setSubject(mail.getTitle());
        if (mail.getContentType().equals(MailContentTypeEnum.HTML.getType())){
            message.setContent(mail.getContent(), mail.getContentType());
        }else if (mail.getContentType().equals(MailContentTypeEnum.TEXT.getType())){
            message.setContent(mail.getContent(), mail.getContentType());
        }

        String target = propertiesUtils.getValue("mail.target.address");
        List<String> targetAddress = Arrays.asList(target.split(","));
        if (targetAddress.size() == 0) {
            throw new Exception("Mail's target mail address is empty!");
        }

        for (int i = 0; i < targetAddress.size(); i++){
            try {
                InternetAddress to = new InternetAddress(targetAddress.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                Transport.send(message);
                System.out.println("mail send successful" + message.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws Exception{
        new MailSender().title("Java Mail 中文测试")
                .content("Java Mail 中文测试")
                .contentType(MailContentTypeEnum.HTML)
                .sender();
    }
}
