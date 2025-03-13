import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class library {
    //Create the main code
    public static void main(String[] args) {
        //set up the scanner to be used to take inputs
        Scanner scanner = new Scanner(System.in);
        //create HashMap that will hold the Library Catalogue information
        HashMap<String, Map<String, Integer>> LibraryCatalogue = new HashMap<>();
        /* set up exit, create as false so that when exit is added as menu
        option it can be set up as a choice to make it true and exit the program
         */
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getInput(scanner);
            switch (choice) {
                case 0:
                    exit = true;
                    break;

                case 1:
                    addBook(scanner, LibraryCatalogue);
                    break;

                case 2:
                    BorrowBook (scanner, LibraryCatalogue); // Call the BorrowBook method
                    break;

                case 3:
                    bookreturn(scanner, LibraryCatalogue);
                    break;


                case 3:
                    bookreturn();
                    break;

                default:
                    System.out.println("Sorry, there is an error");
            }
        }
        scanner.close(); // close the scanner when done
    }

    public static void printMenu() {
        // setting up menu
        System.out.println("\n Administrator Interface");
        System.out.println("1. Add book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("0. Exit");
    }

    public static int getInput(Scanner scanner) {
        int choice;
        do {
            System.out.print("Enter menu option 0-3: ");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid choice, please try again");
            }
        } while (choice < 0 || choice > 3);

        return choice;
    }

    public static void addBook(Scanner scanner, HashMap<String, Map<String, Integer>> LibraryCatalogue) {
        System.out.println("Who is the author of the book?");
        // read the input from the question
        String authorname = scanner.nextLine();

        // Check if the author is already in the system
        Map<String, Integer> authorBooks = LibraryCatalogue.getOrDefault(authorName, new HashMap<>());

        System.out.println("What is the title of the book?");
        String bookTitle = scanner.nextLine();

        System.out.println("How many copies of the book are you adding?");
        int quantity = scanner.nextInt();

        authorBooks.put(bookTitle, quantity);
        libraryCatalogue.put(authorName, authorBooks);


        public static void BorrowBook (Scanner scanner, HashMap < String, Map < String, Integer >> LibraryCataloge){
            System.out.println("What is the title of the book you are borrowing?");
            //read the input from the question
            String inputBorrowBook = scanner.nextLine();

            boolean found = false;
            for (Map.Entry<String, Map<String, Integer>> entry : LibraryCatalogue.entrySet()) {
                Map<String, Integer> authorBooks = entry.getValue();
                if (authorBooks.containsKey(inputBorrowBook)) {
                    found = true;
                    int currentQuantity = authorBooks.get(inputBorrowBook);
                    if (currentQuantity > 0) {
                        authorBooks.put(inputBorrowBook, currentQuantity - 1);
                        System.out.println("You have checked out the book!");
                    } else {
                        System.out.println("Sorry, this book is currently not available.");
                    }
                    break;

                }
            }
        }
    }
}
