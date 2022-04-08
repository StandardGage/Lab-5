package Lab5;

public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int rows, int columns){
        this.numRows = rows;
        this.numColumns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    public int getNumRows(){
        return this.numRows;
    }

    public int getNumColumns(){
        return this.numColumns;
    }

    public BoardSquare[][] getSquares(){
        return this.squares;
    }

    public boolean inBounds(int row, int column){
        boolean bounds = false;
        if(row >= 0 && column >= 0 && column < this.numColumns && row < this.numColumns){
            bounds = true;
        }
        return bounds;
    }

    private void setUpEmptyBoard(){
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                this.squares[i][j] = new BoardSquare("black");
            } //alternate colors?
        }
    }

    /* public BoardSquare findRandomEmptySpace(){ //is this supposed to be infinite?
    }
     */

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }



}
