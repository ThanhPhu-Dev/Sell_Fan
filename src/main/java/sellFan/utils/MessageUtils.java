package sellFan.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class MessageUtils {

    public static void setMessageToAttribute(HttpServletRequest req){
        try {
            ResourceBundle mybundle = ResourceBundle.getBundle("message");
            if(req.getParameter("message") != null) {
                String value = mybundle.getString(req.getParameter("message"));
                req.setAttribute("message", new String(value.getBytes("ISO-8859-1"), "UTF-8"));
            }
        }catch (UnsupportedEncodingException e){
            return;
        }

    }
}
