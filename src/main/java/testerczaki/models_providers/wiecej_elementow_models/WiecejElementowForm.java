package testerczaki.models_providers.wiecej_elementow_models;

import java.util.List;

public class WiecejElementowForm {

    private final String imie;
    private final String nazwisko;
    private final String kraj;
    private final List<String> jezykProgramowania;
    private final String oSobie;
    private final String plec;

    // -----------
    // CONSTRUCTOR
    // -----------

    private WiecejElementowForm(WiecejElementowBuilder builder) {
        this.imie = builder.imie;
        this.nazwisko = builder.nazwisko;
        this.kraj = builder.kraj;
        this.jezykProgramowania = builder.jezykProgramowania;
        this.oSobie = builder.oSobie;
        this.plec = builder.plec;
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

    public String getKraj() {
        return kraj;
    }

    public List<String> getJezykProgramowania() {
        return jezykProgramowania;
    }

    public String getoSobie() {
        return oSobie;
    }

    public String getPlec() {
        return plec;
    }

    // -------
    // BUILDER
    // -------

    public static class WiecejElementowBuilder {

        private String imie;
        private String nazwisko;
        private String kraj;
        private List<String> jezykProgramowania;
        private String oSobie;
        private String plec;

        public WiecejElementowBuilder imie(String imie) {
            this.imie = imie;
            return this;
        }

        public WiecejElementowBuilder nazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public WiecejElementowBuilder kraj(String kraj) {
            this.kraj = kraj;
            return this;
        }

        public WiecejElementowBuilder jezykProgramowania(List<String> jezykProgramowania) {
            this.jezykProgramowania = jezykProgramowania;
            return this;
        }

        public WiecejElementowBuilder oSobie(String oSobie) {
            this.oSobie = oSobie;
            return this;
        }

        public WiecejElementowBuilder plec(String plec) {
            this.plec = plec;
            return this;
        }

        public WiecejElementowForm build() {
            return new WiecejElementowForm(this);
        }
    }
}
