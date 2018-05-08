public class Kanten implements Comparable<Kanten> {

    Vertices a, b;
    int wert;

    public Kanten(Vertices k1, Vertices k2, int wert1){
        a = k1;
        b = k2;
        wert = wert1;
    }

    public Vertices getA() {
        return a;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public void setA(Vertices a) {
        this.a = a;
    }

    public Vertices getB() {
        return b;
    }

    public void setB(Vertices b) {
        this.b = b;
    }

    @Override
    public int compareTo(Kanten o) {
        Kanten e1 = (Kanten)o;
        if(e1.wert==this.wert)
            return 0;
        return e1.wert < this.wert ? 1 : -1;

    }
}
