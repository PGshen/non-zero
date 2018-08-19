package space.zero.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 8/19/18
 * TIME: 11:30 AM
 */
public class PropertiesUtils {
    private final ResourceBundle resourceBundle;
    private final String fileName;

    public PropertiesUtils(String fileName){
        this.fileName = fileName;
        Locale locale = new Locale("zh", "CN");
        this.resourceBundle = ResourceBundle.getBundle(this.fileName, locale);
    }

    public String getValue(String key){
        String value = this.resourceBundle.getString(key);
        return value;
    }
}
