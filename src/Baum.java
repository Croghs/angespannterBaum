import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baum {

    public static void main(String[] arsg){
        Baum baum = new Baum();
    }

    public Baum(){
        Vertices a = new Vertices("a");
        Vertices b = new Vertices("b");
        Vertices c = new Vertices("c");
        Vertices d = new Vertices("d");
        Vertices e = new Vertices("e");
        Vertices f = new Vertices("f");
        Vertices g = new Vertices("g");
        Kanten k1 = new Kanten(a,f,5);
        Kanten k2 = new Kanten(a,b,8);
        Kanten k3 = new Kanten(b,f,2);
        Kanten k4 = new Kanten(b,g,3);
        Kanten k5 = new Kanten(f,g,6);
        Kanten k6 = new Kanten(e,f,1);
        Kanten k7 = new Kanten(e,g,3);
        Kanten k8 = new Kanten(e,d,4);
        Kanten k9 = new Kanten(d,g,5);
        Kanten k10 = new Kanten(d,c,4);
        Kanten k11 = new Kanten(g,c,2);
        Kanten k12 = new Kanten(b,c,3);

        ArrayList<Kanten> kantenListe = new ArrayList();
        kantenListe.add(k1);
        kantenListe.add(k2);
        kantenListe.add(k3);
        kantenListe.add(k4);
        kantenListe.add(k5);
        kantenListe.add(k6);
        kantenListe.add(k7);
        kantenListe.add(k8);
        kantenListe.add(k9);
        kantenListe.add(k10);
        kantenListe.add(k11);
        kantenListe.add(k12);
        ArrayList<Kanten> fertig = kruskal(kantenListe);
        output(fertig);
    }

    public ArrayList<Kanten> kruskal(ArrayList<Kanten> liste){
        int numberOfKanten = 0;
        Collections.sort(liste);
        ArrayList<Kanten> minBaum = new ArrayList();
        ArrayList<Vertices> besucht = new ArrayList<>();
        for (Kanten check : liste) {
            Vertices v1 = check.getA();
            Vertices v2 = check.getB();
            if(!(besucht.contains(v1)) && !(besucht.contains(v2))){
                besucht.add(v1);
                besucht.add(v2);
                minBaum.add(check);
                numberOfKanten++;
            } else if (!(besucht.contains(v1)) && (besucht.contains(v2))){
                besucht.add(v1);
                minBaum.add(check);
                numberOfKanten++;
            } else if((besucht.contains(v1)) && !besucht.contains(v2)){
                besucht.add(v2);
                minBaum.add(check);
                numberOfKanten++;
            } else if(numberOfKanten <= besucht.size() - 1){

                minBaum.add(check);
                numberOfKanten++;
            }
        }
        return minBaum;
    }
    public void output(ArrayList<Kanten> e){
        for(Kanten k : e){
            System.out.println(k.getA().getName() + " - " + k.getWert() + " - " + k.getB().getName());
        }
    }

}