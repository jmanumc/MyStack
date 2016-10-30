import cmenu.Menu;
import mystack.Stack;

public class App {
	public static void main(String[] args) {
		boolean state = true;
		Menu menu = new Menu();
		
		menu.lnline();
		menu.center("PILA");
		menu.line();
		Stack app = new Stack(menu.inputInt("Inserta el tamanio de la pila"));

		do {
			menu.line();
			menu.center("MENU - " + (app.getCounter() + 1) + " de " + app.getSize() + " valores.");
			menu.line();
			menu.options("Insertar", "Imprimir", "Eliminar", "Salir");
			menu.line();
			int option = menu.inputInt("Seleciona una opcion");
			menu.line();

			switch (option) {
				case 1:
					int value = menu.inputInt("Inserte el nuevo valor");
					String response = app.insert(value);
					menu.line();
					menu.content(response);
					break;
				case 2:
					String responseArray[] = app.print();
					menu.arrayContent(responseArray);
					break;
				case 3:
					response = app.delete();
					menu.content(response);
					break;
				case 4:
					state = false;
					menu.center("CREATED BY JMANUEL");
					menu.line();
					break;
				default:
					menu.content("Opcion incorrecta. Intenta de nuevo.");
					break;
			}
		} while(state);
	}
}