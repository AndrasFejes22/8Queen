import java.util.Objects;

public class Queen {

    private String mark;

    private Coordinates coordinates;

    private Board board;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return mark.equals(queen.mark) && coordinates.equals(queen.coordinates) && board.equals(queen.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, coordinates, board);
    }

    /**
     * @param mark
     * @param coordinates

     */
    public Queen(String mark, Coordinates coordinates) {
        super();
        this.mark = mark;
        this.coordinates = coordinates;
        //this.board = board;

    }


    public String getMark() {
        return mark;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }



    public void setMark(String mark) {
        //ellenőrzés
        this.mark = mark;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
