package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;
import javax.swing.text.Keymap;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    private static Object dictToClass(List<String> list) {
        int id = Integer.parseInt(list.get(1));
        String brukernavn = list.get(2);
        String dato = list.get(3);
        int likes = Integer.parseInt(list.get(4));
        String tekst = list.get(5);
        if (list.get(0).equals(BILDE)) {
            String url = list.get(6);
            return new Bilde(id, brukernavn, dato, likes, tekst, url);
        }
        return new Tekst(id, brukernavn, dato, likes, tekst);


    }

    public static Blogg les(String mappe, String filnavn) {
        String filePath = mappe + filnavn;
        File file = new File(filePath);
        Blogg blogg = null;

        //
        List<String> list = new ArrayList<>();



        try (Scanner reader = new Scanner(file)) {
            //Finn lengden på blogg.
            int antall = Integer.parseInt(reader.nextLine());
            blogg = new Blogg(antall);



            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals(TEKST) || data.equals(BILDE)) {
                    if (!list.isEmpty()) {
                        //method call
                        blogg.leggTil((Innlegg) dictToClass(list));
                        list.clear();
                    }


                }
                list.add(data);


            }
            if (!list.isEmpty()) {
                blogg.leggTil((Innlegg) dictToClass(list));
            }
        } catch (Exception e) {
        }
        return blogg;
    }

}
