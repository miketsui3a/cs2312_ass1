public class OBlock extends Block {
    public OBlock(){
        super(new Cell(0,5,BlockColor.O_COLOR),
                new Cell(1,5,BlockColor.O_COLOR),
                new Cell(0,4,BlockColor.O_COLOR),
                new Cell(1,4,BlockColor.O_COLOR),'O',0);
    }
}
