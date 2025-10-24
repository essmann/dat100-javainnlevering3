package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

    // TODO: objektvariable
    Innlegg[] innlegg;
    int nesteLedig;

    public Blogg() {
        this.innlegg = new Innlegg[20];
        this.nesteLedig = 0;
    }

    public Blogg(int lengde) {
        this.innlegg = new Innlegg[lengde];
        this.nesteLedig = 0;
    }

    public int getAntall() {
        return this.nesteLedig;
    }

    public Innlegg[] getSamling() {
        return this.innlegg;

    }

    public int finnInnlegg(Innlegg innlegg) {
        int index = 0;
        for (Innlegg x : this.innlegg) {

            if (x != null && x.erLik(innlegg)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;

    }

    public boolean ledigPlass() {
        return nesteLedig < this.innlegg.length;

    }

    public boolean leggTil(Innlegg innlegg) {
        if (!finnes(innlegg)) {
            this.innlegg[nesteLedig] = innlegg;
            nesteLedig++;
            return true;
        }
        return false;
    }

    public String toString() {
        int antall = getAntall();
        String string = antall + "\n";
        for (Innlegg innlegg : getSamling()) {
            if (innlegg != null) {
                string += innlegg.toString();
            }
        }
        return string;
    }

    // valgfrie oppgaver nedenfor

    public void utvid() {
        Innlegg[] gammel = this.innlegg;
        this.nesteLedig = 0;
        Innlegg[] ny = new Innlegg[gammel.length * 2];
        for (int i = 0; i < gammel.length; i++) {
            ny[i] = gammel[i];
            nesteLedig++;
        }
        this.innlegg = ny;

    }

    public boolean leggTilUtvid(Innlegg innlegg) {

        throw new UnsupportedOperationException(TODO.method());

    }

    public boolean slett(Innlegg innlegg) {
        int target_index = finnInnlegg(innlegg);
        if (target_index != -1) {
            // shift all elements after target_index one position to the left
            for (int i = target_index; i < nesteLedig - 1; i++) {
                this.innlegg[i] = this.innlegg[i + 1];
            }
            // remove duplicate last element
            this.innlegg[nesteLedig - 1] = null;
            nesteLedig--;
            return true;
        }
        return false;
    }

    public int[] search(String keyword) {

        throw new UnsupportedOperationException(TODO.method());

    }
}