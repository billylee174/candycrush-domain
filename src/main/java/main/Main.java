package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import mundo.*;
import objetivos.*;
import colores.*;
import dificultad.*;

public class Main {
	
	public static void main(String[] args) {
		//dulces
		Dulce rojo = new Rojo();
		Dulce verde = new Verde();
		Dulce amarillo = new Amarillo();
		Dulce violeta = new Violeta();
		Dulce celeste = new Celeste();
		Dulce naranja = new Naranja();
		
		//dificultades
		List<Dulce> dulcesFacil = new ArrayList<Dulce>();
		List<Dulce> dulcesMedio = new ArrayList<Dulce>();
		List<Dulce> dulcesDificil = new ArrayList<Dulce>();
		
		dulcesFacil.add(rojo);
		dulcesFacil.add(verde);
		dulcesFacil.add(amarillo);
		dulcesFacil.add(violeta);
		
		dulcesMedio.addAll(dulcesFacil);
		dulcesMedio.add(celeste);
		
		dulcesDificil.addAll(dulcesMedio);
		dulcesDificil.add(naranja);
		
		Dificultad facil = new Dificultad(dulcesFacil);
		Dificultad medio = new Dificultad(dulcesMedio);
		Dificultad dificil = new Dificultad(dulcesDificil);
		
		//niveles
		Objetivo regular1 = new Regular(50, 50);
		List<Objetivo> objetivos1 = new ArrayList<Objetivo>();
		objetivos1.add(regular1);
		
		Nivel nivel1 = new Nivel("Conociendonos", new Point(5,5), 5, objetivos1);
		
		//jugadores
		Jugador jugador1 = new Jugador("Jorge", nivel1);
		
	}
}
