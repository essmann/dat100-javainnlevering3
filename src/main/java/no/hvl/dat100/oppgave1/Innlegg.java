package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

import java.util.Date;

public abstract class Innlegg {
	
    //a)

	protected int id = 2;
    protected String bruker;
    protected String dato;
    protected int likes;

	public Innlegg() {
		
	}
	//b)
	public Innlegg(int id, String bruker, String dato) {

		// TODO 
		this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
	}
	
	public String getBruker() {
		
        return this.bruker;
	}

	public void setBruker(String bruker) {

        this.bruker = bruker;
	}

	public String getDato() {

        return this.dato;
	}

	public void setDato(String dato) {

        this.dato = dato;
	}

	public int getId() {
		return this.id;

	}

    public void setId(int id){
        this.id = id;
    }
	public int getLikes() {
		return this.likes;

	}
    public void setLikes(int likes){
        this.likes = likes;
    }
	
	public void doLike () {

        setLikes(getLikes()+1);
	}
	
	public boolean erLik(Innlegg innlegg) {
		return innlegg.id == this.id;

	}
	
	@Override
	public String toString() {
		
		return id + "\n"+bruker +"\n"+dato+"\n" +likes+"\n";
				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
