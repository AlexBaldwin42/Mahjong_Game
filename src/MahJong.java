import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MahJong extends JFrame {

    MahJongBoard board;
    NewGameListener newGameListener = new NewGameListener();
    private boolean randomGame = true;
    private long gameNumber;
    private Scroller undoScrollPane;

    public MahJong() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mah Jong");

        //Scroll window
        undoScrollPane = new Scroller();
        undoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(undoScrollPane, BorderLayout.EAST);

        //Board
        setSize(1450, 700);
        gameNumber = ((new Date()).getTime()%100000);
        board = new MahJongBoard(undoScrollPane,gameNumber , true);
        add(board);

        //Menu
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu gameMenu = new JMenu("Game");
        bar.add(gameMenu);

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.setMnemonic('N');
        newGame.addActionListener(newGameListener);

        //Undo
        JMenuItem undo = new JMenuItem("Undo");
        undo.setMnemonic('U');
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.undoLast();
            }
        });

        //Restart Game
        JMenuItem restartGame = new JMenuItem("Restart");
        restartGame.setMnemonic('R');
        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                restartGameBoard();
            }
        });

        gameMenu.add(newGame);
        gameMenu.add(undo);
        gameMenu.add(restartGame);


        setVisible(true);


    }

    public void newGame(){
        //restart the game
        //reset scroll window
        remove(undoScrollPane);
        undoScrollPane = new Scroller();
        undoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(undoScrollPane, BorderLayout.EAST);
        revalidate();

        //setup board
        remove(board);
        //setSize(1450, 700);
        if(randomGame) {
            setTitle("Mah Jong");
            board = new MahJongBoard(undoScrollPane);
        }else{
            setTitle(getTitle() + " Game Number "+Long.toString(gameNumber));
            board = new MahJongBoard(undoScrollPane, gameNumber, randomGame);
        }
        add(board);
        revalidate();
        //repaint();
    }

    public void restartGameBoard(){
        //restart the game
        //reset scroll window
        remove(undoScrollPane);
        undoScrollPane = new Scroller();
        undoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(undoScrollPane, BorderLayout.EAST);
        revalidate();

        //setup board
        remove(board);
        //setSize(1450, 700);

        setTitle(getTitle() + " Game Number "+Long.toString(gameNumber));
        board = new MahJongBoard(undoScrollPane, gameNumber, randomGame);

        add(board);
        revalidate();
        //repaint();
    }
    private class NewGameListener implements ActionListener {

        public NewGameListener() {
        }

        public void actionPerformed(ActionEvent e) {
            //popup frame ask question start new game with seed.
            JOptionPane gameOptions = new JOptionPane();

            String options[] = {"Yes", "No"};
            int choice = gameOptions.showOptionDialog(getContentPane(),
                    "Random Game?",
                    "Choose",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            randomGame = choice == 0;
            if (!randomGame) {
                boolean validInput = false;
                while (!validInput) {
                    JOptionPane gameNumberOptionPane = new JOptionPane();
                    String gameNumberString = gameNumberOptionPane.showInputDialog(getContentPane(),
                            "Enter 5 Digit Game Number");

                    try {
                        gameNumber = Long.parseLong(gameNumberString);
                        if (gameNumber / 100000 >= 1) {
                            JOptionPane.showMessageDialog(null, "Game Number too large");
                        } else if (gameNumber < 0) {
                            JOptionPane.showMessageDialog(null, "Game Number cannot be neagative");
                        } else {
                            validInput = true;
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Invalid Game Number");
                    }

                }

                System.out.println("game number is " + gameNumber);
            }

            newGame();


        }

    }




    public static void main(String[] args){
        new MahJong();
    }
}
