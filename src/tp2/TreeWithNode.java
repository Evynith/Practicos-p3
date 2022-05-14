package tp2;

import java.util.ArrayList;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public void add(int value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	//es recursivo
	private void add(TreeNode actual, int value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	public int getRoot() {
		return this.root.getValue();
	}
	
	public boolean hasElem(int elemento) {
		return this.hasElem(this.root, elemento);
	}
	
	private boolean hasElem(TreeNode actual, int elemento) {
		if (actual != null) {
			if (actual.getValue() > elemento) {
				if (actual.getLeft() == null) { 
					return false;
				} else {
					return hasElem(actual.getLeft(),elemento);
				}
			} else if (actual.getValue() == elemento) {
				return true;
			} else {
				if (actual.getRight() == null) { 
					return false;
				} else {
					return hasElem(actual.getRight(),elemento);
				}
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public boolean delete(int num) {
		if (this.isEmpty()) {
			return false;
		}
		TreeNode padre = this.padreDelete(null, this.root, num);
		if(padre == null && this.root.getValue() != num) {
			return false;
		} else if (padre == null && this.root.getValue() == num) {
			int cant = this.cantHijos(padre.getLeft());
			if (cant == 0) {
				this.root = null;
				return true;
			} else if (cant == 1) {
				if (this.root.getLeft() != null) {
					this.root = this.root.getLeft();
				} else {
					this.root = this.root.getRight();
				}
				return true;
			} else {
				TreeNode nvoNode = this.NMD(this.root.getLeft());
				TreeNode hijoizq = this.root.getLeft();
				TreeNode hijoder = this.root.getRight();
				this.delete(nvoNode.getValue()); //bool verif
				nvoNode.setRight(hijoder);
				nvoNode.setLeft(hijoizq);
				this.root = nvoNode;
				return true;
			}
		}
		if(padre.getLeft().getValue() == num) {
			int cant = this.cantHijos(padre.getLeft());
			if (cant == 0) {
				padre.setLeft(null);
				return true;
			} else if (cant == 1) {
				if (padre.getLeft().getLeft() != null) {
					padre.setLeft(padre.getLeft().getLeft());
				} else {
					padre.setLeft(padre.getLeft().getRight());
				}
				return true;
			} else { // vamos por el NMD del sub-izq
				TreeNode nvoNode = this.NMD(padre.getLeft().getLeft());
				TreeNode hijoizq = padre.getLeft().getLeft();
				TreeNode hijoder = padre.getLeft().getRight();
				if (nvoNode == null) {
					padre.setLeft(hijoizq);
					hijoizq.setRight(hijoder);
				} else {
					this.delete(nvoNode.getValue()); //bool verif
					nvoNode.setRight(hijoder);
					nvoNode.setLeft(hijoizq);
					padre.setLeft(nvoNode);
				}	
				return true;
			}
		} else if(padre.getRight().getValue() == num)  {
			int cant = this.cantHijos(padre.getRight());
			if (cant == 0) {
				padre.setRight(null);
				return true;
			} else if (cant == 1) {
				if (padre.getRight().getLeft() != null) {
					padre.setRight(padre.getRight().getLeft());
				} else {
					padre.setRight(padre.getRight().getRight());
				}
				return true;
			} else { // vamos por el NMD del sub-izq
				TreeNode nvoNode = this.NMD(padre.getRight().getLeft());
				TreeNode hijoizq = padre.getRight().getLeft();
				TreeNode hijoder = padre.getRight().getRight();
				if (nvoNode == null) {
					hijoizq.setRight(hijoder);
					padre.setRight(hijoizq);
				} else {
					this.delete(nvoNode.getValue()); //bool verif
					nvoNode.setLeft(hijoizq);
					nvoNode.setRight(hijoder);
					padre.setRight(nvoNode);
				}	
				return true;
			}
		}
		return false;
	}
	
	private TreeNode NMD(TreeNode nodoIzquierdo) {
		if (nodoIzquierdo.getRight() == null) {
			return nodoIzquierdo;
		}
		return this.NMD(nodoIzquierdo.getRight());
	}
	
	private TreeNode padreDelete(TreeNode padre, TreeNode actual, int elemento) {
		if (actual != null) {
			if (actual.getValue() > elemento) {
				if (actual.getLeft() == null) { 
					return null;
				} else {
					return padreDelete(actual, actual.getLeft(),elemento);
				}
			} else if (actual.getValue() == elemento) {
				return padre;
			} else {
				if (actual.getRight() == null) { 
					return null;
				} else {
					return padreDelete(actual, actual.getRight(),elemento);
				}
			}
		}
		return null;
	}
	
	private int cantHijos(TreeNode nodo) {
		if(nodo.getLeft() != null && nodo.getRight() != null) {
			return 2;
		}
		if (nodo.getLeft() == null && nodo.getRight() == null) {
			return 0;
		}
		return 1;
	}
	
	public int getHeight() {
		 if (root == null) {
			   return 0;
		   } else {
			   return retornarAltura(root, 1);
		   }
	}
	
	private int retornarAltura(TreeNode nodo, int nivel) {
		return this.getLongestBranch().size();
    }
	
	 public ArrayList<Integer> getLongestBranch() {
		   if (root == null) {
			   return new ArrayList<>();
		   } else {
			   return ramaMasLarga(this.root) ;
		   }
	   }
	 
	 private ArrayList<Integer> ramaMasLarga(TreeNode node) {
			if ((node.getLeft() == null) && (node.getRight() == null)) {
				 ArrayList<Integer> rama = new ArrayList<Integer>();
		   		rama.add(node.getValue());
		   		return rama;
		   	} else {
		   		ArrayList<Integer> der = new ArrayList<Integer>();
		   		ArrayList<Integer> izq = new ArrayList<Integer>();
		   		if (node.getLeft() != null) {
		   			izq.addAll(ramaMasLarga(node.getLeft()));
		   		}
		   		if (node.getRight() != null) {
		   			der.addAll(ramaMasLarga(node.getRight()));
		   		}
		   		if (der.size() > izq.size()) {
		   			der.add(node.getValue());
		   			return der;
		   		} else {
		   			izq.add(node.getValue());
		   			return izq;
		   		}
		   	}
	   }
	 
	 public ArrayList<Integer> getFrontera(){
		 return this.getFrontera(root);
	 }
	 
	 private ArrayList<Integer> getFrontera(TreeNode node){
		 ArrayList<Integer> frontera = new ArrayList<Integer>();
		 if ((node.getLeft() == null) && (node.getRight() == null)) {
	   		frontera.add(node.getValue());
	   		return frontera;
	   	} else {
	   		if (node.getLeft() != null) {
	   			frontera.addAll(getFrontera(node.getLeft()));
	   		}
	   		if (node.getRight() != null) {
	   			frontera.addAll(getFrontera(node.getRight()));
	   		}
	   	}
	   	return frontera;
	 }
	 
	 public int getMaxElem() {
		 return this.NMD(this.root).getValue();
	 }
	 
	 public ArrayList<Integer> getElemAtLevel(int i){
		if (!this.isEmpty()) {
			return this.elemLevel(root, 0, i);
		}
		return new ArrayList<Integer>();
	 }
	 
	 private ArrayList<Integer> elemLevel(TreeNode node, int actual, int i){
		 ArrayList<Integer> nvl = new ArrayList<Integer>();
		 if ( actual == i) {
			 nvl.add(node.getValue());
		 } else if(actual > i) {
			 return nvl;
		 } 
			 if (node.getLeft() != null && actual < i) {
				 nvl.addAll(elemLevel(node.getLeft(), actual +1, i));
			 }
			 if (node.getRight() != null && actual < i) {
				 nvl.addAll(elemLevel(node.getRight(), actual +1, i));
			 }
		 
	   	return nvl;
	 }
	 public void preimprimir() {
			this.printPreorder(this.root);
		}
		public void imprimir() {
			this.printInorder(this.root);
		}
		public void postimprimir() {
			this.printPostorder(this.root);
		}
		
	 private void printPreorder(TreeNode node) {
			if (node == null)
			return;
			node.imprimir();
			printPreorder(node.getLeft());
			printPreorder(node.getRight());
		} 
		private void printInorder(TreeNode node) {
			if (node == null)
			return;
			printInorder(node.getLeft());
			node.imprimir();
			printInorder(node.getRight());
		} 
		private void printPostorder(TreeNode node) {
			if (node == null)
			return;
			printPostorder(node.getLeft());
			printPostorder(node.getRight());
			node.imprimir();
		} 
	 
}
