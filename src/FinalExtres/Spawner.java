package FinalExtres;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Core.Field;

public class Spawner {
	public Field f;
	public static int maxX;
	static final int mida = 100;
	static final int mida2 = 100;
	static final int midagran = 100;
	static final int midagran2 = 100;

	boolean bossB = false;
	boolean bosB = false;
	Timer timer = new Timer();

	public Spawner(Field f, int i) {
		this.f = f;
		this.maxX = f.getWidth();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				generarEnemic();
			}
		};
		timer.schedule(task, 1, 6000); // cada 6 segons es genera 1 enemic pot se rmes o menys es igual
	}

	private void generarEnemic() {
		Random rand = new Random();
		int numerorandom = rand.nextInt(6);
		if (!MainJoc.primerapart) {
			this.timer.cancel();
		}
		if (bossB == false && Puntuacions.getPuntuacio() > 1200) {
			int randomX = rand.nextInt(maxX);
			EnemicBoss boss = new EnemicBoss("jefe", randomX, 0, randomX + midagran + 150, midagran + 200, 0,
					"resources/NyanCat.gif", f);
			System.out.println("Enemic final creat");
			f.addSprite(boss);
			bossB = true;
			generarEnemic();
		}
		if (!bosB && Puntuacions.getPuntuacio() > 4000) {
			if (!MainJoc.primerapart) {

			}
			int randomX = rand.nextInt(maxX);
			EnemicBossFinal boss1 = new EnemicBossFinal("jefe2", randomX, 0, randomX + midagran2 + 200, midagran + 200,
					0, "resources/CatFinal.gif", f);
			System.out.println("Enemic finalfinal creat!!");
			f.addSprite(boss1);
			bosB = true;
			generarEnemic();
		}

		int randomX = rand.nextInt(maxX);

		if (numerorandom == 0) {
			EnemicAmbArmadura enemic = new EnemicAmbArmadura("enemicspawn", randomX, 0, randomX + mida, mida2, 90,
					"resources/monstre22.gif", f);
			System.out.println("Enemic amb amor(armor) creat");
			f.addSprite(enemic);
		} else if (numerorandom == 1 || numerorandom == 2) {
			EnemicBasic enemic = new EnemicBasic("enemicspawn", randomX, 0, randomX + mida, mida2, 270,
					"resources/monstre11.gif", f, 3);
			System.out.println("Enemic basic creat");
			f.addSprite(enemic);
		} else if (numerorandom == 3 || numerorandom == 4) {
			EnemicBasic enemic = new EnemicBasic("enemicspawn", randomX, 0, randomX + mida, mida, 0,
					"resources/enemic21.gif", f, 3);
			System.out.println("Enemic basic 2 creat");
			f.addSprite(enemic);
		} else {
			EnemicBasic enemic = new EnemicBasic("enemicspawn", randomX, 0, randomX + mida, mida, 0,
					"resources/enemic3.gif", f, 3);
			System.out.println("Enemic basic3 creat");
			f.addSprite(enemic);
		}
	}
}