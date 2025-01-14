package tools_qa.providers;

import tools_qa.configuration.Config;

public class UrlProvider {

    private static final String BASE_URL = Config.getAppUrl();

    public static String getHomePageUrl() {
        return BASE_URL;
    }

    // Examples of building other URLs:

    public static String getLoginPageUrl() {
        return BASE_URL + "/login";
    }

    public static String getElementsPageUrl() {
        return BASE_URL + "/elements";
    }
}
