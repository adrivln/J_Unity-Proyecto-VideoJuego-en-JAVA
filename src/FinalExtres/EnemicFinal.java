package FinalExtres;

import java.util.Timer;
import java.util.TimerTask;

import Core.Field;
import Core.Sprite;

public class EnemicFinal extends Enemic implements Disparable {

	private static final long serialVersionUID = 1L;
	int vida = 12;
	public ProjectilE proj;
	Timer timer = new Timer();

	public EnemicFinal(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f, ProjectilE p) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.vida = 4;
		this.proj = p;
		setConstantForce(0, 0.02);

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (proj != null) {
					CrearProj();

				}
			}
		};
		timer.schedule(task, 1, 2000);

	}

	public void CrearProj() {
		proj.setCurrentImg(1);
		ProjectilE bola2 = new ProjectilE("a", (int) this.x1 - 460, (int) this.y1 - 40, (int) this.x2 - 560,
				(int) this.y2 - 10, 0, "resources/focpjboR.gif", MainJoc.f);

		bola2.setVelocity(-30, 0);
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

			proj = null;
			funciotimer(timer);
			this.delete();
			UI.instance.sumar(300);
		}
	}

	private void funciotimer(Timer t) {
		t.cancel();
	}

	@Override
	public void update() {
		super.update();
		if (this.y1 >= 600) {
			this.delete();
			UI.instance.sumar(-70);
		}

		if (MainJoc.comptador == 1) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}

		if (MainJoc.comptador == 3) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}

		if (MainJoc.comptador == 4) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}
	}

}
