package FinalExtres;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Core.Field;
import Core.Window;

public class MainJoc {
	static Field f = new Field();
	static Window w = new Window(f);
	static boolean doblesalt = false;
	static ArrayList<Personatge> pj = new ArrayList<Personatge>();
	static ArrayList<Roca> plataformes = new ArrayList<Roca>();
	static boolean primerapart = true;

	static Roca terrabo = new Roca("terra", 0, 900, 2300, 1000, 0, "resources/terra1.png", f);
	public static int comptador = 0;
	static ArrayList<Roca> plataformeslvl2 = new ArrayList<Roca>();
	static ArrayList<Enemic> llistaXmoureEnemics = new ArrayList<Enemic>();

	static RocaObserver p27 = new RocaObserver("bloc27", 14300, 640, 14740, 850, 0, "resources/Nau.png", f);
	static boolean jahedonatforca = false;
	
	// enemics static pq nomes hi ha 1 de cada 
	static EnemicDisparador enm1d = new EnemicDisparador("e1", 1900, 480, 2300, 690, 0, "resources/mons111.gif", f, null);

	static EnemicDisparador enm4d = new EnemicDisparador("e4", 2600, 390, 3000, 600, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm5d = new EnemicDisparador("e5", 3300, 570, 3700, 780, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm6d = new EnemicDisparador("e6", 4000, 470, 4400, 680, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm7d = new EnemicDisparador("e7", 4400, 530, 4800, 740, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm8d = new EnemicDisparador("e8", 4800, 490, 5200, 700, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm9d = new EnemicDisparador("e9", 5300, 550, 5700, 760, 0, "resources/mons111.gif", f,
			null);
	static EnemicDisparador enm10d = new EnemicDisparador("e10", 5800, 510, 6200, 720, 0, "resources/mons13.gif", f,
			null);
	static EnemicDisparador enm12d = new EnemicDisparador("e12", 6800, 530, 7200, 740, 0, "resources/mons13.gif", f,
			null);
	static EnemicDisparador enm14d = new EnemicDisparador("e14", 7800, 450, 8200, 660, 0, "resources/mons13.gif", f,
			null);
	static EnemicDisparador enm17d = new EnemicDisparador("e17", 9300, 530, 9700, 740, 0, "resources/mons13.gif", f,
			null);
	static EnemicDisparador enm20d = new EnemicDisparador("e20", 10800, 510, 11200, 720, 0, "resources/monstre2.gif", f,
			null);
	static EnemicDisparador enm23d = new EnemicDisparador("e23", 12300, 490, 12700, 700, 0, "resources/monstre2.gif", f,
			null);
	static EnemicDisparador enm26d = new EnemicDisparador("e26", 13800, 470, 14200, 680, 0, "resources/monstre2.gif", f,
			null);

	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		UI ui = UI.getInstance(40, 40, 20, 30, f);
		Observador o = new Observador(); // subscipcio del Observer primer lvl
		p27.subscribe(o);

		Projectil p = new Projectil("projectil", 8000, 3000, 8200, 3200, 0, iniciarSpritesProjectil(), f);

		File sonido = new File("resources/so/fons.wav"); // reproudir musica en java
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonido);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		Personatge pjbo = new Personatge("Personatge", 0, 90, 300, 300, 0, inciarSprites(), f, p);
		pjbo.setCurrentImg(0);
		pj.add(pjbo);

		Roca p1 = new Roca("bloc1", 200, 700, 640, 740, 0, "resources/terra1.png", f);
		plataformes.add(p1);

		llistaXmoureEnemics.add(enm1d);

		llistaXmoureEnemics.add(enm6d);

		llistaXmoureEnemics.add(enm8d);

		llistaXmoureEnemics.add(enm9d);

		llistaXmoureEnemics.add(enm26d);
		llistaXmoureEnemics.add(enm20d);
		llistaXmoureEnemics.add(enm17d);
		llistaXmoureEnemics.add(enm14d);
		llistaXmoureEnemics.add(enm12d);

		Roca p3 = new Roca("bloc1", 1900, 720, 2340, 760, 0, "resources/terra2.png", f);
		plataformes.add(p3);

		Roca p4 = new Roca("bloc1", 2600, 600, 3040, 640, 0, "resources/terra3.png", f);
		plataformes.add(p4);

		Roca p5 = new Roca("bloc1", 3300, 780, 3740, 820, 0, "resources/terra4.png", f);
		plataformes.add(p5);

		Roca p6 = new Roca("bloc1", 4000, 680, 4440, 720, 0, "resources/terra5.png", f);
		plataformes.add(p6);

		Roca p7 = new Roca("bloc1", 4400, 740, 40, 780, 0, "resources/terra6.png", f);
		plataformes.add(p7);

		Roca p8 = new Roca("bloc1", 4800, 700, 5240, 740, 0, "resources/terra7.png", f);
		plataformes.add(p8);

		Roca p9 = new Roca("bloc1", 5300, 760, 5740, 800, 0, "resources/terra7.png", f);
		plataformes.add(p9);

		Roca p10 = new Roca("bloc1", 5800, 720, 6240, 760, 0, "resources/terra8.png", f);
		plataformes.add(p10);

		Roca p12 = new Roca("bloc1", 6800, 740, 7240, 780, 0, "resources/terra10.png", f);
		plataformes.add(p12);

		Roca p14 = new Roca("bloc1", 7800, 660, 8240, 700, 0, "resources/terra10.png", f);
		plataformes.add(p14);

		Roca p17 = new Roca("bloc17", 9300, 740, 9740, 780, 0, "resources/terra11.png", f);
		plataformes.add(p17);

		Roca p20 = new Roca("bloc20", 10800, 720, 11240, 760, 0, "resources/terra11.png", f);
		plataformes.add(p20);

		Roca p23 = new Roca("bloc23", 12300, 700, 12740, 740, 0, "resources/terra12.png", f);
		plataformes.add(p23);

		Roca p26 = new Roca("bloc26", 13800, 680, 14240, 720, 0, "resources/terra12.png", f);
		plataformes.add(p26);

		Spawner spawn = new Spawner(f, 2000);// 2 seg

		boolean sortir = false;

		f.background = "resources/bg4Flecha.png";
		boolean noheposatbg = false;

		while (!sortir) {
			input(pjbo);
			f.draw();
			Thread.sleep(40);// 20-70
			if (pjbo.x1 > 1450 && primerapart) {
				System.out.println(comptador);
				funcioprimerpart(pjbo, primerapart);
			} else if (pjbo.x1 < 400 && !primerapart) {
				funciosegonapart(pjbo);
				if (!noheposatbg) {
					f.background = "resources/bg10.png";
					noheposatbg = true;
				}
			}

		}

	}

	private static void funcioprimerpart(Personatge pjbo, boolean primerapart) {
		// TODO Auto-generated method stubbo
		if (primerapart) {
			comptador++;// referencia quin slat estic..
			pjbo.x1 = 90;
			pjbo.x2 = 300;
			System.out.println(comptador);
			for (Roca f : plataformes) {
				f.x1 = f.x1 - 830;
				f.x2 = f.x2 - 830;

			}

			p27.x1 -= 830; // la roca observada no esta a les plataformes però s'ha de moure
			p27.x2 -= 830;

			for (Enemic en : llistaXmoureEnemics) {
				en.x1 -= 830;
				en.x2 -= 830;
			}
		} // quan arriva als salts que vull faig cambi de bg per treure la flecha..

		if (comptador == 1) {

			f.background = "resources/bg5.png";

		} else if (comptador == 2) {
		}

		else if (comptador == 3) {
			f.background = "resources/bg6.png";

		}

		else if (comptador == 4) {
			f.background = "resources/bg6.jpg";

		}

		else if (comptador == 6) {
			f.background = "resources/bg3.jpg";

		}

		else if (comptador == 8) {
			f.background = "resources/b2.jpg";

		}

		else if (comptador == 14) {
			f.background = "resources/bg7.jpg";

		}

		else if (comptador == 15) {
			f.background = "resources/bg7S.png";
		}

	}

	public static void funciosegonapart(Personatge pjbo) {
		comptador++;
		System.out.println(comptador);

		if (comptador == 27) {
			for (Roca e : plataformeslvl2) {
				e.delete();
			}
			f.background = "resources/fonsfinal.png";
			// posicio random al pj i final.

		}

		if (comptador <= 27) {
			pjbo.x1 = 1150;
			pjbo.x2 = 1450;
			pjbo.y1 = 90;
			pjbo.y2 = 300;

		} else {
			// seria x despres del drac no spawnejar mes a dalt dreta..

			pjbo.x1 = 1250;
			pjbo.y1 = 190;// +45
			pjbo.x2 = 1550;
			pjbo.y2 = 400; // +150

		}

		for (Enemic e : llistaXmoureEnemics) {
			e.x1 = e.x1 + 450;
			e.x2 = e.x2 + 450;
			e.y1 += 102;
			e.y2 += 102;
		}

		for (Roca f : plataformeslvl2) {
			f.x1 = f.x1 + 450;
			f.x2 = f.x2 + 450;
			f.y1 += 102;
			f.y2 += 102;
		}

		if (comptador == 17) {
			terrabo.delete();
			f.background = "resources/bg8.png";

		}

		if (comptador == 18) {
			f.background = "resources/bg8.png";
		}

		if (comptador == 19) {
			f.background = "resources/bg9.jpg";
		}

		if (!Observador.ari.isEmpty()) {
			Observador.ari.get(0).delete();

		}

	}

	public static String[] iniciarSpritesProjectil() {
		String[] ari1 = new String[2];
		ari1[0] = "resources/focpj.gif";
		ari1[1] = "resources/focpjR.gif";
		return ari1;
	}

	public static String[] iniciarSpritesProjectilEnemic() {
		String[] ari1 = new String[2];
		ari1[0] = "resources/focpjbo.gif";
		ari1[1] = "resources/focpjboR.gif";
		return ari1;
	}

	public static String[] inciarSprites() {
		String[] ari = new String[14];
		ari[0] = Personatge.iddle;
		ari[1] = Personatge.corre;
		ari[2] = Personatge.attac;
		ari[3] = Personatge.mal;
		ari[4] = Personatge.memori;
		ari[5] = Personatge.salt;
		ari[6] = Personatge.iddleR;
		ari[7] = Personatge.correR;
		ari[8] = Personatge.attacR;
		ari[9] = Personatge.malR;
		ari[10] = Personatge.memoriR;
		ari[11] = Personatge.saltR;
		ari[12] = Personatge.ajupirse;
		ari[13] = Personatge.ajupirse;
		return ari;
	}

	private static void input(Personatge p) throws InterruptedException {

		if (w.getKeysDown().contains('w')) {
			if (p.esticesquerra) {
				p.setCurrentImg(11);

			} else {
				p.setCurrentImg(5);

			}
			if (!doblesalt && p.esticterra) {

				if (w.getKeysDown().contains('d') && !jahedonatforca) {

					jahedonatforca = true;
					p.moviment(Input.DALTDRETA);
					System.out.println("entran dalt dreta");
				} else if (w.getKeysDown().contains('a') && !jahedonatforca) {
					jahedonatforca = true;
					System.out.println("entran dalt esquerra");
					p.moviment(Input.DALTESQUERRA);
				} else {

					p.moviment(Input.AMUNT);
					p.esticesquerra = false;

				}
				doblesalt = true;
			}
		}

		if (w.getKeysUp().contains('w')) {
			doblesalt = false;
			if (p.esticesquerra) {
				p.setCurrentImg(6);
			} else {
				p.setCurrentImg(0);
			}
			p.setForce(0, 3);

		}
		if (w.getKeysDown().contains('d')) {
			p.setCurrentImg(1);
			p.moviment(Input.DRETA); // keydwn avança
			if (jahedonatforca) {
				jahedonatforca = false;
			}
		}

		if (w.getKeysUp().contains('d')) {// keyup treu veocity
			if (p.esticesquerra) {
				System.out.println((int) p.x1 + " y1  " + (int) p.y1 + " x2 " + (int) p.x2 + " y2 " + (int) p.y2);

				p.setCurrentImg(6);

			} else {
				p.setCurrentImg(0);

			}
			p.setConstantForce(0, 0.7);
			p.setVelocity(0, 0);

			if (jahedonatforca) {
				jahedonatforca = false;
			}

		}

		if (w.getKeysDown().contains('a')) {
			System.out.println((int) p.x1 + " y1" + (int) p.y1 + " x2" + (int) p.x2 + " y2" + (int) p.y2);
			p.setCurrentImg(7);

			p.moviment(Input.ESQUERRA);
			p.setConstantForce(0, 0.7);

		}

		if (w.getKeysUp().contains('a')) {
			if (p.esticesquerra) {
				p.setCurrentImg(6);

			} else {
				p.setCurrentImg(0);

			}
			p.setConstantForce(0, 0.7);
			p.setVelocity(0, 0);

		}

		if (w.getKeysDown().contains('s')) {
			p.moviment(Input.AVALL);
		}
		if (w.getKeysDown().contains(' ')) {
			p.moviment(Input.DISPARAR);

		}
		if (w.getKeysUp().contains(' ')) {
			if (p.esticesquerra) {
				p.setCurrentImg(6);
			} else {
				p.setCurrentImg(0);

			}
			p.setVelocity(0, 0);
		}
	}
}