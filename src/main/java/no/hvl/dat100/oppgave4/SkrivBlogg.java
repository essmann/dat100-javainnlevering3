package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        String filePath = mappe + filnavn;
        System.out.println(filePath);
        FileWriter writer;
        try{
            writer = new FileWriter(filePath);
            writer.append(samling.toString());
            writer.flush();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
	}
}
