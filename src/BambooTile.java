import	java.awt.*;
import	javax.swing.*;
public class BambooTile extends RankTile
{
	private Bamboo[] bamboos;
	private int rectWidth = 6;
	private int rectHeight = 23;

 	public BambooTile(int rank)
 	{
 		super(rank);
 		setToolTipText(toString());
		Color red = new Color(166, 11,0);
		Color green = new Color(30, 166,0);
		Color blue = new Color(0, 69,166);
		int xInterspacing = 0;
		int yInterspacing = 0;
		switch (rank) {
			case 1:
				//this should not happen
				break;
			case 2:
				bamboos = new Bamboo[2];
				bamboos[0] = new Bamboo(depth+sideLength/2-rectWidth/2 ,(	sideLength-2*rectHeight)/2,blue);
				bamboos[1] = new Bamboo(depth+sideLength/2-rectWidth/2 , 	sideLength/2,green);
				break;
			case 3:
				bamboos = new Bamboo[3];
				bamboos[0] = new Bamboo(depth+sideLength/2 - rectWidth,(sideLength-2*rectHeight)/2,blue);
				bamboos[1] = new Bamboo(depth+(sideLength - rectWidth*2)/3,sideLength/2,green);
				bamboos[2] = new Bamboo(depth+2*(sideLength - rectWidth*2)/3,sideLength/2,green);
				break;
			case 4:
				bamboos = new Bamboo[4];
				bamboos[0] = new Bamboo(depth+(sideLength - rectWidth*2)/3,	(sideLength-2*rectHeight)/2,blue);
				bamboos[1] = new Bamboo(depth+2*(sideLength - rectWidth*2)/3,(sideLength-2*rectHeight)/2,green);
				bamboos[2] = new Bamboo(depth+(sideLength - rectWidth*2)/3,	sideLength/2,green);
				bamboos[3] = new Bamboo(depth+2*(sideLength - rectWidth*2)/3,sideLength/2,blue);
				break;
			case 5:
				bamboos = new Bamboo[5];
				xInterspacing = (sideLength-rectWidth*3)/4;
				bamboos[0] = new Bamboo(depth+ xInterspacing,					(sideLength-2*rectHeight)/2,green);
				bamboos[1] = new Bamboo(depth+ 3*xInterspacing+2* rectWidth,	(sideLength-2*rectHeight)/2,blue);
				bamboos[2] = new Bamboo(depth+ 2*xInterspacing + rectWidth,	sideLength/2-rectHeight/2,red);
				bamboos[3] = new Bamboo(depth+ xInterspacing,					sideLength/2,blue);
				bamboos[4] = new Bamboo(depth+ 3*xInterspacing+2* rectWidth,	sideLength/2,green);
				break;
			case 6:
				bamboos = new Bamboo[6];
				xInterspacing = (sideLength-rectWidth*3)/4;
				bamboos[0] = new Bamboo(depth+ xInterspacing,					(sideLength-2*rectHeight)/2,green);
				bamboos[1] = new Bamboo(depth+ 2*xInterspacing + rectWidth,	(sideLength-2*rectHeight)/2,green);
				bamboos[2] = new Bamboo(depth+ 3*xInterspacing+2* rectWidth,	(sideLength-2*rectHeight)/2,green);
				bamboos[3] = new Bamboo(depth+ xInterspacing,					sideLength/2,blue);
				bamboos[4] = new Bamboo(depth+ 2*xInterspacing + rectWidth,	sideLength/2,blue);
				bamboos[5] = new Bamboo(depth+ 3*xInterspacing+2* rectWidth,	sideLength/2,blue);
				break;
			case 7:
				bamboos = new Bamboo[7];
				xInterspacing = (sideLength-rectWidth*3)/4;
				yInterspacing = (sideLength-3*rectHeight)/4;
				bamboos[0] = new Bamboo(depth+ 2*xInterspacing + rectWidth,		yInterspacing+1,red);
				bamboos[1] = new Bamboo(depth+ xInterspacing,				2*yInterspacing + rectHeight-1,green);
				bamboos[2] = new Bamboo(depth+ 2*xInterspacing+rectWidth,	2*yInterspacing + rectHeight-1,blue);
				bamboos[3] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth,	2*yInterspacing + rectHeight-1,green);
				bamboos[4] = new Bamboo(depth+ xInterspacing,				3*yInterspacing + 2*rectHeight-3,green);
				bamboos[5] = new Bamboo(depth+ 2*xInterspacing+rectWidth,	3*yInterspacing + 2*rectHeight-3,blue);
				bamboos[6] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth,	3*yInterspacing + 2*rectHeight-3,green);
				break;
			case 8:
				bamboos = new Bamboo[8];
				xInterspacing = (sideLength-rectWidth*3)/4;
				yInterspacing = (sideLength-3*rectHeight)/4;
				bamboos[0] = new Bamboo(depth+ xInterspacing,				yInterspacing+1,green);
				bamboos[1] = new Bamboo(depth+ 2*xInterspacing+rectWidth,	yInterspacing+1,green);
				bamboos[2] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth, yInterspacing+1,green);
				xInterspacing = (sideLength-2*rectWidth)/3;
				bamboos[3] = new Bamboo(depth+ xInterspacing,				2*yInterspacing + rectHeight-1,red);
				bamboos[4] = new Bamboo(depth+ 2*xInterspacing,				2*yInterspacing + rectHeight-1,red);
				xInterspacing = (sideLength-rectWidth*3)/4;
				bamboos[5] = new Bamboo(depth+ xInterspacing,		3*yInterspacing + 2*rectHeight-3,blue);
				bamboos[6] = new Bamboo(depth+ 2*xInterspacing+ rectWidth,	3*yInterspacing + 2*rectHeight-3,blue);
				bamboos[7] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth,	3*yInterspacing + 2*rectHeight-3,blue);
				break;
			case 9:
				bamboos = new Bamboo[9];
				xInterspacing = (sideLength-rectWidth*3)/4;
				yInterspacing = (sideLength-3*rectHeight)/4;
				bamboos[0] = new Bamboo(depth+ xInterspacing,				yInterspacing+1,green);
				bamboos[1] = new Bamboo(depth+ 2*xInterspacing+rectWidth,	yInterspacing+1,green);
				bamboos[2] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth, yInterspacing+1,green);
				bamboos[3] = new Bamboo(depth+ xInterspacing,				2*yInterspacing + rectHeight-1,red);
				bamboos[4] = new Bamboo(depth+ 2*xInterspacing+rectWidth,	2*yInterspacing + rectHeight-1,red);
				bamboos[5] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth,	2*yInterspacing + rectHeight-1,red);
				bamboos[6] = new Bamboo(depth+ xInterspacing,				3*yInterspacing + 2*rectHeight-3,blue);
				bamboos[7] = new Bamboo(depth+ 2*xInterspacing+ rectWidth,	3*yInterspacing + 2*rectHeight-3,blue);
				bamboos[8] = new Bamboo(depth+ 3*xInterspacing+ 2*rectWidth,	3*yInterspacing + 2*rectHeight-3,blue);
				break;
		}
 	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Bamboo b : bamboos){
			if(b!=null)
				b.draw(g);
		}
	}

 	public String toString()
 	{
 	 	return "Bamboo " + rank;
 	}

 	class Bamboo {
		int x;
		int y;
		Color color;

		public Bamboo(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}

		public void draw(Graphics g ){
			//draw main rect
			g.setColor(color);
			g.fillRect(x,y+1,rectWidth, rectHeight-1);
			//draw accent rect
			g.setColor(Color.WHITE);
			g.fillRect(x+rectWidth/2,y+3,rectWidth/4, rectHeight-5);

			//draw top rect
			g.setColor(color);
			g.fillRect(x-2,y+1,rectWidth+4, 2);
			//draw middle rect
			g.fillRect(x-2,y+rectHeight/2-2,rectWidth+4, 3);
			//draw bottom rect
			g.fillRect(x-2,y+rectHeight-2,rectWidth+4, 2);

		}
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}

