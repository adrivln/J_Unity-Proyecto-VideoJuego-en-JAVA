package FinalExtres;

import java.awt.Color;
import Core.Field;
import Core.Sprite;

//importem el color

public class Puntuacions extends Sprite {

	private static final long serialVersionUID = 1L;
	public static int puntuacio = 0;

	public Puntuacions(int x1, int y1, int x2, int y2, Field f) {
		super("Puntuacio", x1, y1, x2, y2, 0, "Puntuacio  :" + puntuacio, f);
		this.solid = false;
		this.text = true;
		this.textColor = Color.red.getRGB();
		this.puntuacio = 0;

	}

	public static int getPuntuacio() {
		return puntuacio;
	}

	public static void setPuntuacio(int puntuacio) {
		Puntuacions.puntuacio = puntuacio;
		System.out.println("la puntuacio es: " + puntuacio);
	}

	public void actualizar() {
		this.path = "La puntuacio es: " + this.puntuacio;

	}

	public void incrementarPuntuacio(int puntos) {
		this.puntuacio = puntuacio + puntos;
		System.out.println("la puntuacio es: " + puntuacio);
	}
}