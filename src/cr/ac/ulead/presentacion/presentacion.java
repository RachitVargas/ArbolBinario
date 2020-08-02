package cr.ac.ulead.presentacion;

import cr.ac.ulead.binaryTree.Persona;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class presentacion {

    private Scanner input;
    private PrintStream output;


    public presentacion() {
        this.input = new Scanner(System.in);
        this.output = new PrintStream(System.out);
    }


    public int printMenu() {
        output.println("Bienvenido al Arbol Binario de Personas");
        output.println("Por favor elija una opcion");
        output.println("1. Insertar persona");
        output.println("2. Leer las personas desde un archivo de texto separado por comas");
        output.println("3. Imprimir el árbol en IN-ORDER");
        output.println("4. Imprimir un árbol en PRE-ORDER");
        output.println("5. Imprimir un árbol en POST-ORDER");
        output.println("6. Mostrar arbol binario");
        output.println("7. Salir");
        return Integer.parseInt(input.nextLine());
    }

    public void error() {
        output.println("Lo sentimos, ha ocrrido un error!");
    }

    public void gracias() {
        System.out.println("Muchas gracias!");
    }

    public Persona getPersona() {

        Persona persona = new Persona();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("d/MM/yyyy");
        output.println("Ingrese el nombre");
        persona.setNombre(input.nextLine());
        output.println("Ingrese el apellido");
        persona.setApellido(input.nextLine());
        output.println("Ingrese la fecha de nacimiento (CON ESTRICTO FORMATO: dd/mm/aaaa)");
        LocalDate localDate = LocalDate.parse(input.nextLine(), date);
        persona.setLocalDate(localDate);
        output.println("Ingrese la cédula (CON ESTRICTO FORMATO: 123456789, SIN GUION)");
        persona.setCedula(input.nextLine());

        output.println("La persona se registró exitosamente ✔");

        return persona;
    }
}