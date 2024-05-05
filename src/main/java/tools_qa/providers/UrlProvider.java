package tools_qa.providers;

import tools_qa.configuration.Config;

public class UrlProvider {
    private static String baseUrl = Config.getAppUrl();
    public static String homePage = baseUrl;
    // Przykłady budowania innych URLi:
    public static String elementsUrl = baseUrl + "/elements";
}
