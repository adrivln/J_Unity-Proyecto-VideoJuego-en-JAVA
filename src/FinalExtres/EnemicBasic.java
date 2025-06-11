package FinalExtres;

import Core.Field;
import Core.Sprite;

public class EnemicBasic extends Enemic implements Disparable {

	private static final long serialVersionUID = 1L;
	int vida = 3;

	public EnemicBasic(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f, int vida) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.vida = 2;
		setConstantForce(0, 0.02);
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		this.delete();
		System.out.println("coll with " + sprite.name);
		if (sprite instanceof Atacable) {
			Atacable at = (Atacable) sprite;
			at.danyar();
			this.delete();
		}
		this.delete();
	}

	@Override
	public void onCollisionExit(Sprite sprite) {

	}

	@Override
	public void danyar() {
		vida--;
		if (vida <= 0) {
			this.delete();
			UI.instance.sumar(100);
		}
	}

	@Override
	public void update() {
		super.update();
		if (this.y1 > 730) {
			this.delete();
			UI.instance.sumar(-30);
		}
	}

}
