 
package anbar;

 
public class Mehsullar_Bean {
    
    private String ad;
    private String kod;
    private int yeshik_say;
    private int say;
    private double anbar_qiymet;
    private double satish_qiymet;

    public Mehsullar_Bean(String ad, String kod, int yeshik_say, int say, double anbar_qiymet, double satish_qiymet) {
        this.ad = ad;
        this.kod = kod;
        this.yeshik_say = yeshik_say;
        this.say = say;
        this.anbar_qiymet = anbar_qiymet;
        this.satish_qiymet = satish_qiymet;
    }

    public String getAd() {
        return ad;
    }

    public String getKod() {
        return kod;
    }

    public int getYeshik_say() {
        return yeshik_say;
    }

    public int getSay() {
        return say;
    }

    public double getAnbar_qiymet() {
        return anbar_qiymet;
    }

    public double getSatish_qiymet() {
        return satish_qiymet;
    }

   
   
    
}
