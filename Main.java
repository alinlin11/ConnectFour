package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[6][7];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = " ";
            }
        }
        printGrid(array);
        int count = 0;
        boolean cont = true;

        while(cont) {
            if (count % 2 == 0) {
                chooseRed(array);
            }
            else {
                chooseYellow(array);
            }
            count++;
            printGrid(array);

            if(win(array, "R") || win(array, "Y") || isFull(array)) {
                cont = false;
                printGrid(array);
                if(win(array,"R"))
                    System.out.println("Red Player Wins!");
                if(win(array,"Y"))
                    System.out.println("Yellow Player Wins!");
                if(isFull(array))
                    System.out.println("Tie Game!");
            }

        }
    }


    public static void printGrid(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("| " + array[i][j]);
                if (j == array[i].length - 1)
                    System.out.print("|");

            }
            System.out.println();
        }

        System.out.println("---------------------");
        System.out.println();
    }

    public static void chooseRed(String[][] f) {
        Scanner input = new Scanner(System.in);
        System.out.println("Drop a red disk at column(0-6):");
        int in = input.nextInt();
        if(in > 6 || in < 0) {
            System.out.println("Not in range. Re-enter column.");
            in = input.nextInt();
        }

        for (int i = f.length - 1; i >= 0; i--) {
            if (f[i][in] == " ") {
                f[i][in] = "R";
                break;
            }
        }
    }

    public static void chooseYellow(String[][] f) {
        Scanner input = new Scanner(System.in);
        System.out.println("Drop a yellow disk at column(0-6):");
        int in = input.nextInt();

        if(in > 6 || in < 0) {
            System.out.println("Not in range. Re-enter column.");
            in = input.nextInt();
        }

        for (int i = f.length - 1; i >= 0; i--) {
            if (f[i][in] == " ") {
                f[i][in] = "Y";
                break;
            }
        }
    }

    public static boolean win(String[][] f, String color) {
        //left to right
        for(int i = 0; i < f.length; i++) {
            int count = 0;
            for(int j = 0; j < f[i].length; j++) {
                if(f[i][j] == color) {
                    count++;
                }

                else {
                    count = 0; }

                if(count == 4)
                    return true;

            }
        }

        //top to bottom
        for(int j = 0; j < 7; j++) {
            int count = 0;
            for(int i = 0; i < f.length; i++) {
                if(f[i][j] == color) {
                    count++;
                }

                else {
                    count = 0;
                }

                if(count == 4) {
                    return true;
                }
            }

        }

        //diagonal
        // top left to bottom right(\\\)
        //first half
        for(int k = 0; k <= 2; k++) {
            int count = 0;
            for (int i = 0, j = 3 + k; i <= 3 + k && j >= 0; i++, j--) {
                if (f[j][i] == color) {
                    count++;
                }
                else {
                    count = 0;
                }

                if(count == 4) {
                    return true;
                }

            }
        }

        //second half
        for(int k = 0; k <= 2; k++) {
            int count = 0;
            for (int i = 5, j = 1 + k; j <= 6 && i >= k; i--, j++) {
                    if(f[i][j] == color) {
                        count++;
                    }
                    else {
                        count = 0;
                    }

                    if(count == 4) {
                        return true;
                    }
            }
        }

        //top right to bottom left(///)
        //first half
        for(int k = 0; k <=2; k++) {
            int count = 0;
            for (int i = 2 - k, j = 0; i <= 5 && j <= 3 + k; i++, j++) {
                if(f[i][j] == color) {
                    count++;
                }
                else {
                    count = 0;
                }

                if(count == 4) {
                    return true;
                }
            }
        }

        //second half
        for(int k = 0; k <=2; k++) {
            int count = 0;
            for(int i = 0, j = 1 + k; i <= 5 - k && j <= 6; i++, j++) {
                if(f[i][j] == color) {
                    count++;
                }
                else {
                    count = 0;
                }

                if(count == 4) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isFull(String[][] f) {
        for(int i = 0; i < f.length; i++) {
            for(int j = 0; j < f[i].length; j++) {
                if(f[i][j] == " ")
                    return false;
            }
        }
        return true;
    }



    }









