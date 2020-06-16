import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Date;
import java.util.Stack;

public class MahJongBoard extends JPanel implements MouseListener {
    MahJongModel model;
    ImageIcon image;
    Tile selectedTile;
    Scroller undoScrollPane;
    boolean randomGame;


    public MahJongBoard(Scroller undoScrollPane){
        this(undoScrollPane, ((new Date()).getTime()%100000), true);
    }

    public MahJongBoard(Scroller undoScrollPane, long gameNumber, boolean randomGame){
        this.randomGame = randomGame;


        setLayout(null);
        setSize(1200,700);
        setOpaque(true);
        setBackground(new Color(102,104,255));
        this.undoScrollPane = undoScrollPane;


        //Backgroud inmage
        URL url = MahJongBoard.class.getResource("images/dragon_bg.png");
        image = new ImageIcon(url);



        model = new MahJongModel(gameNumber);

        //Add Tiles to the board
        add(model.tileArray[0][3][0]);

        for(int z = 4; z >= 0; z--){
            for(int y = 7; y >= 0; y--){
                for(int x = 0; x < 15; x++){
                    if(model.tileArray[x][y][z]!= null){
                        if(!(x ==0 && y == 3 && z == 0)) {
                           add(model.tileArray[x][y][z]);
                           model.positionTile(model.tileArray[x][y][z], x, y, z);
                           model.tileArray[x][y][z].addMouseListener(this);
                       }else{
                            model.positionTile(model.tileArray[x][y][z], x, y, z);
                            model.tileArray[x][y][z].addMouseListener(this);
                        }

                     }
                }
             }
        }



        setVisible(true);
    }

    public void undoLast(){
        Stack<Tile> undoTiles = undoScrollPane.getLastTiles();
        Tile t;
        int x;
        int y;
        int z;
        int size = undoTiles.size();
        for(int i = 0; i < size; i++){
            t = undoTiles.pop();
            x = t.getXPos();
            y = t.getYPos();
            z = t.getZPos();
            add(model.tileArray[x][y][z]);
            setComponentZOrder(model.tileArray[x][y][z], model.tileArray[x][y][z].zOrder);
            model.positionTile(model.tileArray[x][y][z], x, y, z);
            model.tileArray[x][y][z].addMouseListener(this);

            t.hidden = false;
        }
        repaint();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 175,75, this);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Tile clickedTile = (Tile) e.getSource();
        //System.out.println(" clicked");
        if(clickedTile == null){
            //System.out.println("it was null");
        }else if(model.isTileOpen(clickedTile) && !clickedTile.hidden  ){
            if(selectedTile == null){
                selectedTile = clickedTile;
                selectedTile.highlight(true);
                return;
            }
            if(selectedTile.matches(clickedTile)){
                //match found remove both
                clickedTile.hidden = true;
                selectedTile.hidden = true;
                selectedTile.highlight(false);

                clickedTile.zOrder = getComponentZOrder(clickedTile);
                selectedTile.zOrder = getComponentZOrder(selectedTile);

                undoScrollPane.addToUndo(selectedTile, clickedTile);
                selectedTile = null;

                this.repaint();

            }else{
                //Switch tile selection
                selectedTile.highlight(false);
                selectedTile = clickedTile;
                selectedTile.highlight(true);
            }


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
