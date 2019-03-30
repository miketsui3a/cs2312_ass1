import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        /*Cell cells[] = new Cell[4];
        cells[2] = new Cell(0,4,5);
        cells[0] = new Cell(0,3,5);
        cells[1] = new Cell(0,5,5);
        cells[3] = new Cell(1,4,5);

        Block a = new Block(cells,'T',0);*/
        Block a = new Block();
        a = a.randomBlock();
        System.out.println("Initialization:");
        System.out.println("The current block is: "+a.toString());

        while(true){
            System.out.print("Next move: ");
            Scanner input = new Scanner(System.in);
            char c = input.next().charAt(0);
            switch(c){
                case 'a':{
                    a.moveLeft();
                    System.out.println("The current block is: "+a.toString());
                    break;
                }
                case 'd':{
                    a.moveRight();
                    System.out.println("The current block is: "+a.toString());
                    break;
                }
                case 's':{
                    a.moveDown();
                    System.out.println("The current block is: "+a.toString());
                    break;
                }
                case 'w':{
                    a.rotate();
                    System.out.println("The current block is: "+a.toString());
                    break;
                }
                case 'q':{
                    System.out.println("Terminate!");
                    return;
                }
            }
        }
    }
}
