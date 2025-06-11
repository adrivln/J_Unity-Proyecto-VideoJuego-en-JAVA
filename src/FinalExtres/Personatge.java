package FinalExtres;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;

public class Personatge extends PhysicBody implements Atacable {

	private static final long serialVersionUID = 1L;
	Projectil p;
	static int vides = 74;
	public static String attac = "resources/pj/Atac.gif";
	public static String iddle = "resources/pj/Iddle.gif";
	public static String mal = "resources/mal.gif";
	public static String ajupirse = "resources/pj/ajup.gif";
	public static String corre = "resources/pj/Corre.gif";// 4
	public static String memori = "resources/muertox.gif";
	public static String salt = "resources/pj/nouSalt.gif";// 6
	public static String attacR = "resources/pj/Ataci.gif";
	public static String iddleR = "resources/pj/Iddlei.gif";
	public static String malR = "resources/mali.gif";
	public static String ajupirseR = "resources/pj/ajupi.gif";
	public static String correR = "resources/pj/Correi.gif";// 11
	public static String memoriR = "resources/muertoxi.gif";// no usat
	public static String saltR = "resources/pj/nouSalti.gif";//
	String  f [];
	public boolean esticesquerra = false;
	public boolean esticterra = false;
	static double novavelocitatbuff = 0;

	public Personatge(String name, int x1, int y1, int x2, int y2, double angle, String[] path, Field f, Projectil projectil) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.p = projectil;
		this.setForce(0, 3);
		this.setConstantForce(0, 0.7);
	}

//	public Personatge(String name, int x1, int y1, int x2, int y2, double angle, String string, Field f, Projectil projectil) {
//		super(name, x1, y1, x2, y2, angle, string, f);
//		this.p = projectil;
//		this.setConstantForce(0, 3);
//	}

	public void aplicarBuffVelocitat(double morevelocitat) {
		this.novavelocitatbuff += morevelocitat;
	}

	public void treureBuffVelocitat(double novavelocitat) {
		this.novavelocitatbuff = this.novavelocitatbuff - novavelocitat;
	}

	public void moviment(Input in) {
		double veloTotal = 22 + novavelocitatbuff;

		if (in == Input.DRETA) {
			esticesquerra = false;
			this.setConstantForce(0, 0);
			this.y1 = y1 - 40; // volar
			this.y2 = y2 - 40;
			this.setCurrentImg(1);
			this.setVelocity(veloTotal, 0);

		}

		else if (in == Input.ESQUERRA) {
			this.setConstantForce(0, 0);
			esticesquerra = true;
			this.setCurrentImg(7);
			this.y1 = y1 - 40;// volar
			this.y2 = y2 - 40;//

			this.setVelocity(-veloTotal, 0);
		}

		if (in == Input.AVALL) {
			this.setCurrentImg(13);
		}

		if (in == Input.DISPARAR) {
			if (esticesquerra) {
				this.setCurrentImg(8);
			} else {
				this.setCurrentImg(2);
			}
			this.disparar(p);
		}

		if (in == Input.AMUNT && esticterra) {

			this.addVelocity(0, -veloTotal);
			// O alternativamente:
			// this.setForce(0, -2);
		} else if (in == Input.DALTDRETA && esticterra) {
			esticterra = false;
			this.addForce(+1, -2);
			this.setCurrentImg(5);

		} else if (in == Input.DALTESQUERRA && esticterra) {
			esticterra = false;

			this.setCurrentImg(11);
			this.addForce(-1.5, -7);
		}
	}

	public int getVides() {
		return vides;
	}

	public void disparar2(Projectil p) {
		Projectil bola = new Projectil(p, (int) this.x1 - 10, (int) this.y1 + 3, (int) this.x2 + 300,
				(int) this.y2 + 300);

		bola.setVelocity(0, -30);
	}

	public void disparar(Projectil p) {
		if (esticesquerra) {
			Projectil bola = new Projectil(p, (int) this.x1 - 160, (int) this.y1 - 40, (int) this.x2 - 160,
					(int) this.y2 - 10);
			bola.setCurrentImg(1);
			bola.setVelocity(-30, 0);
		} else {
			Projectil bola = new Projectil(p, (int) this.x1 + 160, (int) this.y1 - 40, (int) this.x2 + 160,
					(int) this.y2 - 10);
			bola.setCurrentImg(0);
			bola.setVelocity(+30, 0);
		}
	}

	@Override
	public void danyar() {
		vides--;
		UI.instance.restarVides(1);
		if (vides <= 0) {
			this.delete();
			System.out.println("Fi de joc .");
			System.exit(0);
		}
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		// TODO Auto-generated metho
		if (sprite instanceof Roca) {
			esticterra = true;
		} else if (sprite instanceof RocaObserver) {
			esticesquerra = true;
			System.out.println("estic colistion amb la roca Observer");
			RocaObserver.activarObserver();
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		// TODO Auto-generated method stub
	}
}
