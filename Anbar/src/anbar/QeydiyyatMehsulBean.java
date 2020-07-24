
package anbar;

import java.sql.Timestamp;


public class QeydiyyatMehsulBean {


private String kod;
private String ad;
private String olcu;
private String reng;
private String tarix;
private String firma;

    public QeydiyyatMehsulBean(String ad, String kod, String olcu, String reng, String tarix, String firma) {
        this.kod = kod;
        this.ad = ad;
        this.olcu = olcu;
        this.reng = reng;
        this.tarix = tarix;
        this.firma = firma;
    }

    public String getKod() {
        return kod;
    }

    public String getAd() {
        return ad;
    }

    public String getOlcu() {
        return olcu;
    }

    public String getReng() {
        return reng;
    }

    public String getTarix() {
        return tarix;
    }

    public String getFirma() {
        return firma;
    }



        
}
