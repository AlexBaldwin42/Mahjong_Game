import	java.awt.*;
import java.awt.geom.Rectangle2D;
import	javax.swing.*;
public class Tile extends JPanel
{
	private Dimension dim = new Dimension();
	protected static int sideLength = 75;
	protected static int depth = 16;
	public boolean hidden = false;
	private boolean selected = false;
	public int zOrder;

	private int gameX;
	private int gameY;
	private int gameZ;

	private static Rectangle2D rect;

	private static int[] leftX;
	private static int[] leftY;
	private static int[] bottomX;
	private static int[] bottomY;
	private static Polygon leftPoly;
	private static Polygon bottomPoly;


	private static int[] leftBotX;
	private static int[] leftBotY;
	private static int[] bottomBotX;
	private static int[] bottomBotY;
	private static Polygon leftBotPoly;
	private static Polygon bottomBotPoly;

	private static GradientPaint gradGreen;
	private static GradientPaint gradWhite;
	private static GradientPaint gradSelected;

	static {
		rect = new Rectangle2D.Double(depth,0,sideLength, sideLength);

		leftX = new int[]{depth,depth/2,depth/2,depth};
		leftY = new int[]{0,depth/2,depth/2 + sideLength,sideLength};
		leftPoly = new Polygon(leftX, leftY,4);

		bottomX= new int[]{depth/2,depth/2 + sideLength,depth+ sideLength,depth};
		bottomY = new int[]{depth/2+sideLength, depth/2+sideLength,sideLength,sideLength};
		bottomPoly = new Polygon(bottomX, bottomY, 4);

		leftBotX = new int[]{0,0,depth/2,depth/2};
		leftBotY = new int[]{depth,depth + sideLength,depth/2 + sideLength,depth/2};
		leftBotPoly = new Polygon(leftBotX, leftBotY,4);

		bottomBotX = new int[]{0,sideLength,depth/2 + sideLength,depth/2};
		bottomBotY = new int[]{depth + sideLength,depth + sideLength,depth/2 + sideLength,depth/2 + sideLength};
		bottomBotPoly = new Polygon(bottomBotX, bottomBotY, 4);


		gradGreen = new GradientPaint(0,0,Color.WHITE, sideLength+depth,sideLength+depth, new Color(31,148,1));
		gradWhite = new GradientPaint(0,0,new Color(245,195,144), sideLength+depth,sideLength+depth, Color.WHITE);
		gradSelected = new GradientPaint(0,0,new Color(191,151,111), sideLength+depth,sideLength+depth, new Color(209,209,209));
	}

	public Tile(){
		//+1 to account for line circleWidth
		dim.setSize(sideLength+depth+1,sideLength+depth+1);
		setOpaque(false);
		setSize(sideLength+depth+1,sideLength+depth+1);

	}
	public void setXYZ(int x, int y, int z){
		gameX = x;
		gameY = y;
		gameZ = z;
	}

	public int getXPos(){
		return gameX;
	}
	public int getYPos(){
		return gameY;
	}
	public int getZPos(){
		return gameZ;
	}
	static {

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		var g2 = (Graphics2D) g;

		if(selected){
			g2.setPaint(gradSelected);
		}else{
			g2.setPaint(gradWhite);
		}

		g2.fill(rect);

		g.fillPolygon(bottomPoly);
		g.fillPolygon(leftPoly);

		g2.setPaint(gradGreen);
		g.fillPolygon(bottomBotPoly);
		g.fillPolygon(leftBotPoly);

		g2.setPaint(Color.BLACK);
		g2.draw(rect);
		g2.drawPolygon(leftPoly);
		g2.drawPolygon(bottomPoly);
		g2.drawPolygon(leftBotPoly);
		g2.drawPolygon(bottomBotPoly);

	}

	@Override
	public Dimension getPreferredSize() {
		//return super.getPreferredSize();
		return dim;
	}

	public void highlight(boolean b){
		selected = b;
		this.repaint();
	}

	public boolean matches(Tile other)
	{
		if (this == other)
			return false;

		if (other == null)
			return false;

		return getClass() == other.getClass();
	}

	public static void main(String[] args){

		Tile t = new Tile();
		Tile t2 = new Tile();
		JFrame f = new JFrame();

		f.setLayout(new FlowLayout());
		f.add(t);
		f.add(t2);

		f.setSize(new Dimension(1920, 1080));
		f.setTitle("Test tile");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}

