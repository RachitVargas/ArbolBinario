package cr.ac.ulead.logic;

import cr.ac.ulead.binaryTree.Node;
import cr.ac.ulead.binaryTree.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class gestorData {

    public void leerDatos(ArrayList<Node> list) throws FileNotFoundException {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("d/MM/yyyy");
        list.clear();
        Scanner fileReader = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\Arbol" +
                "\\src\\cr\\ac\\ulead\\DataPersona.csv"));

        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String datos[] = currentLine.split(",");
            Persona persona = new Persona();
            persona.setNombre(datos[0]);
            persona.setApellido(datos[1]);
            LocalDate localDate = LocalDate.parse(datos[2], date);
            persona.setLocalDate(localDate);
            persona.setCedula(datos[3]);

            list.add(new Node(persona));
        }
        fileReader.close();
    }
}