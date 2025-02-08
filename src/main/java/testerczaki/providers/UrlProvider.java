package testerczaki.providers;

import testerczaki.configuration.Config;

public class UrlProvider {

    private static final String BASE_URL = Config.getAppUrl();

    public static String getHomePageUrl() {
        return BASE_URL;
    }

    // Examples of building other URLs:

    public static String getPodstawyPageUrl() {
        return BASE_URL + "/podstawy";
    }
}
