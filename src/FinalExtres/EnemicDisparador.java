package FinalExtres;

import java.util.Timer;
import java.util.TimerTask;

import Core.Field;
import Core.Sprite;

public class EnemicDisparador extends Enemic implements Disparable {

	private static final long serialVersionUID = 1L;
	int vida = 12;
	public ProjectilE proj;
	Timer timer = new Timer();

	public EnemicDisparador(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f,
			ProjectilE p) {
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
		ProjectilE bola2 = new ProjectilE("a", (int) this.x1 - 180, (int) this.y1 - 120, (int) this.x2 - 180,
				(int) this.y2 - 60, 0, "resources/focpjboR.gif", MainJoc.f);

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
		// TODO Auto-generated method stub
		t.cancel();
	}

	@Override
	public void update() {
		super.update();
		if (this.y1 >= 600) {
			this.delete();

			UI.instance.sumar(-70);

		} else if (MainJoc.comptador == 1) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 3) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 4) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}

		else if (MainJoc.comptador == 5) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 6) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 7) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}

		else if (MainJoc.comptador == 8) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 10) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 12) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		} else if (MainJoc.comptador == 15) {
			this.proj = new ProjectilE("projectil", 8000, 3000, 8200, 3200, 0, MainJoc.iniciarSpritesProjectilEnemic(),
					f);
		}

	}

}
