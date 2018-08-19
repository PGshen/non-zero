package space.zero.common.mail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 8/19/18
 * TIME: 11:18 AM
 */
public class MailEntity implements Serializable {
//    邮件服务器
    private String smtpService;
//    邮件服务器端口
    private String smtpPort;
//    发送邮箱
    private String mailAddress;
//    发送邮箱密码
    private String mailStmpPassword;
//    邮件标题
    private String title;
//    邮件内容
    private String content;
//    邮件类型
    private String contentType;
//    收件邮箱列表
    private List<String> targetMailAddress = new ArrayList<>();

    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailStmpPassword() {
        return mailStmpPassword;
    }

    public void setMailStmpPassword(String mailStmpPassword) {
        this.mailStmpPassword = mailStmpPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> gettargetMailAddress() {
        return targetMailAddress;
    }

    public void settargetMailAddress(List<String> targetMailAddress) {
        this.targetMailAddress = targetMailAddress;
    }
}
