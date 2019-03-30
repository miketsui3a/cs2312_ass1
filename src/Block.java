import java.lang.Math;
public abstract class Block {

    private Cell cells[]=new Cell[4];
    private char shape;
    private int status;

    public Block(Cell cells[],char shape,int status){
        this.cells=cells;
        this.shape=shape;
        this.status=status;
    }

    public Block(Cell c1, Cell c2, Cell c3, Cell c4,char shape,int status){
        this.cells[0] = c1;
        this.cells[1] = c2;
        this.cells[2] = c3;
        this.cells[3] = c4;
        this.shape=shape;
        this.status=status;
    }

    public Block(){

    }

    public Cell[] getCells(){
        return this.cells;
    }

    public char getShape(){
        return this.shape;
    }

    public int getStatus(){
        return this.status;
    }

    public void setShape(char shape){
        this.shape=shape;
    }

    public void setStatus(char status){
        this.status=status;
    }

    public void moveLeft(){
        for (int i=0;i<4;i++){
            this.cells[i].left();
        }
    }

    public void moveRight(){
        for (int i=0;i<4;i++){
            this.cells[i].right();
        }
    }

    public void moveDown(){
        for (int i=0;i<4;i++){
            this.cells[i].down();
        }
    }

    public void rotate(){
        if (this.getShape()=='I'){
            if (this.status==0){
                this.cells[0].setRow(this.cells[0].getRow()-1);
                this.cells[0].setCol(this.cells[0].getCol()+2);
                this.cells[1].setCol(this.cells[1].getCol()+1);
                this.cells[2].setRow(this.cells[2].getRow()+1);
                this.cells[3].setRow(this.cells[3].getRow()+2);
                this.cells[3].setCol(this.cells[3].getCol()-1);
            }else if(this.status==1){
                this.cells[0].setRow(this.cells[0].getRow()+2);
                this.cells[0].setCol(this.cells[0].getCol()+1);
                this.cells[1].setRow(this.cells[1].getRow()+1);
                this.cells[2].setCol(this.cells[2].getCol()-1);
                this.cells[3].setRow(this.cells[3].getRow()-1);
                this.cells[3].setCol(this.cells[3].getCol()-2);
            }else if(this.status==2){
                this.cells[0].setRow(this.cells[0].getRow()+1);
                this.cells[0].setCol(this.cells[0].getCol()-2);
                this.cells[1].setCol(this.cells[1].getCol()-1);
                this.cells[2].setRow(this.cells[2].getRow()-1);
                this.cells[3].setRow(this.cells[3].getRow()-2);
                this.cells[3].setCol(this.cells[3].getCol()+1);
            }else{
                this.cells[0].setRow(this.cells[0].getRow()-2);
                this.cells[0].setCol(this.cells[0].getCol()-1);
                this.cells[1].setRow(this.cells[1].getRow()-1);
                this.cells[2].setCol(this.cells[2].getCol()+1);
                this.cells[3].setRow(this.cells[3].getRow()+1);
                this.cells[3].setCol(this.cells[3].getCol()+2);
            }
        }else if(this.getShape()=='O'){
            return;
        }else{
            for (int i=0;i<4;i++){
                if(i==2){
                    continue;
                }else{
                    this.cells[i].setRow(cells[i].getRow()-cells[2].getRow());
                    this.cells[i].setCol(cells[i].getCol()-cells[2].getCol());
                    int rowTmp = this.cells[i].getRow();
                    int colTmp = this.cells[i].getCol();
                    this.cells[i].setRow((int)(rowTmp*Math.cos(Math.toRadians(-90))-colTmp*Math.sin(Math.toRadians(-90))));
                    this.cells[i].setCol((int)(rowTmp*Math.sin(Math.toRadians(-90))+colTmp*Math.cos(Math.toRadians(-90))));
                    this.cells[i].setRow(cells[i].getRow()+cells[2].getRow());
                    this.cells[i].setCol(cells[i].getCol()+cells[2].getCol());
                }
            }
        }
        this.status=(status+1)%4;
    }

    /*public Block randomBlock(){
        int tmp = (int)(Math.random()*7);
        int Status = 0;
        int colTmp = (int)(Math.random()*10);
        char shape='o';
        Block a;
        switch(tmp){
            case 0:{
                shape='I';
                cells[0] = new Cell(0,colTmp++,0);
                cells[1] = new Cell(0,colTmp++,0);
                cells[2] = new Cell(0,colTmp++,0);
                cells[3] = new Cell(0,colTmp,0);
                break;
            }
            case 1:{
                shape='J';
                cells[0] = new Cell(0,colTmp,1);
                cells[1] = new Cell(1,colTmp++,1);
                cells[2] = new Cell(1,colTmp++,1);
                cells[3] = new Cell(1,colTmp,1);
                break;
            }
            case 2:{
                shape='L';
                cells[0] = new Cell(1,colTmp,2);
                cells[1] = new Cell(0,colTmp+2,2);
                cells[2] = new Cell(1,colTmp-1,2);
                cells[3] = new Cell(1,colTmp+1,2);
                break;
            }
            case 3:{
                shape='O';
                cells[0] = new Cell(0,colTmp,3);
                cells[1] = new Cell(1,colTmp,3);
                cells[2] = new Cell(0,colTmp++,3);
                cells[3] = new Cell(1,colTmp,3);
                break;
            }
            case 4:{
                shape='S';
                cells[0] = new Cell(1,colTmp++,4);
                cells[1] = new Cell(0,colTmp,4);
                cells[2] = new Cell(1,colTmp++,4);
                cells[3] = new Cell(0,colTmp,4);
                break;
            }
            case 5:{
                shape='T';
                cells[0] = new Cell(1,colTmp++,5);
                cells[1] = new Cell(0,colTmp,5);
                cells[2] = new Cell(1,colTmp++,5);
                cells[3] = new Cell(0,colTmp,5);
                break;
            }
            case 6:{
                shape='Z';
                cells[0] = new Cell(0,colTmp++,5);
                cells[1] = new Cell(0,colTmp,5);
                cells[2] = new Cell(1,colTmp++,5);
                cells[3] = new Cell(1,colTmp,5);
                break;
            }
        }
        a = new Block(cells,shape,Status);
        return a;
    }*/
    public String toString(){
        return "[("+this.cells[2].getRow()+","+this.cells[2].getCol()+","+this.cells[2].getColor()+");"+
                "("+this.cells[0].getRow()+","+this.cells[0].getCol()+","+this.cells[0].getColor()+");"+
                "("+this.cells[1].getRow()+","+this.cells[1].getCol()+","+this.cells[1].getColor()+");"+
                "("+this.cells[3].getRow()+","+this.cells[3].getCol()+","+this.cells[3].getColor()+"):"+
                this.shape+","+this.status+"]";
    }
}
