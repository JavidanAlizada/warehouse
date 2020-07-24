package anbar;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mehsul_ixrac_Bean {

    private int ID;
    private String ad;
    private String kod;
    private int yeshik_say;
    private int say;
    private double anbar_qiymet;
    private double satish_qiymet;
    private String tarix;

    public Mehsul_ixrac_Bean(int ID, String ad, String kod, int yeshik_say, int say, double anbar_qiymet, double satish_qiymet, String tarix) {
        this.ID = ID;
        this.ad = ad;
        this.kod = kod;
        this.yeshik_say = yeshik_say;
        this.say = say;
        this.anbar_qiymet = anbar_qiymet;
        this.satish_qiymet = satish_qiymet;
        this.tarix = tarix;
    }

    public int getID() {
        return ID;
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

    public String getTarix() {
        return tarix;
    }

  
    
}