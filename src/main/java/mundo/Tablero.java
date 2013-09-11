package mundo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import colores.Dulce;
import dificultad.Dificultad;
import direcciones.Direccion;
import explosiones.Explosion;

public class Tablero {

	private Point dimension;
	private Dulce[][] celdas;
	private Partida partidaActual;

	/***********************
	 **********************/
	public Tablero(Point dimension, Dificultad dificultad){
		this.dimension = dimension;
	}
	/***********************
	 **********************/
	
	
	public Point getDimension() {
		return dimension;
	}

	public void setDimension(Point dimension) {
		this.dimension = dimension;
		this.celdas = new Dulce[dimension.y][dimension.x];

	}

	public int alto() {
		return dimension.y;
	}

	public int ancho() {
		return dimension.x;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public Tablero(Partida partidaActual) {
		super();
		this.partidaActual = partidaActual;
	}

	public boolean perteneceAlTablero(Point p) {
		return (p.getX() >= 0 && p.getX() <= this.getDimension().getX())
				&& (p.getY() >= 0 && p.getY() <= this.getDimension().getY());

	}

	public void ponerDulceEnCelda(Dulce dul, Point p) {

		celdas[p.y][p.x] = dul;

	}

	public Dulce dulceDeCelda(Point p) {
		Dulce dul = null;
		if (this.perteneceAlTablero(p)) {
			dul = celdas[p.y][p.x];

		}
		return dul;
	}

	// intercambia el contenido de 2 celdas

	public void intercambiarDulce(Point origen, Point destino) {
		Dulce traspaso = this.dulceDeCelda(origen);
		this.ponerDulceEnCelda(dulceDeCelda(destino), origen);
		this.ponerDulceEnCelda(traspaso, destino);

	}

	// Mueve el contenido de una celda a una contigua en la direccion indicada
	public boolean moverCeldaA(Point p, Direccion dir) {
		if (dir.puedeMoverCelda(p, this.getDimension())) {
			intercambiarDulce(p, dir.mover(p));
		}kjhkjjgnm
		/***********************
		 **********************/
		return (Boolean)null;
	}
	
	/*
	 * Recibe un punto, una direccion y una dificultad 
	 * chequea que el movimiento genere al menos una explosion, y de ser asi
	 * realiza el movimiento, explota las celdas y comoda las restantes, 
	 * repone los dulces restantes y retorna una loista de explosiones
	 * 
	 */
	public List<Explosion> realizarMovimiento(Point p, Direccion dir, Dificultad dif) {
		List<Explosion> crushed = new ArrayList<Explosion>();
		List<List<Point>> listas = new ArrayList<List<Point>>();
		if (movimientoGeneraExplosion(p, dir)) {
			moverCeldaA(p, dir);
			crushed = chequearTablero();
			listas = interseccionExplosiones(
					explosionesVerticales(alto(), ancho()),
					explosionesHorizontales(ancho(), alto()));
			moverCeldasPorDestruccion(listas);
			reponerCaramelos(dif);			
		}
		return crushed;
	}

	/*
	 * Con un punto y una direccion retorna un boolean si haubo explosion, haya
	 * o no, deja el tablero como estaba.
	 */
	public boolean movimientoGeneraExplosion(Point p, Direccion dir) {
		boolean hay = false;
		Dulce[][] temp = this.celdas;
		moverCeldaA(p, dir);
		hay =(chequearTablero().size() > 0);
		this.celdas = temp;
		return hay;
	}

	/*
	 * Dados 2 enteros, n y m, recorre n filas/columnas, m columnas/filas (de
	 * acuerdo al orden de los enteros va a recorrer horizontalmente o
	 * verticalmente la matriz) buscando posibles explosiones, si son de 3 o mas
	 * elementos(dulces), entonces las agrega a como lista de puntos donde hubo
	 * explosion.
	 */
	public List<List<Point>> chequearMatriz(int n, int m) {

		List<List<Point>> explosiones = new ArrayList<List<Point>>();

		for (int i = 0; i < n; i++) {
			int a = i;

			for (int j = 0; j < m; j++) {
				List<Point> posible = new ArrayList<Point>();
				posible.add(new Point(i, j));

				int b = j;
				int cant = 1;
				boolean es = true;

				while (es & b + 1 < ancho()) {
					Dulce d1 = celdas[a][b];
					Dulce d2 = celdas[a][b + 1];
					if (es = es & d1.compatibleConColor(d2)) {
						posible.add(new Point(a, b + 1));
						b++;
						cant++;
					}
					if (cant > 3) {
						explosiones.add(posible);
					}
				}
			}
		}

		return explosiones;
	}

	/*
	 * Con 2 int como parametro al igual que explosiones verticales, pero cambia
	 * el orden de los paramtros para realizar el barrido horizontal utilizando
	 * chequearMatriz
	 * 
	 * Retorna Una lista de lista de lista de puntos
	 */
	public List<List<Point>> explosionesHorizontales(int n, int m) {
		return chequearMatriz(n, m);
	}

	/*
	 * Con 2 int como parametro al igual que explosiones horizontales, pero
	 * cambia el orden de los paramtros para realizar el barrido vertical
	 * utilizando chequearMatriz
	 * 
	 * Retorna Una lista de lista de lista de puntos
	 */
	public List<List<Point>> explosionesVerticales(int n, int m) {
		return chequearMatriz(m, n);
	}

	/*
	 * Revisa si el tablero y devuelve una lista de explosiones. Si no hubo
	 * explosiones, devuelve una lista de explosiones vacia;
	 */
	public List<Explosion> chequearTablero() {

		List<Explosion> exp = explosiones(interseccionExplosiones(
				explosionesVerticales(alto(), ancho()),
				explosionesHorizontales(ancho(), alto())));

		return exp;

	}

	/*
	 * Dapa una lista de lista de puntos, con cada lista de puntos genera una
	 * explosion y devuelve la lista de las explosiones.
	 */
	private List<Explosion> explosiones(List<List<Point>> crashedCandy) {
		List<Explosion> exps = new ArrayList<Explosion>();
		for (List<Point> indiv : crashedCandy) {
			exps.add(convertirAexplosion(indiv));
		}
		return exps;
	}

	/*
	 * 
	 * Dada una lista de puntos, genera una explosion a la que le pasa como
	 * parametros el dulce de esa lista (se supone que todos los puntos devuelve
	 * el mismo dulce), y la cantidad puntos que participan en la explosion.
	 */

	private Explosion convertirAexplosion(List<Point> indiv) {
		return new Explosion(dulceDeCelda(indiv.get(0)), indiv.size());
	}

	/*
	 * Dadas 2 listas de listas de puntos busca las intersecciones de una lista
	 * de puntos con la otra y si coinciden en un punto crea una lista nueva y
	 * sin repetir el punto de interseccion
	 */
	public List<List<Point>> interseccionExplosiones(List<List<Point>> hor,
			List<List<Point>> ver) {
		List<List<Point>> interseccion = new ArrayList<List<Point>>();
		for (List<Point> lh : hor) {
			for (List<Point> lv : ver) {
				for (Point p : lh) {
					List<Point> puntos = new ArrayList<Point>();
					if (lv.contains(p)) {
						lv.remove(p);
						puntos.addAll(lv);
						puntos.addAll(lh);
						hor.remove(lh);
						ver.remove(lv);
						interseccion.add(puntos);
					} else {
						interseccion.add(lh);
						interseccion.add(lv);
					}
				}
			}
		}
		return interseccion;
	}

	/*
	 * Dada una lista de puntos, baja la columna en cada uno de ellos
	 */
	public void moverCeldasPorDestruccion(List<List<Point>> explotadas) {
		for (List<Point> lp : explotadas) {
			for (Point pt : lp) {
				bajarColumna(pt);
			}
		}
	}

	/*
	 * Dado un punto perteneciente al tablero, desplaza la columna una posicion
	 * hacia abajo
	 */

	private void bajarColumna(Point pt) {
		if (perteneceAlTablero(pt)) {
			for (int i = 0; i > 0; i--) {
				Point opt = pt;
				ponerDulceEnCelda(dulceDeCelda(new Point(pt.x, i)), opt);
				opt.move(pt.x, i);
				eliminarDulce(opt);
			}
		}
	}

	/*
	 * Dado un punto setea en null en esa posicion
	 */
	private void eliminarDulce(Point opt) {
		celdas[opt.y][opt.x] = null;
	}

	/*
	 * SAQUE ESTE METODO (Lo reemplace public boolean
	 * dulcesADestruirDesdeCelda(Point p) {
	 * 
	 * }
	 */

	/*
	 * Recorre el tablero, si encuentra una celda vacia la rellena con un dulce
	 * aleatorio.
	 */
	public void reponerCaramelos(Dificultad dif) {
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[i].length; j++) {
				if (celdas[i][j].equals(null)) {
					ponerDulceEnCelda(oneRandom(dif.getDulces()), new Point(
							i, j));
				}
			}
		}

	}

	/*
	 * Dada una lista de dulces, devuelve un dulce aleatorio
	 */

	public Dulce oneRandom(List<Dulce> caramelos) {
		boolean entra = false;
		Dulce car = null;
		while (!entra & caramelos.size() > 0) {
			int rdm = (int) (Math.random() * 100);
			if (entra || rdm <= caramelos.size()) {
				car = caramelos.get(rdm);
			}
		}
		return car;
	}

}