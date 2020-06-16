import	java.awt.*;
import java.awt.geom.Rectangle2D;

public class WhiteDragonTile extends Tile
{
	private static Rectangle2D topRect;
	private static Rectangle2D botRect;
	private static Rectangle2D leftRect;
	private static Rectangle2D rightRect;

	private static Rectangle2D topRect2;
	private static Rectangle2D botRect2;
	private static Rectangle2D leftRect2;
	private static Rectangle2D rightRect2;

	private static Rectangle2D topRect3;
	private static Rectangle2D botRect3;
	private static Rectangle2D leftRect3;
	private static Rectangle2D rightRect3;
	private static Rectangle2D leftRect4;
	private static Rectangle2D rightRect4;


	private static int rectangleWidth;
	private static int rectangleLength;
	private static int whiteSquaresLength;

	public  WhiteDragonTile(){
		super();
		setToolTipText(toString());
	}

	static
	{
		rectangleWidth = 5;
		rectangleLength = sideLength-16;
		topRect = 	new Rectangle2D.Double(depth +(sideLength- rectangleLength)/2, 8,
											rectangleLength, rectangleWidth);
		botRect=	new Rectangle2D.Double(depth +(sideLength- rectangleLength)/2, sideLength-8-5,
											rectangleLength, rectangleWidth);
		leftRect=	new Rectangle2D.Double(depth +(sideLength- rectangleLength)/2,8,
											rectangleWidth, rectangleLength);
		rightRect=	new Rectangle2D.Double(depth +sideLength-(sideLength- rectangleLength)/2-rectangleWidth,8,
											rectangleWidth, rectangleLength);

		whiteSquaresLength = rectangleLength/5;
		topRect2 = new Rectangle2D.Double(topRect.getX() + whiteSquaresLength, 8,
											whiteSquaresLength, rectangleWidth);
		topRect3 = new Rectangle2D.Double(topRect.getX() + whiteSquaresLength*3, 8,
											whiteSquaresLength, rectangleWidth);


		botRect2 = new Rectangle2D.Double(topRect.getX() + whiteSquaresLength, sideLength-8-5,
											whiteSquaresLength, rectangleWidth);
		botRect3 = new Rectangle2D.Double(topRect.getX() + whiteSquaresLength*3, sideLength-8-5,
											whiteSquaresLength, rectangleWidth);

		leftRect2 = new Rectangle2D.Double(topRect.getX(), 8,
											rectangleWidth, whiteSquaresLength);
		leftRect3 = new Rectangle2D.Double(topRect.getX(), 8 + 2*(whiteSquaresLength+1),
											rectangleWidth, whiteSquaresLength);
		leftRect4 = new Rectangle2D.Double(topRect.getX(), 8 + 4*(whiteSquaresLength+1),
											rectangleWidth, whiteSquaresLength);


		rightRect2 = new Rectangle2D.Double(depth +sideLength-(sideLength- rectangleLength)/2-rectangleWidth, 8,
				rectangleWidth, whiteSquaresLength);
		rightRect3 = new Rectangle2D.Double(depth +sideLength-(sideLength- rectangleLength)/2-rectangleWidth, 8 + 2*(whiteSquaresLength+1),
				rectangleWidth, whiteSquaresLength);
		rightRect4 = new Rectangle2D.Double(depth +sideLength-(sideLength- rectangleLength)/2-rectangleWidth, 8 + 4*(whiteSquaresLength+1),
				rectangleWidth, whiteSquaresLength);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		var g2 = (Graphics2D)g;

		g2.setPaint(Color.BLUE);
		g2.fill(topRect);
		g2.fill(botRect);
		g2.fill(leftRect);
		g2.fill(rightRect);

		g2.setPaint(Color.WHITE);
		g2.fill(topRect2);
		g2.fill(topRect3);
		g2.fill(botRect2);
		g2.fill(botRect3);
		g2.fill(leftRect2);
		g2.fill(leftRect3);
		g2.fill(leftRect4);
		g2.fill(rightRect2);
		g2.fill(rightRect3);
		g2.fill(rightRect4);

		g2.setPaint(Color.BLACK);
		g2.draw(topRect);
		g2.draw(botRect);
		g2.draw(leftRect);
		g2.draw(rightRect);
		g2.draw(topRect2);
		g2.draw(topRect3);
		g2.draw(botRect2);
		g2.draw(botRect3);
		g2.draw(leftRect2);
		g2.draw(leftRect3);
		g2.draw(leftRect4);
		g2.draw(rightRect2);
		g2.draw(rightRect3);
		g2.draw(rightRect4);

	}
 	public String toString()
 	{
 	 	return "White Dragon";
 	}
}

