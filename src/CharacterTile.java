import java.util.HashMap; 	 	 	// HashMap version
import	java.awt.*;

import	javax.swing.*;

public class CharacterTile extends Tile
{
 	private 	static 	HashMap<Character, String> labels = new HashMap<>(); 	// HashMap version
 	protected 	char 	symbol;
 	private FontMetrics fm;
 	private boolean oneToNine;

 	public CharacterTile(char symbol)
 	{
 	 	this.symbol = symbol;
 	 	setToolTipText(toString());
 	 	oneToNine = false;
		switch (symbol)
		{
			case 'C': break;
			case 'F': break;
			case 'N': break;
			case 'E': break;
			case 'W': break;
			case 'S': break;
			default :  oneToNine = true;
		}
 	}

	@Override
	protected void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		fm = g.getFontMetrics();
		int width;
		int height;

		if(oneToNine){
			g.setFont(g.getFont().deriveFont(25F));
			width = fm.stringWidth(toChinese());
			height = fm.getHeight();
			int inBetween = (sideLength-(2*height))/3;

			g.setColor(Color.BLUE);

			g.drawString(toChinese(), sideLength / 2 - width + depth, inBetween + height);

			g.setColor(Color.RED);
			g.drawString(Character.toString('\u842c'), sideLength / 2 - width + depth, 2* inBetween + 2* height);

		}else {
			switch (symbol){
				case 'C':
					g.setColor(Color.RED);
					break;
				case 'F':
					g.setColor(Color.GREEN);
					break;
			}

			//draw big character
			g.setFont(g.getFont().deriveFont(60F));
			width = fm.stringWidth(toChinese());
			height = fm.getHeight();
			g.drawString(toChinese(), depth + (sideLength-width)/2-width*2, sideLength - height);


		}

		//Now draw the small characters
		g.setFont(g.getFont().deriveFont(12F));
		width = fm.stringWidth(toChinese());
		height = fm.getHeight();
		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol) , sideLength + depth - width,  height);

	}

 	public boolean matches(Tile other)
 	{
 	 	return super.matches(other) && symbol == ((CharacterTile)other).symbol;
 	}

 	public String toString()
 	{
 	 	switch (symbol)
 	 	{
 	 	 	case 'C': return "Red Dragon";
 	 	 	case 'F': return "Green Dragon";
 	 	 	case 'N': return "North Wind";
 	 	 	case 'E': return "East Wind";
 	 	 	case 'W': return "West Wind";
 	 	 	case 'S': return "South Wind";
 	 	 	default : return "Character " + symbol;
 	 	}
 	}


 	public String toChinese(){
 		return labels.get(symbol);
	}

 	static
 	{
		labels.put('1', "\u4E00");
		labels.put('2', "\u4E8C");
		labels.put('3', "\u4E09");
		labels.put('4', "\u56DB");
		labels.put('5', "\u4E94");
		labels.put('6', "\u516D");
		labels.put('7', "\u4E03");
		labels.put('8', "\u516B");
		labels.put('9', "\u4E5D");
		labels.put('C', "\u4E2D");
		labels.put('F', "\u767C");
		labels.put('N', "\u5317");
		labels.put('E', "\u6771");
		labels.put('W', "\u897F");
		labels.put('S', "\u5357");


 	}

	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile circleWidth" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * tile circleWidth, 40 + tile height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}

}

