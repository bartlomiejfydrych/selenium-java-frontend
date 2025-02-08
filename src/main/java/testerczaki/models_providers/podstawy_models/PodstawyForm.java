package testerczaki.models_providers.podstawy_models;

public class PodstawyForm {

    private final String imie;
    private final String nazwisko;
    private final String email;
    private final String miasto;
    private final String ulica;

    // -----------
    // CONSTRUCTOR
    // -----------

    private PodstawyForm(PodstawyFormBuilder builder) {
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

    public static class PodstawyFormBuilder {

        private String imie;
        private String nazwisko;
        private String email;
        private String miasto;
        private String ulica;

        public PodstawyFormBuilder imie(String imie) {
            this.imie = imie;
            return this;
        }

        public PodstawyFormBuilder nazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public PodstawyFormBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PodstawyFormBuilder miasto(String miasto) {
            this.miasto = miasto;
            return this;
        }

        public PodstawyFormBuilder ulica(String ulica) {
            this.ulica = ulica;
            return this;
        }

        public PodstawyForm build() {
            return new PodstawyForm(this);
        }
    }
}
