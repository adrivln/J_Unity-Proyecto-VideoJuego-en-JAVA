
package FinalExtres;

import java.util.ArrayList;

public class Observador implements InterficieXObserver {
	boolean jaheposatPlataformes = false;
	public static ArrayList<Roca> ari = new ArrayList<Roca>();

	@Override
	public void primerlvl() {
		// TODO Auto-generated method stub
		MainJoc.primerapart = false;
		MainJoc.f.background = "resources/bg11.png";

		System.out.println("entran   observer");

		for (Roca roca : MainJoc.plataformes) {
			roca.delete(); // borrem totes les plataformes per cambiar de lvl i el delegat tb cambia el
							// fons i posa altes plataformes
		}

		int sumadorX1 = 0;
		int sumadorY1 = 0;

		if (!jaheposatPlataformes) {
			for (Enemic e : MainJoc.llistaXmoureEnemics) {
				e.delete();
			}
			String s = ""; // crea les plataformes del nivell
			for (int i = 0; i < 20; i++) {

				if (i < 10) {
					s = "resources/terrafinal1.png";
				} else {
					s = "resources/terrafinal2.png";
				}
				if (i == 19) {

					MainJoc.plataformeslvl2.add(new Roca("blocfor", -500 - sumadorX1, 470 - sumadorY1, 980 - sumadorX1,
							510 - sumadorY1, 0, s, MainJoc.f));
					System.out.println(sumadorX1 + "x1 y1" + sumadorY1);
					continue;
				} else {
					MainJoc.plataformeslvl2.add(new Roca("blocfor", 640 - sumadorX1, 470 - sumadorY1, 980 - sumadorX1,
							510 - sumadorY1, 0, s, MainJoc.f));
					sumadorX1 += 260;
					sumadorY1 += 60;
				}
			}

			MainJoc.pj.get(0).x1 = 1150;
			MainJoc.pj.get(0).x2 = 1450;
			MainJoc.pj.get(0).y1 = 90;
			MainJoc.pj.get(0).y2 = 300;
			jaheposatPlataformes = true;
			Roca r = new Roca("borrar", 1200, 650, 1700, 690, 0, "resources/terra7.png", MainJoc.f);
			MainJoc.p27.delete(); // borran plataforma observer
			ari.add(r);

			// tamany drac final
			MainJoc.llistaXmoureEnemics.clear(); // -5440, -710, -3960, -630,
			EnemicDisparador r1 = new EnemicDisparador("efor", -5440, -1200, -3960, -630, 0, "resources/monstre22.gif",
					MainJoc.f, null);
			System.out.println(sumadorX1 + "x1 y1" + sumadorY1);

			MainJoc.f.addSprite(r1);
			MainJoc.llistaXmoureEnemics.add(r1);

		}
	}
}