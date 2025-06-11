package FinalExtres;

import Core.Field;
import Core.Sprite;

public class EnemicBossFinal extends Enemic implements Disparable {

	private static final long serialVersionUID = 1L;
	int vida = 36;

	public EnemicBossFinal(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.vida = 50;
		setConstantForce(0, 0.01);
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		System.out.println("coll with " + sprite.name);
		if (sprite instanceof Atacable) {
			Atacable at = (Atacable) sprite;
			at.danyar();
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		// TODO Auto-generated method stub
	}

	@Override
	public void danyar() {
		vida--;
		if (vida <= 0) {
			this.delete();
			UI.instance.sumar(4000);
		}
	}

	@Override
	public void update() {
		super.update();
		if (this.y1 >= 600) {
			this.delete();
			UI.instance.sumar(-2000);
		}
	}

}
