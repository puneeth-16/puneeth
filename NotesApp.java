import java.io.*;
import java.util.Scanner;

public class NotesApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "notes.txt";
        int choice;

        do {
            System.out.println("\n*** Notes App ***");
            System.out.println("1. Write a new note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    writeNote(fileName, scanner);
                    break;
                case 2:
                    readNotes(fileName);
                    break;
                case 3:
                    System.out.println("you are exited sucessfully ");
                    break;
                default:
                    System.out.println("entered Invalid choice. Try again.");
            }

        } while (choice != 3);
    }
    public static void writeNote(String fileName, Scanner scanner) {
        System.out.println("Enter your note:");
        String note = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter(fileName, true); 
            writer.write(note + "\n");
            writer.close();
            System.out.println("Sorry not saved!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
    public static void readNotes(String fileName) {
        System.out.println("\n*** Your Notes ***");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean empty = true;

            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                empty = false;
            }

            reader.close();

            if (empty) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Write one note!");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}
  