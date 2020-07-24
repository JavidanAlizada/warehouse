 
package anbar;

 
public class AnaMenyuBean {
    
    
    private String ad;
    private String kod;
    private int yeshik_sayi;
    private int say;
    private String reng;
    private String olcu;
    private String istehsalciFirma;
    private double anbarQiymeti;
    private double satishQiymeti;

    public AnaMenyuBean(String ad, String kod, int yeshik_sayi, int say, String reng, String olcu, String istehsalciFirma, double anbarQiymeti, double satishQiymeti) {
        this.ad = ad;
        this.kod = kod;
        this.yeshik_sayi = yeshik_sayi;
        this.say = say;
        this.reng = reng;
        this.olcu = olcu;
        this.istehsalciFirma = istehsalciFirma;
        this.anbarQiymeti = anbarQiymeti;
        this.satishQiymeti = satishQiymeti;
    }

    public String getAd() {
        return ad;
    }

    public String getKod() {
        return kod;
    }

    public int getYeshik_sayi() {
        return yeshik_sayi;
    }

    public int getSay() {
        return say;
    }

    public String getReng() {
        return reng;
    }

    public String getOlcu() {
        return olcu;
    }

    public String getIstehsalciFirma() {
        return istehsalciFirma;
    }

    public double getAnbarQiymeti() {
        return anbarQiymeti;
    }

    public double getSatishQiymeti() {
        return satishQiymeti;
    }

   
            
}
