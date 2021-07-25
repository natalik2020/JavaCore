package lesson3;

import java.lang.reflect.Array;

import static java.lang.Math.abs;

public class Box<KakojtoFrukt extends Fruit> {
    KakojtoFrukt[] frukts;

    public Box(KakojtoFrukt... frukts) {
        this.frukts = frukts;
    }

    public double getWeight() {
        double summ = 0;
        for (int i = 0; i < frukts.length; i++) {
            summ = summ + frukts[i].vesFrukta();
        }
        return summ;
    }

    boolean compare(Box korobka) {
        double ves2 = korobka.getWeight();
        double ves1 = this.getWeight();
        double raznica = abs(ves1 - ves2);

        if (raznica < 0.01) {
            return true;
        } else {
            return false;
        }
    }

    public void peresypatV(Box<KakojtoFrukt> jashik) {
        for (int i = 0; i < this.frukts.length; i++) {
            KakojtoFrukt frukt = frukts[i];
            jashik.dobavit(frukt);
        }
        opustoshit();
    }

    private void dobavit(KakojtoFrukt frukt) {
        KakojtoFrukt[] newFrukts = (KakojtoFrukt[]) Array.newInstance(frukt.vidFrukta(), this.frukts.length + 1);
        for (int i = 0; i < this.frukts.length; i++) {
            newFrukts[i] = this.frukts[i];
        }
        this.frukts = newFrukts;
        this.frukts[this.frukts.length - 1] = frukt;
    }

    private void opustoshit() {
        if (this.frukts.length == 0) {
            return;
        }
        KakojtoFrukt fruit = this.frukts[0];
        this.frukts = (KakojtoFrukt[]) Array.newInstance(fruit.vidFrukta(), 0);
    }
}
