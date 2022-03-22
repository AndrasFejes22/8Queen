import java.util.*;
import java.util.stream.Stream;

public class EightQueenMain {

    static Random RANDOM = new Random();
    static int ctr = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> mySetofResults = new HashSet<String>() ;
        int x = 0;
        while(true) {
            x ++;
        Coordinates queenCoordinates = new Coordinates(1,4);
        Queen queen= new Queen("Q", queenCoordinates);
        Board board = new Board(10, 10, RANDOM, queen);
        //Coordinates queenCoordinates;




        //Coordinates queenCoordinates = new Coordinates(1,4);
        //for(int i = 0; i <= 8; i++) {
        //int ctr = 0;

                while (board.checkBoard2("Q") != 8) {
                    //setterek
                    queen.setCoordinates(board.getRandomCoordinates());
                    //queenCoordinates = new Coordinates(1,4);
                    //queen= new Queen("Q", queenCoordinates);
                    board = new Board(10, 10, RANDOM, queen);
                    //board.getQueenCoordinates(queen);



                    while (board.checkBoard(" ")) {//board.checkBoard()
                    //while (board.checkBoard2("Q") != 8) {//board.checkBoard()

                        queenCoordinates = board.getRandomCoordinates();

                        queen = new Queen("Q", queenCoordinates);
                        ctr++;
                        //board = new Board(10, 10, RANDOM, queen);

                        //board.fillBoard(board, "*", queen);

                        //board.draw2DArray(queen);

                        //board = new Board(10, 10, RANDOM, queen);

                        //System.out.println("----------");

                        board.fillBoard(board, "*", queen);

                        //board = new Board(10, 10, RANDOM, queen);

                        //board.draw2DArray(queen);
                        //System.out.println("ctr: " + ctr);
                        board.checkBoard2("Q");

                        //System.out.println("Number of Q is: " + board.checkBoard2("Q"));
                        //System.out.println("Set: " + mylist);

                        board.boardToString();

                    }
                    //mySetofResults.add(board);

                }

                if(board.checkBoard2("Q") == 8){

                    mySetofResults.add(board.boardToString());
                    //System.out.println("Print board in if statement: ");
                    board.draw2DArray();
                }
                System.out.println("x size: " + x);
                if(x == 400){
                    break;
                }

            }//legkülső while


        System.out.println("Set size: " + mySetofResults.size());

        //if(board.checkBoard2("Q") == 8){
           // mylist.add(board.getBoard());
        //}

        //System.out.println("..........");
        //System.out.println("Print board: ");

        //Stream<Board> stream = mySetofResults.stream();

        //stream.forEach((element) -> { (element.draw2DArray()); });
        //stream.forEach(Board::draw2DArray);

        //board.draw2DArray();
            //}while (ctr != 8);
        //System.out.println("ctr: " + ctr);
        /*
        System.out.println(queenCoordinates.getRow());
        System.out.println(queen.getCoordinates().getColumn());

        /////////////////////////////////////////////////////////

        queenCoordinates = board.getRandomCoordinates();

        Queen queen2 = new Queen("Q", queenCoordinates, board);

        board.draw2DArray(board, queen2);

        board.fillBoard(board, "*", queen2);

        board.draw2DArray(board, queen2);

        System.out.println(queenCoordinates.getRow());
        System.out.println(queen.getCoordinates().getColumn());
        */
    }
}
