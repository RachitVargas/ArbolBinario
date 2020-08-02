package cr.ac.ulead.logic;

import cr.ac.ulead.binaryTree.Node;
import cr.ac.ulead.binaryTree.Persona;
import cr.ac.ulead.binaryTree.Tree;
import cr.ac.ulead.presentacion.presentacion;

import java.io.IOException;
import java.util.ArrayList;

public class Logic {

    presentacion presentacion;
    Tree tree;
    ArrayList<Node> list = new ArrayList<>();
    private Node root;
    gestorData gestor;
    Persona persona;
    boolean validacion = true;

    public Logic() {
        this.presentacion = new presentacion();
        this.tree = new Tree();
        this.root = null;
        this.gestor = new gestorData();
        this.persona = new Persona();
    }

    public void run(int opcion) throws IOException {

        switch (opcion) {

            case 1:
                persona = presentacion.getPersona();
                tree.insert(persona);
                break;

            case 2:

                if (validacion) {
                    gestor.leerDatos(list);
                    for (int i = 0; i < list.size(); i++) {
                        tree.insert(list.get(i).data);
                    }
                    validacion = false;
                } else {
                    System.out.println("Lo sentimos, ya leeiste los datos del archivo csv");
                }

                break;

            case 3:
                tree.traverse(opcion);
                break;

            case 4:
                tree.traverse(opcion);
                break;

            case 5:
                tree.traverse(opcion);
                break;

            case 6:
                tree.displayTree();
                break;

            case 7:
                this.presentacion.gracias();
                break;

            default:
                this.presentacion.error();
                break;

        }

    }
}