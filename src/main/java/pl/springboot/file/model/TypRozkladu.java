package pl.springboot.file.model;

public enum  TypRozkladu{

    POWSZEDNI_SZKOLNY("Powszedni szkolny"),
    SOBOTA("Sobota"),
    NIEDZIELA("Niedziela"),
    POWSZEDNI_FERIE("Powszedni ferie"),
    POWSZDNI_WAKACJE("Powszedni wakacje"),
    SPECJALNY("Specjalny");



        private final String dispayValue;

    TypRozkladu(String dispayValue) {
        this.dispayValue = dispayValue;
    }

    public String getDispayValue() {
        return dispayValue;
    }
}
