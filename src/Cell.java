public class Cell{
    int row,col;
    BlockColor color;

    public Cell(int row,int col,BlockColor color){
        this.row=row;
        this.col=col;
        this.color=color;
    }

    public Cell(){
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public BlockColor getColor(){
        return this.color;
    }

    public void setRow(int row){
        this.row=row;
    }

    public void setCol(int col){
        this.col=col;
    }

    public void setColor(BlockColor color){
        this.color=color;
    }

    public void left(){
        this.col--;
    }

    public void right(){
        this.col++;
    }

    public void down(){
        this.row++;
    }

    public String toString(){
        return "("+this.row+","+this.col+","+this.color+")";
    }
}
