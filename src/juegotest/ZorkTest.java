package juegotest;

import source.Partida;
import source.Place;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import source.CargaAventura;
import source.Item;
import source.Location;
import source.AventuraZork;

public class ZorkTest {

	@Test
	public void getCharacterName() throws IOException {

		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);

		assertEquals("Guybrush Threepwood", juego.getSettings().getCharacter());

	}

	@Test
	public void getWelcome() throws IOException {

		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		assertEquals(
				"Te encuentras en un muelle. Es de noche pero la luna ilumina todo el lugar. En el suelo hay algunos objetos, y sientes muchas ganas de ir hacia una taberna.",
				juego.getSettings().getWelcome());
	}

	@Test
	public void getLocationDescription() throws IOException {

		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		assertEquals("Estas en un muelle", juego.getLocations().get(0).getDescription());
	}

	@Test
	public void getLocationDescriptionNext() throws IOException {
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		assertEquals("Estas en una sucia taberna", juego.getLocations().get(1).getDescription());
	}

	@Test
	public void mirarAlrededor() throws IOException {
        System.out.println("mirar alrededor");
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		System.out.println(juego.verAlrededor("muelle"));

	}

	@Test
	public void getNPCSTalk1() throws IOException {
		System.out.println("getNPCSTalk1");
		String path = "Juego.json";
		Partida partida = new Partida(path);

	}
	
	@Test
	public void verInventario1() throws IOException{
		System.out.println("verInventario1");
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		juego.agregarItemInventario("barreta");
		juego.agregarItemInventario("rociador con cerveza de raiz");
		juego.agregarItemInventario("espejo");
		System.out.println(juego.verInventario());
	}
	
	@Test
     public void pruebaQuitarItemDePlace() throws IOException{
		
		System.out.println("test quitar item de place");
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		System.out.println(juego.verAlrededor("muelle"));
        juego.getLocations().get(0).getPlaces().get(0).quitarItemDeArray("barreta");     
		System.out.println(juego.verAlrededor("muelle"));

	}
	
	
	@Test
	 public void tomaItemYloAgregaAlInventario() throws IOException {
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		juego.agregarItemInventario("rociador con cerveza de raiz");
		juego.agregarItemInventario("espejo");
		System.out.println(juego.verInventario());
	    juego.tomarItem("muelle", "suelo", "barreta");
	    System.out.println(juego.verInventario());
	    System.out.println(juego.verAlrededor("muelle"));

	}
	
	@Test
	public void seFijaSinoEncuentraEseItem() throws IOException {
		String path = "Juego.json";
		AventuraZork juego = CargaAventura.cargarArchivo(path);
		juego.tomarItem("muelle", "suelo", "escopeta");
	}

}