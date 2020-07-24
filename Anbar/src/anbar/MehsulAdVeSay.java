
package anbar;

public class MehsulAdVeSay {

private String name;
private int say;

    public MehsulAdVeSay(String name, int say) {
        this.name = name;
        this.say = say;
    }

    public String getName() {
        return name;
    }

    public int getSay() {
        return say;
    }

    @Override
    public String toString() {
        return "MehsulAdVeSay{" + "name=" + name + ", say=" + say + '}';
    }


    
    
}
