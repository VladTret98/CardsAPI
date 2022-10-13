package by.tretyak.logBook.exception.source;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExceptionMessageSource {

    private static final String PATH = "/messagesource.properties";

    public static final String SERVER_ERROR = "exception.message.server.error";
    public static final String BAD_REQUEST = "exception.message.bad.request";
    public static final String DATA_NOT_FOUND = "warning.message.data.not.found";

    private static final String CRITICAL_SERVER_ERROR = "Критическая ошибка сервера";

    public static Properties properties;

    public static String getMessage(String key) {
        if (properties == null) {
            try(InputStream is = ExceptionMessageSource.class.getResourceAsStream(PATH)) {
                properties = new Properties();
                properties.load(is);
            } catch (IOException e) {
                return CRITICAL_SERVER_ERROR;
            }
        }
        return properties.getProperty(key);
    }

}
