import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Board {

    private  final Random RANDOM;

    private final int height;

    private final int width;

    private String[][] board;

    private Queen queen;

    public Queen getQueen() {
        return queen;
    }

    public Coordinates getQueenCoordinates(Queen queen) {
        //this.queen = queen;
        return queen.getCoordinates();
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Board(int height, int width, Random random, Queen queen) {
        super();
        this.RANDOM = random;
        this.height = height;
        this.width = width;
        this.board = new String[height][width];
        this.queen = queen;
        int lastRowIndex = height - 1;
        int lastColumnIndex = width - 1;
        for (int row = 0; row < height; row++) {//initLevel();
            for (int column = 0; column < width; column++) {
                if(row == queen.getCoordinates().getRow() && column == queen.getCoordinates().getColumn()){
                    board[row][column] = "Q";
                }
                if (row == 0 || row == lastRowIndex || column == 0 || column == lastColumnIndex) {//walls
                    board[row][column] = "X"; //walls
                } else {
                    board[row][column] = " ";
                }
            }
        }

        //draw2DArray();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return height == board1.height && width == board1.width && RANDOM.equals(board1.RANDOM) && Arrays.equals(board, board1.board) && queen.equals(board1.queen);
    }

    public boolean myEquals(Object o, Queen queen) {
        return true;
    }

    public String boardToString() {
        String temp = "";
        for (int row = 1; row < height; row++) {
            for (int column = 1; column < width; column++) {
                if (!board[row][column].equals("X")) {
                    temp = temp.concat(board[row][column]);
                }
            }
            //System.out.println("temp: " + temp);
            //System.out.println("board[0][0]: " + board[1][4]);
        }
        return temp;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(RANDOM, height, width, queen);
        result = 31 * result + Arrays.hashCode(board);
        return result;
    }

    public void draw2DArray(Queen queen) throws InterruptedException {

        //System.out.println("draw");
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                Coordinates coordinatesToDraw = new Coordinates(row, column);
                if (coordinatesToDraw.isSame(queen.getCoordinates())) {
                //if (isCell(coordinatesToDraw, "Q")) {
                    System.out.print(queen.getMark());

                }else{
                    if(isCell(coordinatesToDraw, "Q")) {
                        System.out.print("Q");
                    }else{
                        System.out.print(getCell(coordinatesToDraw));
                        //System.out.print(coordinatesToDraw);
                    }
                    //System.out.print(queen.getMark());
                }
            }
            //Thread.sleep(1000);
            System.out.println();
        }

    }

    public void fillBoard(Board board, String fill, Queen queen) throws InterruptedException {

        //System.out.println("fill");
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                Coordinates coordinates = new Coordinates(row, column);//csak ez volt
                if(isCell(coordinates, "Q")) {
                    board.setCell(queen.getCoordinates(), "Q");
                }else
                //if (!isCell(coordinates, "Q") && !isCell(coordinates, "X") && coordinates.getRow() == (queen.getCoordinates().getRow())) {
                if (isCell(coordinates, " ") && coordinates.getRow() == (queen.getCoordinates().getRow())) {
                    board.setCell(coordinates, fill);
                }else
                if (isCell(coordinates, " ") && coordinates.getColumn() == (queen.getCoordinates().getColumn())) {
                    board.setCell(coordinates, fill);//fill ="*"
                }else

                //row-2 == column || row  + column == height-3-koordináta

                //if(row- coordinates.getRow() == column || row + column == height-1){
                //if(row -queen.getCoordinates().getRow() == column-queen.getCoordinates().getColumn()){
                if ( isCell(coordinates, " ") &&  (row == column + (queen.getCoordinates().getRow() - queen.getCoordinates().getColumn())
                        || row + (width - (queen.getCoordinates().getRow() + queen.getCoordinates().getColumn()) - 1) + column == height - 1)) {
                    board.setCell(coordinates, fill);
                }

            }

        }
        board.setCell(queen.getCoordinates(), "Q");
    }


    public String getCell(Coordinates coordinates) {

        return board[coordinates.getRow()][coordinates.getColumn()];
    }

    public String setCell(Coordinates coordinates, String fill) {

        return board[coordinates.getRow()][coordinates.getColumn()] = fill;
    }

    public boolean isCell(Coordinates coordinates, String cell) {//milyen cella van ott
        return cell.equals(board[coordinates.getRow()][coordinates.getColumn()]);
    }

    public Coordinates getRandomCoordinates() {
        Coordinates randomCoordinates;

        do {
            randomCoordinates = new Coordinates(RANDOM.nextInt(height), RANDOM.nextInt(width));

        } while ((!isCell(randomCoordinates, " ") && (!isCell(randomCoordinates, "Q"))));

        return randomCoordinates;
    }

    public void draw2DArray(){

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                System.out.print(board[row][column] );
            }
            System.out.println();
        }
        System.out.println("----------");
    }
    public boolean checkBoard(String toCheck){

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
               if(board[row][column] ==toCheck){
                   return true;
               }
            }
        }
        return false;
    }

    public int checkBoard2(String toCheck){
    int ctr = 0;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if(board[row][column] ==toCheck){
                    ctr++;
                }
            }
        }
        //System.out.println("Number of Q is: " + ctr);
        return ctr;
    }


}

