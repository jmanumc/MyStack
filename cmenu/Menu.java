package cmenu;

import java.util.Scanner;

/**
 * Class to make a console menu.
 *
 * @since 2016-10-02
 * @author JManuelMc
 * @version 1.5
 */

public class Menu {
	private int sizeline;
	private Scanner input = new Scanner(System.in);

	public Menu() {
		this.sizeline = 50;
	}

	public Menu(int sizeline) {
		this.sizeline = sizeline;
	}

	/**
	 * Draw a line.
	 *
	 * @return void
	 */
	public void line() {
		System.out.print("+");
		this.segment(this.sizeline - 2);
		System.out.println("+");
	}

	/**
	 * Draw a line with a jump line at firts.
	 *
	 * @return void
	 */
	public void lnline() {
		System.out.print("\n");
		this.line();
	}

	/**
	 * Show content.
	 *
	 * @param String value
	 * @return void
	 */
	public void content(String value) {
		System.out.print("| " + value);
		this.spaces(value.length() + 4);
		System.out.println(" |");
	}

	/**
	 * Show content with a jump line at first.
	 *
	 * @param String value
	 * @return void
	 */
	public void lncontent(String value) {
		System.out.print("\n");
		this.content(value);
	}

	/**
	 * Show content.
	 *
	 * @param int number
	 * @return void
	 */
	public void content(int number) {
		this.content(Integer.toString(number));
	}

	/**
	 * Show content focused.
	 *
	 * @param String value
	 * @return void
	 */
	public void center(String value) {
		int x = (this.sizeline - value.length()) - 2;
		int y = x / 2;

		System.out.print("| ");

		for (int i = 1; i < y; i++) {
			System.out.print(" ");
		}
			
		System.out.print(value);

		for (int i = 1; i < y; i++) {
			System.out.print(" ");
		}

		if ((value.length() % 2) == 0) {
			System.out.println(" |");
		} else {
			System.out.println("  |");
		}
	}

	/**
	 * Show content focused.
	 *
	 * @param int number
	 * @return void
	 */
	public void center(int number) {
		this.center(Integer.toString(number));
	}

	/**
	 * Request whole type values.
	 *
	 * @param String message
	 * @return int
	 */
	public int inputInt(String message) {
		int value = 0;
		boolean error = true;
		message = message + ": ";

		do {
			try {
				System.out.print("| ");
				System.out.print(message);
				value = this.input.nextInt();
				error = false;
			} catch (Exception e) {
				this.line();
				this.content("Inserccion Fallida. Intenta de nuevo.");
				this.line();
				input.next();
			}
		} while(error);

		return value;
	}

	/**
	 * Show a series of options.
	 *
	 * @param String[] options
	 * @return void
	 */
	public void options(String... options) {
		for (int i = 0; i < options.length; i++) {
			System.out.print("| " + (i + 1) + ") " + options[i]);

			this.spaces(options[i].length() + 7);

			System.out.println(" |");
		}
	}

	/**
	 * Show the content of a array.
	 *
	 * @param String[] array
	 * @return void
	 */
	public void arrayContent(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("| " + array[i]);

			this.spaces(array[i].length() + 4);

			System.out.println(" |");
		}
	}

	/**
	 * Show the content specific of a array.
	 *
	 * @param String[] array
	 * @param int start
	 * @param int counter
	 * @return void
	 */
	public void arrayContent(String[] array, int start, int counter) {
		for (int i = 0; i <= counter; i++) {
			if (start >= array.length) start = 0;

			System.out.print("| " + array[start]);

			this.spaces(array[start].length() + 4);

			System.out.println(" |");

			start++;
		}
	}

	/**
	 * Draw a blank line.
	 *
	 * @return void
	 */
	public void linefeed() {
		System.out.print("| ");
		this.spaces(4);
		System.out.println(" |");
	}

	/**
	 * Clear the console. 
	 *
	 */
	public void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Draws blanks.
	 *
	 * @param int initial
	 * @return void
	 */
	public void spaces(int initial) {
		for (int i = initial; i < this.sizeline; i++) {
			System.out.print(" ");
		}	
	}

	/**
	 * Draws segments.
	 *
	 * @param int x
	 * @return void
	 */
	public void segment(int x) {
		for (int i = 1; i <= x; i++) {
			System.out.print("-");
		}	
	}
}