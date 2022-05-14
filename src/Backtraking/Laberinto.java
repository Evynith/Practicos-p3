package Backtraking;

import java.util.ArrayList;

public class Laberinto {

	private ArrayList<ArrayList<Casilla>> casillas;
	private ArrayList<Casilla> mejorCamino;
	private int mejorResultado, idFinal, largoMax, altoMax;
	public  ArrayList<ArrayList<Casilla>> resultados;
	
	public Laberinto(ArrayList<ArrayList<Casilla>> casillas) {
		this.casillas = casillas;
		this.mejorCamino = new ArrayList<Casilla>();
		this.mejorResultado = 3000; 
		this.idFinal = 0;
		this.altoMax = casillas.size();
		this.largoMax = casillas.get(0).size();
	}
	
	public ArrayList<Casilla> encontrarCaminoMenorLongitud(int idInicio, int idFinal) {
		this.idFinal = idFinal;
		for (int i = 0; i<casillas.size(); i++) {
			for (int j = 0; j<casillas.get(0).size(); j++) {
				if (casillas.get(i).get(j).getId() == idInicio) {
					this.buscarMenorCamino(new int[]{i,j}, new ArrayList<Casilla>(), 0);
				}
			}
		}
		return this.mejorCamino;
	}
	
	//como los objetos (arrayList e.g) se obtienen por referencia en una funcio de rrecusion
	//al volver ay que cambiar su estado, pero un tipo priitivo (e.g int) vuelve a su estado del momento
	//por eso no es necesario modificarlo (en este caso restarle el valor antes sumado)
	private void buscarMenorCamino(int[] pos, ArrayList<Casilla> casillasProvisorias, int resultadoProvisorio) {
		Casilla c = casillas.get(pos[0]).get(pos[1]);
		casillasProvisorias.add(c);
		resultadoProvisorio += c.getValor();
		if (c.getId() == this.idFinal) {
			if(resultadoProvisorio <= this.mejorResultado) {
				this.mejorCamino = new  ArrayList<Casilla>(casillasProvisorias);
				this.mejorResultado = resultadoProvisorio;
			}
		} else {
			if (resultadoProvisorio < this.mejorResultado) { //poda
				ArrayList<int[]> posibles = this.posiblesAPartirDe(c, pos);
				for (int[] posAd : posibles) {
					Casilla ad = casillas.get(posAd[0]).get(posAd[1]);
					this.buscarMenorCamino(posAd, casillasProvisorias, resultadoProvisorio);
					casillasProvisorias.remove(ad);
//					resultadoProvisorio -= ad.getValor();
				}
			}
		}
		
	}
	
	private ArrayList<int[]> posiblesAPartirDe(Casilla c, int[] pos){
		ArrayList<int[]> rta = new ArrayList<int[]>();
		if(c.isAbajo() && pos[0]+1 < this.altoMax) {
			rta.add(new int[]{pos[0]+1, pos[1]}); //i,j -- altura, anchura
		}
		if(c.isArriba() && pos[0]-1 >= 0) {
			rta.add(new int[]{pos[0]-1,pos[1]}); 
		}
		if(c.isDerecha() && pos[1]+1 < this.largoMax) {
			rta.add(new int[]{pos[0], pos[1]+1}); 
		}
		if(c.isIzquierda() && pos[1]-1 >= 0) {
			rta.add(new int[]{pos[0], pos[1]-1}); 
		}
		return rta;
	}
}
