package sellFan.utils;

import javax.servlet.http.HttpServletRequest;

public class URLUtils {
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
