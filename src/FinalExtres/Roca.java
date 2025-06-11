package FinalExtres;

import Core.Field;
import Core.Sprite;

public class Roca extends Sprite implements Disparable {

	private static final long serialVersionUID = 1L;
	private static int comptador = 0;
	private int id;
	private int accionsDisponibles;

	public Roca(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		comptador++;
		setId(comptador);
	}

	public Roca(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f, int accions) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.setAccionsDisponibles(accions);
		comptador++;
		setId(comptador);
	}

	public Roca(Field f, int x1, int y1, int mida) {
		super("roca" + comptador, x1, y1, x1 + mida, y1 + mida, 0, "resources/rock1.png", f);
		this.setAccionsDisponibles(50);
		comptador++;
		setId(comptador);
	}

	public Roca() {
		super("roca" + comptador, 0, 0, 50, 50, 0, "resources/rock1.png", MainJoc.f);
		this.setAccionsDisponibles(50);
		comptador++;

		setId(comptador);
	}

	@Override
	public void danyar() {
		// volia destruir plataformes però s'ha ajornat.
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccionsDisponibles() {
		return accionsDisponibles;
	}

	public void setAccionsDisponibles(int accionsDisponibles) {
		this.accionsDisponibles = accionsDisponibles;
	}
}
