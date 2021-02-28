package Saper;

import java.util.Scanner;

public class Saper {
    String[][] fieldArr = new String[10][10];
    String[][] bombArr = new String[10][10];
    final String EMPTY_CELL = "|_|";
    final String BOMB_CELL = "|o|";
    final String CLOSE_CELL = "|*|";
    public Saper(){

        for (int i = 0; i < fieldArr.length; i++) {
            for (int j = 0; j < fieldArr[i].length; j++) {
                int val = (int)(Math.random()*3);
                if(val==0){
                    bombArr[i][j] = BOMB_CELL;
                }
                else{
                    bombArr[i][j] = EMPTY_CELL;
                }
            }
        }
        for (int i = 0; i < fieldArr.length; i++) {
            for (int j = 0; j < fieldArr[i].length; j++) {
                fieldArr[i][j] = CLOSE_CELL;
            }
        }
        printArr(fieldArr);
        System.out.println("\nBomb array:");
        printArr(bombArr);
        saper(0);

        /*
        bombArr[0][2] = BOMB_CELL;
        bombArr[1][2] = BOMB_CELL;
        bombArr[2][0] = BOMB_CELL;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (bombArr[i][j] != BOMB_CELL) {
                    bombArr[i][j] = EMPTY_CELL;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fieldArr[i][j] = CLOSE_CELL;
            }
        }
        printArr(fieldArr);
        saper(0);

         */
    }


    public void saper(int countBomb) {
        System.out.println("Введите координаты поля:");
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        if (bombArr[x][y].equals(BOMB_CELL)) {
            printArr(bombArr);
            System.out.println("You loose!");
        }
        else if (notEnd()) {
            bombFind2(x, y, 0);
            printArr(fieldArr);
            fieldArr[x][y] = " " + countBomb + " ";
            saper(0);
        }
        else {
            System.out.println("You win!");
            printArr(fieldArr);
        }
    }
    public void bombFind2(int x, int y, int countBomb) {
        if(isVisited(x,y)){
            return;
        }
        if(containsBomb(x,y)){
            return;
        }
        fieldArr[x][y] = EMPTY_CELL;
        //идем влево
        int x1 = x-1;
        int y1 = y;
        if(isCellExist(x1,y1)) {
            bombFind2(x1, y1, countBombCell(countBomb, x1, y1));
        }

        //идем вверх
        x1 = x;
        y1 = y - 1;
        if(isCellExist(x1,y1)) {
            bombFind2(x1, y1, countBombCell(countBomb, x1, y1));
        }

        //идем вправо
        x1 = x+1;
        y1 = y;
        if(isCellExist(x1,y1)) {
            bombFind2(x1, y1, countBombCell(countBomb, x1, y1));
        }

        //идем вниз
        x1 = x;
        y1 = y + 1;
        if(isCellExist(x1,y1)) {
            bombFind2(x1, y1, countBombCell(countBomb, x1, y1));
        }
    }

//    private boolean isFar (int x, int y) {
//       // return
//    }

    private boolean isVisited(int x, int y){
        return fieldArr[x][y].equals(EMPTY_CELL);
    }

    //возвращает true если ячейка существует
    private  boolean isCellExist(int x, int y){
        return isCoordExist(x) && isCoordExist(y);
    }

    //Возвращает true если координата существует
    private  boolean isCoordExist(int x){
        return x >= 0 && x < fieldArr.length;
    }

    //возвращает true, если в ячейке есть мина
    private  boolean containsBomb(int x, int y){
        return bombArr[x][y].equalsIgnoreCase("|o|");
    }

    private boolean notEnd () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fieldArr[i][j].equals(CLOSE_CELL) && !bombArr[i][j].equals(BOMB_CELL)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int countBombCell (int count, int x, int y) {
        if (bombArr[x][y].equals(BOMB_CELL)) {
            count++;
        }
        return count;
    }

    public void printArr (String[][] arr) {
        for (int i = 0; i < fieldArr.length; i++) {
            for (int j = 0; j < fieldArr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    /*public  String[][] bombFind(int x, int y, int count, int countBomb) {
        if ((count == 0 || count == 8 || count == 9) && bombArr[x][y] != "|o|" && x >= 1 && y >= 0) {
            fieldArr[x][y] = "|_|";
            x--;
            count++;
            return bombFind(x, y, count, countBomb);
        }
        else if (count == 1  && bombArr[x][y] != "|o|" && (x >= 0 && y >= 1)) {
            fieldArr[x][y] = "|_|";
            y--;
            count++;
            return bombFind(x, y, count, countBomb);
        }
        else if ((count >= 2 && count < 5) && bombArr[x][y] != "|o|" && x >= 0 && y >= 0) {
            fieldArr[x][y] = "|_|";
            x++;
            count++;
            return bombFind(x, y, count, countBomb);
        }
        else if ((count >=5 && count <= 7) && bombArr[x][y] != "|o|" && x >= 0 && y >= 0) {
            fieldArr[x][y] = "|_|";
            y++;
            count++;
            return bombFind( x, y, count, countBomb);
        }
        else if (bombArr[x][y] == "|o|" && count <= 9){
            fieldArr[x][y] = "|*|";
            count++;
            countBomb++;
            return bombFind(x, y, count, countBomb);
        }
        return fieldArr;
    }*/
}
