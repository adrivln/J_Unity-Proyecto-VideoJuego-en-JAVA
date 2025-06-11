package FinalExtres;

import Core.Field;

public class UI {

	public static UI instance = null;
	public Puntuacions punts;
	public Vidapj vides;
	public Field f;
	boolean Enemic1 = false;
	boolean Enemic2 = false;

	private UI(int x1, int x2, int y1, int y2, Field f) {
		this.punts = new Puntuacions(x1, x2, y1, y2, f);
		this.f = f;
		this.vides = new Vidapj(x1, x2, y1 + 20, y2 + 20, f);
	}

	public static UI getInstance(int x1, int x2, int y1, int y2, Field f) {

		if (instance == null) {
			instance = new UI(x1, x2, y1, y2, f);
		}
		return instance;
	}

	public void restarVides(int vida) {
		this.vides.vides -= vida;
		this.vides.vides = vides.vides - 1;
		this.vides.vides = vides.vides + 1;
		this.vides.actualizar();
	}

	public void sumarvid(int vida) {
		this.vides.vides += vida;
		this.vides.vides = vides.vides - 1;
		this.vides.vides = vides.vides + 1;
		this.vides.actualizar();
	}

	public void sumar(int punts) {
		this.punts.puntuacio += punts;
		this.punts.actualizar();
	}
}