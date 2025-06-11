package FinalExtres;

import java.util.ArrayList;
import java.util.List;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;

public class RocaObserver extends Sprite {

	private static final long serialVersionUID = 1L;
	private static int comptador = 0;
	private int id;
	private int accionsDisponibles;

	public static List<InterficieXObserver> observers = new ArrayList<>();

	public void subscribe(InterficieXObserver i) {
		observers.add(i);
	}

	public void descriuredelegat(InterficieXObserver o) {
		observers.remove(o);
	}

	// static x cridar des de l'altre classe sensa instancia..
	public static void activarObserver() {
		for (InterficieXObserver i : observers) {
			i.primerlvl();
		}
	}

	public RocaObserver(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		comptador++;
		setId(comptador);
	}

	public RocaObserver(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f, int accions) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.setAccionsDisponibles(accions);
		comptador++;
		setId(comptador);
	}

	public RocaObserver(Field f, int x1, int y1, int mida) {
		super("roca" + comptador, x1, y1, x1 + mida, y1 + mida, 0, "resources/rock1.png", f);
		this.setAccionsDisponibles(50);
		comptador++;
		setId(comptador);
	}

	public RocaObserver() {
		super("roca" + comptador, 0, 0, 50, 50, 0, "resources/rock1.png", MainJoc.f);
		this.setAccionsDisponibles(50);
		comptador++;
		setId(comptador);
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
	
	/*
	 * @Override public void onCollisionEnter(Sprite sprite) { // TODO
	 * Auto-generated method stub //
	 * System.out.println("estic xocan amb "+this.getClass().getSimpleName()); //
	 * activarObserver(); com el personatge no és sprite he posat la colisio al pj..
	 * }
	 * 
	 * 
	 * @Override public void onCollisionExit(Sprite sprite) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */

}
