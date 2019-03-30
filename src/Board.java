public class Board {
    public static final int BOARD_HEIGHT = 20;
    public static final int BOARD_WIDTH = 10;
    private BlockColor[][] cells = new BlockColor[BOARD_HEIGHT][BOARD_WIDTH];
    private Block activeBlock;
    public Board(){
        //Cell board[][] = new Cell[BOARD_HEIGHT][BOARD_WIDTH];
        for(int i = 0;i<BOARD_HEIGHT;i++){
            for(int j= 0;j<BOARD_WIDTH;j++){
                //board[i][j] = new Cell(i,j,BlockColor.NO_COLOR);
                cells[i][j] = BlockColor.NO_COLOR;
            }
        }
    }
    public Block activeBlock(){
        return this.activeBlock;
    }
    public BlockColor blockAt(int x, int y){
        return cells[x][y];
    }
    public void clear(){
        for(int i = 0;i<BOARD_HEIGHT;i++){
            for(int j= 0;j<BOARD_WIDTH;j++){
                cells[i][j]=BlockColor.NO_COLOR;
            }
        }
        activeBlock = null;
    }
    public void blockLanded(){
        
    }
}
