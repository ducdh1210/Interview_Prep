package CompanyQuestions.Epic;

/**
 * Created by ducdh1210 on 10/18/14.
 */

import java.lang.Math.*;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Spiral2DArray {
    static char[][] matrix = {
            {'i',	'l', 	'o', 	'v', 	'e' },
            {'d',	'i', 	'n', 	't', 	'e' },
            {'n', 	'e', 	'w', 	'e', 	'p' },
            {'a', 	'i', 	'v', 	'r', 	'i' },
            {'m',	'a', 	'x', 	'e', 	'c' } };

   /* static char[][] matrix = {
            {'i',	'l', 	'o', 	'v', 	},
            {'d',	'i', 	'n', 	't', 	 },
            {'n', 	'e', 	'w', 	'e', 	},
            {'a', 	'i', 	'v', 	'r', 	},
           };*/
    static List<Character> inverseSpiralList = new LinkedList<Character>();
    static int size = matrix.length;
    static int numLeft, numRight, numUp, numDown;
    static int cr, cc;

    public static void main(String[] args){
        spiral(matrix);
        System.out.println();

        numRight = numLeft = numUp = numDown = 0;
        cr = cc = 0;
        int maxElement = size * size;

        // if size is odd, from the center, go left --> down --> right --> up
        if (size % 2 == 1){
            cr = (int)Math.floor((double) size / 2);
            cc = cr;
            inverseSpiralList.add(new Character(matrix[cr][cc]));

            while (inverseSpiralList.size() <= maxElement){
                goLeft();
                if (cc == 0 && cr ==0) break;
                goDown();
                goRight();
                goUp();
            }
        }else{
            cr = size/2;
            cc = cr -1;
            inverseSpiralList.add(new Character(matrix[cr][cc]));

            while (inverseSpiralList.size() <= maxElement){
                goRight();
                goUp();
                goLeft();
                if (cc == 0 && cr ==0) break;
                goDown();
            }
        }
        Collections.reverse(inverseSpiralList);
        System.out.println(inverseSpiralList);
    }

    public static void goLeft(){
        if (cr >= 0){
            System.out.println("go left");
            numLeft = numRight + 1;
            if (numLeft == size) numLeft--;
            for (int numStep = numLeft; numStep > 0; numStep--){
                cc = cc - 1;
                inverseSpiralList.add(new Character(matrix[cr][cc]));
            }
        }
    }

    public static void goRight(){
        if (cr >= 0){
            System.out.println("go right");

            numRight = numLeft + 1;
            for (int numStep = numRight; numStep > 0; numStep--){
                cc = cc + 1;
                inverseSpiralList.add(new Character(matrix[cr][cc]));
            }
        }
    }

    public static void goUp(){
        if (cc >= 0){
            System.out.println("go up");

            numUp = numDown + 1;
            for (int numStep = numRight; numStep > 0; numStep--){
                cr = cr - 1;
                inverseSpiralList.add(new Character(matrix[cr][cc]));
            }
        }
    }

    public static void goDown(){
        if (cc >= 0){
            System.out.println("go down");
            numDown = numUp + 1;
            for (int numStep = numDown; numStep > 0; numStep--){
                cr = cr + 1;
                inverseSpiralList.add(new Character(matrix[cr][cc]));
            }
        }
    }

    static void spiral(char[][] mat) {
        int length = mat.length;
        int i=0, j;
        int count = 0;
        while(i < mat.length/2+1){
            i=count;
            j=count;
            // go left
            while(j<length){
                System.out.print(mat[i][j++]);
            }
            j--;
            // go down
            while(i<length-1){
                System.out.print(mat[++i][j]);
            }
            // go right
            while(j>count){
                System.out.print(mat[i][--j]);
            }
            // go up
            while(i>count+1){
                System.out.print(mat[--i][j]);
            }
            count++;
            length--;

        }

    }


}
