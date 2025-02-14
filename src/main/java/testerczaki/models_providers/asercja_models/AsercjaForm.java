package testerczaki.models_providers.asercja_models;

public class AsercjaForm {

    private final String imie;
    private final String nazwisko;
    private final String email;
    private final String miasto;
    private final String ulica;

    // -----------
    // CONSTRUCTOR
    // -----------

    private AsercjaForm(AsercjaForm.AsercjaFormBuilder builder) {
        this.imie = builder.imie;
        this.nazwisko = builder.nazwisko;
        this.email = builder.email;
        this.miasto = builder.miasto;
        this.ulica = builder.ulica;
    }

    // -------
    // GETTERS
    // -------

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    // -------
    // BUILDER
    // -------

    public static class AsercjaFormBuilder {

        private String imie;
        private String nazwisko;
        private String email;
        private String miasto;
        private String ulica;

        public AsercjaForm.AsercjaFormBuilder imie(String imie) {
            this.imie = imie;
            return this;
        }

        public AsercjaForm.AsercjaFormBuilder nazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public AsercjaForm.AsercjaFormBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AsercjaForm.AsercjaFormBuilder miasto(String miasto) {
            this.miasto = miasto;
            return this;
        }

        public AsercjaForm.AsercjaFormBuilder ulica(String ulica) {
            this.ulica = ulica;
            return this;
        }

        public AsercjaForm build() {
            return new AsercjaForm(this);
        }
    }
}
