import	java.awt.*;
import	javax.swing.*;
import java.awt.geom.Ellipse2D;

public class CircleTile extends RankTile
{
	private Circle[] circles;
	private int circleWidth = 14;
	private int radius = circleWidth/2;
	private int squareToCircleEdge;

	public CircleTile(int rank)
 	{
 	 	super(rank);
 	 	setToolTipText(toString());
 	 	Color red = new Color(166, 11,0);
		Color green = new Color(30, 166,0);
		Color blue = new Color(0, 69,166);


 	 	switch (rank) {
			case 1:
				circleWidth = 60;
				radius = circleWidth/2;
				circles = new Circle[1];
				circles[0] = new Pancake(depth + sideLength/2-radius, sideLength/2-radius, green);
				break;
			case 2:
				circleWidth = 30;
				radius = circleWidth/2;
				circles = new Circle[2];
				circles[0] = new Circle(depth + sideLength/2 - radius, (sideLength-(2*circleWidth))/2, green);
				circles[1] = new Circle(depth + sideLength/2 - radius, (sideLength-(2*circleWidth))/2+circleWidth, red);
				break;
			case 3:
				circleWidth = 25;
				radius = circleWidth/2;
				circles = new Circle[3];
				circles[0] = new Circle(depth + sideLength/4-radius, 	sideLength/4-radius, blue);
				circles[1] = new Circle(depth + 2*sideLength/4-radius,	2*sideLength/4-radius, red);
				circles[2] = new Circle(depth + 3*sideLength/4-radius, 	3*sideLength/4-radius, green);
				break;
			case 4:
				circleWidth = 34;
				radius = circleWidth/2;
				circles = new Circle[4];
				circles[0] = new Circle(depth + (sideLength-2*circleWidth)/2, 		(sideLength-2*circleWidth)/2, blue);
				circles[1] = new Circle(depth + (sideLength-2*circleWidth)/2+ circleWidth, 		(sideLength-2*circleWidth)/2, green);
				circles[2] = new Circle(depth + (sideLength-2*circleWidth)/2,		(sideLength-2*circleWidth)/2+circleWidth, green);
				circles[3] = new Circle(depth + (sideLength-2*circleWidth)/2+ circleWidth, 	(sideLength-2*circleWidth)/2+circleWidth, blue);
				break;
			case 5:
				circleWidth = 24;
				radius = circleWidth/2;
				circles = new Circle[5];
				circles[0] = new Circle(depth + sideLength/4-radius,				sideLength/4-radius, blue);
				circles[1] = new Circle(depth + 3*sideLength/4 - radius, 		sideLength/4-radius, green);
				circles[2] = new Circle(depth + sideLength/2-radius, 			sideLength/2-radius, red);
				circles[3] = new Circle(depth + sideLength/4-radius, 			3*sideLength/4-radius, green);
				circles[4] = new Circle(depth + 3*sideLength/4-circleWidth/2, 	3*sideLength/4-radius, blue);
				break;
			case 6:
				circleWidth = 24;
				radius = circleWidth/2;
				circles = new Circle[6];
				circles[0] = new Circle(depth + (sideLength-2*circleWidth)/3, 		(sideLength-3*circleWidth)/2, green);
				circles[1] = new Circle(depth + 2*(sideLength-2*circleWidth)/3+circleWidth, 	(sideLength-3*circleWidth)/2, green);
				circles[2] = new Circle(depth + (sideLength-2*circleWidth)/3, 	(sideLength-3*circleWidth)/2+circleWidth, red);
				circles[3] = new Circle(depth + 2*(sideLength-2*circleWidth)/3+circleWidth, 	(sideLength-3*circleWidth)/2+circleWidth, red);
				circles[4] = new Circle(depth + (sideLength-2*circleWidth)/3, 	(sideLength-3*circleWidth)/2+circleWidth*2, red);
				circles[5] = new Circle(depth + 2*(sideLength-2*circleWidth)/3+circleWidth, 	(sideLength-3*circleWidth)/2+circleWidth*2, red);
				break;
			case 7:
				circleWidth = 15;
				radius = circleWidth/2;
				circles = new Circle[7];
				circles[0] = new Circle(depth + sideLength/4-radius,  sideLength/10 - radius+7, green);
				circles[1] = new Circle(depth + 2*sideLength/4-radius, 2*sideLength/10 - radius+8, green);
				circles[2] = new Circle(depth + 3*sideLength/4-radius, 3*sideLength/10 - radius+9, green);
				circles[3] = new Circle(depth + sideLength/3 - radius,  3*sideLength/2/3 - radius+10, red);
				circles[4] = new Circle(depth + 2*sideLength/3- radius, 3*sideLength/6  - radius+10, red);
				circles[5] = new Circle(depth + sideLength/3 - radius,  5*sideLength/6 - radius, red);
				circles[6] = new Circle(depth + 2*sideLength/3- radius, 5*sideLength/6 - radius, red);
				break;
			case 8:
				circleWidth = 15;
				radius = circleWidth/2;
				circles = new Circle[8];
				circles[0] = new Circle(depth + sideLength/3 - radius, 	 sideLength/5 -radius, blue);
				circles[1] = new Circle(depth + 2*sideLength/3- radius, 	 sideLength/5 -radius, blue);
				circles[2] = new Circle(depth + sideLength/3 - radius, 	 2*sideLength/5 -radius, blue);
				circles[3] = new Circle(depth + 2*sideLength/3- radius,	 2*sideLength/5 -radius, blue);
				circles[4] = new Circle(depth + sideLength/3 - radius, 	 3*sideLength/5 -radius, blue);
				circles[5] = new Circle(depth + 2*sideLength/3- radius, 	 3*sideLength/5 -radius, blue);
				circles[6] = new Circle(depth + sideLength/3 - radius,  	 4*sideLength/5 -radius, blue);
				circles[7] = new Circle(depth + 2*sideLength/3- radius,	 4*sideLength/5 -radius, blue);
				break;
			case 9:
				circleWidth = 25;
				radius = circleWidth/2;
				circles = new Circle[9];
				circles[0] = new Circle(depth + (sideLength-3*circleWidth)/2, 				(sideLength-3*circleWidth)/2, green);
				circles[1] = new Circle(depth + (sideLength-3*circleWidth)/2+circleWidth,	(sideLength-3*circleWidth)/2, green);
				circles[2] = new Circle(depth + (sideLength-3*circleWidth)/2+2*circleWidth,	(sideLength-3*circleWidth)/2, green);
				circles[3] = new Circle(depth + (sideLength-3*circleWidth)/2, 				(sideLength-3*circleWidth)/2+circleWidth, red);
				circles[4] = new Circle(depth + (sideLength-3*circleWidth)/2+circleWidth, 	(sideLength-3*circleWidth)/2+circleWidth, red);
				circles[5] = new Circle(depth + (sideLength-3*circleWidth)/2+2*circleWidth,	(sideLength-3*circleWidth)/2+circleWidth, red);
				circles[6] = new Circle(depth + (sideLength-3*circleWidth)/2, 				(sideLength-3*circleWidth)/2+2*circleWidth, blue);
				circles[7] = new Circle(depth + (sideLength-3*circleWidth)/2+circleWidth, 	(sideLength-3*circleWidth)/2+2*circleWidth, blue);
				circles[8] = new Circle(depth + (sideLength-3*circleWidth)/2+2*circleWidth, 	(sideLength-3*circleWidth)/2+2*circleWidth, blue);
				break;

		}
 	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Circle c : circles){
			if(c!=null)
				c.draw(g);
		}
	}

 	public String toString()
 	{
 	 	return "Circle " + rank;
 	}

 	class Circle{
 		int x;
 		int y;
 		Color color;
 		public Circle(int x, int y, Color color){
 			this.x = x;
 			this.y = y;
 			this.color = color;
		}

		public void draw(Graphics g){
 			g.setColor(color);
			g.fillOval(x,y, circleWidth, circleWidth);
			g.setColor(Color.WHITE);
			squareToCircleEdge = (int)(radius*0.2928932188134524);
			g.drawLine(squareToCircleEdge +x,
					   squareToCircleEdge +y,
					   x+circleWidth - squareToCircleEdge,
					   y+circleWidth - squareToCircleEdge);

			g.drawLine(x+ squareToCircleEdge,
					   y+circleWidth- squareToCircleEdge,
					   x+circleWidth- squareToCircleEdge,
					   y+ squareToCircleEdge);
		}
	}
	class Pancake extends Circle{
		Ellipse2D[] circleOfCircles = new Ellipse2D[12];
		Ellipse2D centerCircle;
		int centerCircleRadius;
		Color red = new Color(166, 11,0);

		public Pancake(int x, int y, Color color) {
			super(x, y, color);
			centerCircleRadius = 10;
			double smallCircleX;
			double smallCircleY;
			int centerOfCircleX =(int)( x + radius *0.2928932188134524+ radius);
			int centerOfCircleY= (int)( y + radius *0.2928932188134524+radius);

			for(int i = 0; i< 12; i++){
				smallCircleX = (double)(Math.cos(i*Math.PI/6)*.75*radius);
				smallCircleY = (double)(Math.sin(i*Math.PI/6)*.75*radius);
				smallCircleX = (float)(smallCircleX  + centerOfCircleX );
				smallCircleY = (float)(smallCircleY  +  centerOfCircleY);
				smallCircleX= smallCircleX- radius *0.2928932188134524;
				smallCircleY = smallCircleY- radius *0.2928932188134524;
				circleOfCircles[i] = new Ellipse2D.Double(smallCircleX,smallCircleY,3,3);
			}

			centerCircle = new Ellipse2D.Double(depth + sideLength/2 -centerCircleRadius,
												sideLength/2 -centerCircleRadius,
												centerCircleRadius * 2,
												centerCircleRadius * 2);
		}

		public void draw(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g.setColor(color);
			g.fillOval(x,y, circleWidth, circleWidth);
			g2.setPaint(Color.WHITE);
			for(Ellipse2D e : circleOfCircles){
				g2.draw(e);
				g2.fill(e);
			}
			g2.setPaint(Color.WHITE);
			g2.draw(centerCircle);
			g2.setPaint(red);
			g2.fill(centerCircle);

			g.setColor(Color.WHITE);

			int centerToSquareSmallCircle =  (int)(centerCircleRadius*0.2928932188134524);
			g.drawLine(centerToSquareSmallCircle +(int)centerCircle.getX(),
					centerToSquareSmallCircle +(int)centerCircle.getY(),
					(int)centerCircle.getX()+2*centerCircleRadius - centerToSquareSmallCircle ,
					(int)centerCircle.getY()+2*centerCircleRadius - centerToSquareSmallCircle);

			g.drawLine(centerToSquareSmallCircle +(int)centerCircle.getX(),
					(int)(centerCircle.getY()+2*centerCircleRadius - centerToSquareSmallCircle),
					(int)centerCircle.getX()+2*centerCircleRadius - centerToSquareSmallCircle,
					centerToSquareSmallCircle +(int)centerCircle.getY());
		}


	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}

