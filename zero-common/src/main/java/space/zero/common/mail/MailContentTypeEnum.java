package space.zero.common.mail;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 8/19/18
 * TIME: 11:26 AM
 */
public enum  MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String type;

    MailContentTypeEnum(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
