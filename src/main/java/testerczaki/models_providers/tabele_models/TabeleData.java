package testerczaki.models_providers.tabele_models;

public class TabeleData {

    private final String imie;
    private final int wiek;
    private final String miasto;

    // -----------
    // CONSTRUCTOR
    // -----------

    public TabeleData(String imie, int wiek, String miasto) {
        this.imie = imie;
        this.wiek = wiek;
        this.miasto = miasto;
    }

    // -------
    // GETTERS
    // -------

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public String getMiasto() {
        return miasto;
    }
}
