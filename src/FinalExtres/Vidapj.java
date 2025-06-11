package FinalExtres;

import java.awt.Color;
import Core.Field;
import Core.Sprite;

public class Vidapj extends Sprite {

	private static final long serialVersionUID = 1L;
	static int vides = Personatge.vides;

	public Vidapj(int x1, int y1, int x2, int y2, Field f) {
		super("vidapj", x1, y1, x2, y2, 0, "Vides: " + vides, f);
		this.solid = false;
		this.text = true;
		this.textColor = Color.red.getRGB();
	}

	public void actualizar() {
		this.vides = Personatge.vides - 1;
		this.vides = Personatge.vides + 1;
		this.vides = Personatge.vides;
		this.path = "Vides de moment..: " + this.vides;
	}
}
