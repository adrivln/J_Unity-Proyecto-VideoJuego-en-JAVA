package FinalExtres;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;

public class Projectil extends PhysicBody {

	private static final long serialVersionUID = 1L;

	public Projectil(String name, int x1, int y1, int x2, int y2, double angle, String[] path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.trigger = true;
	}

	public Projectil(Projectil p, int x1, int y1, int x2, int y2) {
		super(p.name, x1, y1, x2, y2, p.angle, p.imgArray, p.f);
		this.trigger = true;
	}

	public Projectil(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.trigger = true;
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {

		System.out.println("coll with " + sprite.name);
		if (sprite instanceof Disparable) {
			Disparable d = (Disparable) sprite;
			d.danyar();
			System.out.println("pum");
			this.delete();
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		System.out.println("byebye");
	}

	@Override
	public void update() {
		super.update();
	}

}
