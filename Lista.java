package arraysExamen;

import java.util.Arrays;

public class Lista {
	private String[] lista;

	public Lista() {
		this.lista = new String[0];
	}

	public Lista(int length) {
		this.lista = new String[length];
	}

	/* toString(). Convierte en un String todos los elementos del Array lista. */
	@Override
	public String toString() {
		String resultado = new String();
		for (int i = 0; i < this.lista.length; i++) {
			resultado = resultado + this.lista[i] + " ";
		}
		return resultado;
	}

	/*
	 * add (String texto) (String texto, int position). El método add tendrá dos
	 * variantes, una con un parámetro y otra con dos parámetros. Añadirá texto a
	 * lista en position, si solo disponemos de un parámetro añadiremos texto al
	 * final de lista. Sí position es negativo o mayor que length devolverá false en
	 * otro caso true.
	 */
	public boolean add(String texto) {
		boolean resultado = true;
		String[] nuevaLista = new String[this.lista.length + 1];
		for (int i = 0; i < this.lista.length; i++) {
			nuevaLista[i] = this.lista[i];
		}
		nuevaLista[this.lista.length] = texto;
		this.lista = nuevaLista;
		return resultado;
	}

	public boolean add(String texto, int position) {
		boolean resultado = true;
		if (position >= this.lista.length || position < 0) {
			resultado = false;
		} else {
			int j = 0;
			String[] nuevaLista = new String[this.lista.length + 1];
			for (int i = 0; i < nuevaLista.length; i++) {
				if (i == position) {
					nuevaLista[i] = texto;
					i++;
				}
				nuevaLista[i] = this.lista[j];
				j++;
			}
			this.lista = nuevaLista;
		}
		return resultado;
	}

	/*
	 * delete (int position). Elimina el string de lista que se encuentra en
	 * position. Si position es negativo o mayor o igual que length devolverá false
	 * en otro caso true.
	 */
	public boolean delete(int position) {
		boolean resultado = true;
		boolean add = true;
		int j = 0;
		String[] nuevaLista = new String[this.lista.length - 1];
		if (position >= this.lista.length || position < 0) {
			resultado = false;
		} else {
			for (int i = 0; i < this.lista.length; i++) {
				if (i == position) {
					add = false;
				}
				if (add) {
					nuevaLista[j] = this.lista[i];
					j++;
				}
				add = true;
			}
		}
		this.lista = nuevaLista;
		return resultado;
	}

	/*
	 * invert(). Invierte los elementos de lista. Devuelve false si lista tiene un
	 * length=0, en otro caso devuelve true.
	 */

	public boolean invert() {
		boolean resultado = true;
		String[] nuevaLista = new String[this.lista.length];
		if (this.lista.length == 0) {
			resultado = false;
		} else {
			int j = lista.length - 1;
			for (int i = 0; i < this.lista.length; i++) {
				nuevaLista[i] = this.lista[j];
				j--;
			}
			this.lista = nuevaLista;
		}
		return resultado;
	}

	/*
	 * search(String texto). Devuelve un entero que indica la posición del primer
	 * elemento de lista que encaja con texto.
	 */

	public int search(String texto) {
		int index = -1;
		boolean yeah = false;
		boolean isEqual = true;
		int i = 0;
		while (i < this.lista.length) {
			if (this.lista[i].length() == texto.length()) {
				for (int j = 0; j < this.lista[i].length(); j++) {
					if (this.lista[i].charAt(j) != texto.charAt(j)) {
						isEqual = false;
					}
				}
				if (isEqual) {
					index = i;
					i = this.lista.length;
				}
				isEqual = true;
			}

			i++;
		}
		return index;
	}

	/*
	 * count (String texto). Devuelve un entero que indica el número de veces que un
	 * elemento de lista encaja con el texto pasado por parámetro.
	 */

	public int count(String texto) {
		int counter = 0;
		boolean yeah = false;
		boolean isEqual = true;
		int i = 0;
		while (i < this.lista.length) {
			if (this.lista[i].length() == texto.length()) {
				for (int j = 0; j < this.lista[i].length(); j++) {
					if (this.lista[i].charAt(j) != texto.charAt(j)) {
						isEqual = false;
					}
				}
				if (isEqual) {
					counter++;
				}
				isEqual = true;
			}

			i++;
		}
		return counter;
	}

	/*
	 * remove (String texto). Elimina todos los elementos de lista que encajan con
	 * texto. Devuelve el número de elementos eliminados.
	 */

	public int remove(String texto) {
		int eliminados = 0;
		for (int i = 0; i < this.lista.length; i++) {
			int iguales = search(texto);
			if (i == iguales) {
				delete(i);
				eliminados++;
				i--;
			}
		}
		return eliminados;
	}

	/*
	 * subLista(int offset) (int index, int offset). El método subLista tendrá dos
	 * variantes, una con un parámetro y otra con dos parámetros. Devolverá un
	 * objeto de la clase Lista con los elementos de la lista que lo invoca que
	 * vayan desde index (index=0 para el método con un parámetro), inclusive, hasta
	 * index + offset, no inclusive. Devolverá una lista vacia (length=0) en los
	 * siguientes casos: - index negativo - index+offset >= lista.length
	 */

	public Lista subLista(int offset) {
		Lista nuevaLista = new Lista();
		if (offset < 0 || offset > this.lista.length) {
			Lista vacia = new Lista();
			nuevaLista = vacia;
		} else {
			Lista listaOffset = new Lista(offset);
			nuevaLista = listaOffset;
			for (int i = 0; i < offset; i++) {
				nuevaLista.lista[i] = this.lista[i];
			}
		}
		return nuevaLista;
	}

	public Lista subLista(int index, int offset) {
		Lista nuevaLista = new Lista();
		if (index < 0 || offset < index || index + offset >= this.lista.length) {
			Lista vacia = new Lista();
			nuevaLista = vacia;
		} else if (index == offset) {
			Lista uno = new Lista(1);
			uno.lista[0] = this.lista[index];
			nuevaLista = uno;
		} else {
			Lista listaOffset = new Lista(offset - index);
			nuevaLista = listaOffset;
			int j = 0;
			for (int i = index; j < offset - index; i++) {
				nuevaLista.lista[j] = this.lista[i];
				j++;
			}
		}
		return nuevaLista;
	}
}
