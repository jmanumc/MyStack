package mystack;

/**
 * It creates and manages a stack of integers.
 *
 * @author  JManuelMc
 * @version 1.5, 13/10/16
 * @since   1.8
 */

public class Stack {
	private int size;
	private int stack[];
	private int counter;

	/**
	 * The class contructor.
	 *
	 * @param size the size of the stack.
	 */
	public Stack(int size) {
		this.size = size;
		this.counter = -1;
		this.stack = new int[size];
	}

	/**
	 * Getter for the attribute counter.
	 *
	 * @return the attribute counter
	 */
	public int getCounter() {
		return this.counter;
	}

	/**
	 * Getter for the attribute size.
	 *
	 * @return the attribute size
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Inserts a new value onto the stack.
	 *
	 * @param value  the value to be inserted in the stack
	 * @return       a response from state
	 */
	public String insert(int value) {
		if (!this.isFull()) {
			this.counter++;
			this.stack[this.counter] = value;
			return "Inserccion exitosa.";
		} else {
			return "Inserccion fallida. Pila llena.";
		}
	}
	
	/**
	 * Prints the stack.
	 *
	 * @return the stack
	 */
	public String[] print() {
		String[] response;

		if (!this.isEmpty()) {
			response = new String[this.counter + 1];

			for (int i = 0; i <= this.counter; i++) {
				response[i] = "[" + i + "] => " + this.stack[i];
			}
		} else {
			response = new String[1];
			response[0] = "Impresion fallida. Pila Vacia.";
		}

		return response;
	}
	
	/**
	 * Removes the last element of the stack.
	 *
	 * @return a response from state
	 */
	public String delete() {
		if (!this.isEmpty()) {
			this.stack[this.counter] = 0;
			this.counter--;
			return "Eliminacion exitosa.";
		} else {
			return "Eliminacion fallida. Pila vacia.";
		}
	}

	/**
	 * Check if the stack is empty.
	 *
	 * @return a response
	 */
	private boolean isEmpty() {
		if (this.counter == -1) return true;
		else return false;
	}

	/**
	 * Check if the stack is full.
	 *
	 * @return a response
	 */
	private boolean isFull() {
		int temp = this.counter + 1;

		if (temp >= this.size) return true;
		else return false;
	}
}