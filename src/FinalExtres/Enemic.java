package FinalExtres;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;

public class Enemic extends PhysicBody {

	private static final long serialVersionUID = 1L;
	int vida = 1;
	float a = f.getHeight();

	@Override
	public void onCollisionExit(Sprite sprite) {

	}

	public Enemic(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.addConstantForce(0, 0.2);
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		// TODO Auto-generated method stub
		System.out.println("coll with " + sprite.name); // imprimeix objecte si ha colisionat
		if (sprite instanceof Disparable) { // es pot fer un instanceof a l'interfície, no només la classe
			Disparable d = (Disparable) sprite; // casteig a disparable
			d.danyar(); // cridem a danyar
			System.out.println("pum,pum");
			this.delete(); // esborrem el projectil
		}
	}

}
