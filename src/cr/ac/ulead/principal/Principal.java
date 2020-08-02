package cr.ac.ulead.principal;

import cr.ac.ulead.binaryTree.Tree;
import cr.ac.ulead.logic.Logic;
import cr.ac.ulead.presentacion.presentacion;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {

		int opcion = 0;
		Tree theTree = new Tree();
		presentacion presentacion = new presentacion();
		Logic logic = new Logic();


		do {

			opcion = presentacion.printMenu();
			logic.run(opcion);

		} while (opcion != 7);
	}
}