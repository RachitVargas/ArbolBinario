package cr.ac.ulead.logic;

import cr.ac.ulead.binaryTree.Node;
import cr.ac.ulead.binaryTree.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class gestorData {


    public static void inserPersonatInCsv(Persona persona) throws IOException {

        if (Files.lines(
                Paths.get("C:\\Users\\User\\IdeaProjects\\BinaryTree" +
                        "\\src\\cr\\ac\\ulead\\DataPersona.csv"))
                .count() != 0) {
            Files.write(
                    Paths.get("C:\\Users\\User\\IdeaProjects\\" +
                            "BinaryTree\\src\\cr\\ac\\ulead\\DataPersona.csv"),
                    ("\r\n" + persona.toString()).getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.write(
                    Paths.get("C:\\Users\\User\\IdeaProjects\\" +
                            "BinaryTree\\src\\cr\\ac\\ulead\\DataPersona.csv"),
                    persona.toString().getBytes(), StandardOpenOption.APPEND);
        }
    }

    public void leerDatos(ArrayList<Node> list) throws FileNotFoundException {
        list.clear();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Scanner fileReader = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\" +
                "BinaryTree\\src\\cr\\ac\\ulead\\DataPersona.csv"));

        while(fileReader.hasNextLine()){
            String currentLine = fileReader.nextLine();
            String datos[] = currentLine.split(",");
            Persona persona = new Persona();
            persona.setNombre(datos[0]);
            persona.setApellido(datos[1]);
            LocalDate datos2 = LocalDate.parse(datos[2], date);
            persona.setLocalDate(datos2);
            persona.setCedula(datos[3]);

            list.add(new Node(persona));
        }
        fileReader.close();
    }
}