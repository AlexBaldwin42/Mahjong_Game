import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Scroller extends JScrollPane {
    private	static	Dimension	size = new Dimension(Tile.sideLength + Tile.depth,
            Tile.sideLength + Tile.depth);

    private	JPanel[]	discard = new JPanel[2];
    private Stack<Tile> undoStack = new Stack<Tile>();
    //private	Stack<Tile>	redoStack = new Stack<Tile>();		// optional
    private		int		width = Tile.sideLength + Tile.depth+10;
    private		int		height = Tile.sideLength + Tile.depth+6;
    private		int		count = 0;

    public Scroller()
    {
        setPreferredSize(new Dimension((width+10)*2, 0));
        setBorder(BorderFactory.createRaisedBevelBorder());

        discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[0].setPreferredSize(new Dimension(width, height));
        discard[1].setPreferredSize(new Dimension(width, height));

        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel	panel = new JPanel(new BorderLayout());
        setViewportView(panel);

        panel.add(discard[0], BorderLayout.WEST);
        panel.add(discard[1], BorderLayout.EAST);


        discard[0].setBackground(new Color(120,150,255));
        discard[1].setBackground(new Color(120,150,255));
        panel.setBackground(new Color(102,104,255));
    }

    public void addToUndo(Tile t1, Tile t2)
    {
        undoStack.push(t1);
        undoStack.push(t2);

        Dimension	size = new Dimension(width, ++count * height );
        discard[0].setPreferredSize(size);
        discard[1].setPreferredSize(size);


        discard[0].add(t1);
        discard[1].add(t2);

        Rectangle	r = new Rectangle(0, count * height, width+6, height );
        getViewport().scrollRectToVisible(r);



        revalidate();
        repaint();
    }

    public void undoLast(){

    }
    public void undoAll(){

    }
    public boolean hasTiles(){
        return !undoStack.empty();
    };


    public Stack<Tile> getLastTiles() {
        Stack<Tile> output = new Stack<Tile>();
        Tile t2;
        Tile t1 = undoStack.pop();
        discard[1].remove(t1);
        t2 = undoStack.pop();
        discard[0].remove(t2);
        count--;
        output.push( t2);
        output.push( t1);
        repaint();
        return output;
    }
}
