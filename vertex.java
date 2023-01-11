import java.util.ArrayList;

public class vertex {
    private int pred;
    private int topnum;
    private char letter;

    public ArrayList<vertex> neighbours = new ArrayList<>();

    public vertex(char letter) {
        this.letter = letter;
        this.pred = 0;
    }

    public int getPred() {
        return pred;
    }

    public int getTopnum() {
        return topnum;
    }

    public char getLetter() {
        return letter;
    }

    public ArrayList<vertex> getNeighbours() {
        return neighbours;
    }

    public void setPred(int pred) {
        this.pred = pred;
    }

    public void setTopnum(int topnum) {
        this.topnum = topnum;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setNeighbours(ArrayList<vertex> neighbours) {
        this.neighbours = neighbours;
    }
}
