//Task1______________________________________________________________________
//Task2______________________________________________________________________
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Theatre {

    //Create a Scanner object to read user input
    public static Scanner input = new Scanner(System.in);
    public static int[] row1 = new int[12];
    public static int[] row2 = new int[16];
    public static int[] row3 = new int[20];


    public static void main(String[] args) {
        //Initialize the seats array with the required number of seats
        int[][] seats = new int[3][]; //3 rows are available

        seats[0] = new int[12]; //First row has 12 seats
        seats[1] = new int[16]; //Second row has 16 seats
        seats[2] = new int[20]; //Third row has 20 seats

        //Initialize every seat to be free (0)
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 0;
            }
        }


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the New Theatre!");
            System.out.println("-----------------");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.print("- - - - - - - - - - - - - - - - - - - - - \nEnter option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Thank you for using our Theatre Reservation System!");
                    System.exit(0);
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    list_available_seats();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    print_ticket_info();
                    break;
                case 8:
                    sort_tickets_by_price();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("---------------------------------");
            }
        }
    }


    public static void buy_ticket() {
        Scanner input = new Scanner(System.in);


        System.out.print("Please enter the row number (1-3): ");
        int rowNumber = input.nextInt();

        int[] rowArray = null;

        switch (rowNumber) {
            case 1:
                rowArray = row1;
                break;
            case 2:
                rowArray = row2;
                break;
            case 3:
                rowArray = row3;
                break;
            default:
                System.out.print("Invalid row number, please try again");
                return;
        }

        System.out.print("Please choose a seat number (1-" + rowArray.length + "): ");
        int seat = input.nextInt();

        if (seat < 1 || seat > rowArray.length) {
            System.out.print("Invalid seat number, please try again. ");
            return;
        }

        if (rowArray[seat - 1] == 1) {
            System.out.println("Sorry, This seat is already reserved. ");
            return;
        } else {
            rowArray[seat - 1] = 1;
        }
    }


    public static void print_seating_area() {
                System.out.println("     ***********");
                System.out.println("     *  STAGE  *");
                System.out.println("     ***********");

                System.out.println();
                System.out.print("    ");
                for (int i = 0; i < row1.length; i++) {
                    if (i == 6) {
                        System.out.print(" ");
                    }
                    if (row1[i] == 0) {
                        System.out.print("O");
                    } else {
                        System.out.print("X");
                    }
                }

                System.out.println();
                System.out.print("  ");
                for (int i = 0; i < row2.length; i++) {
                    if (i == 8) {
                        System.out.print(" ");
                    }
                    if (row2[i] == 0) {
                        System.out.print("O");
                    } else {
                        System.out.print("X");
                    }
                }

                System.out.println();
                for (int i = 0; i < row3.length; i++) {
                    if (i == 10) {
                        System.out.print(" ");
                    }
                    if (row3[i] == 0) {
                        System.out.print("O");
                    }else {
                        System.out.print("X");
                    }
                }
                System.out.println();
            }


    public static void cancel_ticket() {
        System.out.print("Please choose a row number (1-3): ");
        int row = input.nextInt();
        int[] rowArray = new int[0];
        if (row == 1) {
            rowArray = row1;
        } else if (row == 2) {
            rowArray = row2;
        } else if (row == 3) {
            rowArray = row3;
        } else {
            System.out.println("Invalid row number, Please try again.");
            return;
        }

        System.out.print("Please choose a seat number (1-" + rowArray.length + "): ");
        int seat = input.nextInt();
        if (seat < 1 || seat > rowArray.length) {
            System.out.println("Invalid seat number, Please try again.");
            return;
        }

        //Checking whether the seat is already free
        if (rowArray[seat - 1] == 0) {
            System.out.println("Seat is already available, There's is no need to cancel the seat.");
            return;
        }

        //Cancelling the ticket
        rowArray[seat - 1] = 0;
        System.out.println("Successfully cancelled the ticket. ");
    }

    private static void list_available_seats() {
        String row1_seats = "Available seats in row 1: ";
        String row2_seats = "Available seats in row 2: ";
        String row3_seats = "Available seats in row 3: ";

        //Checking available seats in row 1
        for (int i = 0; i <row1.length; i++) {
            if (row1[i] == 0) {
                row1_seats += (i+1) + ",";
            }
        }
        System.out.println(row1_seats.substring(0, row1_seats.length() -1));

        //Checking available seats in row 2
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                row2_seats += (i+1) + ",";
            }
        }
        System.out.println(row2_seats.substring(0, row2_seats.length()-1));

        //Checking available seats in row 3
        for (int i = 0; i <row3.length; i++) {
            if (row3[i] == 0) {
                row3_seats += (i+1) + ",";
            }
        }
        System.out.println(row3_seats.substring(0, row3_seats.length()-1));
    }


    private static void save() {
        try {
            FileWriter writer = new FileWriter("file.txt");

            //Write the state of row1 to the file
            for (int i = 0; i < 12; i++) {
                writer.write(row1[i] + " ");
            }
            writer.write("\n");

            //Write the state of row2 to the file
            for (int i = 0; i < 16; i++) {
                writer.write(row2[i] + " ");
            }
            writer.write("\n");

            //Write the state of row3 to the file
            for (int i = 0; i < 20; i++) {
                writer.write(row3[i] + " ");
            }
            writer.write("\n");

            writer.close();
            System.out.println("Data saved to file. ");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data to file. ");
            e.printStackTrace();
        }
    }


    private static void load() {
        try {
            File file = new File("file.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void print_ticket_info() {
        // To be implemented
    }

    private static void sort_tickets_by_price() {
        // To be implemented
    }
}