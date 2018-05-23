import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.util.Hashtable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JSlider;
import javax.swing.SwingConstants;


public class MainWindow extends JFrame{

	private JPanel contentPane;
	private JPanel cards;
	final static String MENUPANEL = "Card with main menu";
	final static String GAMEPANEL = "Card with the game";
	final static String DIFFPANEL = "Card with difficulties";
	final static String SIZEPANEL = "Card with grid size";
	JPanel cardMenu = new JPanel();
	JPanel cardGame = new JPanel();
	JPanel cardDiff = new JPanel();
	JPanel cardSize = new JPanel();

	JPanel panel = new JPanel();
	CardLayout layout = new CardLayout();
	private final JButton backBtn3 = new JButton("WSTECZ");
	private final JButton startBtn = new JButton("START");
	private final JButton diffBtn = new JButton("POZIOM TRUDNOåCI");
	private final JButton sizeBtn = new JButton("ROZMIAR SIATKI");
	private final JButton exitBtn = new JButton("WYJDè");
	private final JButton easyBtn = new JButton("£ATWY");
	private final JButton medBtn = new JButton("åREDNI");
	private final JButton hardBtn = new JButton("TRUDNY");
	private final JButton backBtn = new JButton("WSTECZ");
	private final JLabel poziomLbl = new JLabel("POZIOM TRUDNO\u015ACI");
	private final JLabel snakeLbl = new JLabel("SNAKE THE GAME");
	private final JLabel obecnyLbl = new JLabel("(OBECNIE: \u015AREDNI)");
	private final JLabel lblWielkoSiatki = new JLabel("WIELKO\u015A\u0106 SIATKI");
	private final JLabel lblobecnieMaa = new JLabel("(OBECNIE: MA\u0141A)");
	private final JButton smBtn = new JButton("MA£A (10x10)");
	private final JButton mdBtn = new JButton("åREDNIA (25x25)");
	private final JButton bgBtn = new JButton("DUØA (40x40)");
	private final JButton backBtn2 = new JButton("WSTECZ");
	private final JButton startGameBtn = new JButton("START");
	private final JButton exitGameBtn = new JButton("EXIT");
	DrawRect rectArray[][];
	JSlider slider;
	Timer timer = new Timer();
	public int randPosX;
	public int randPosY;
	public int posX;
	public int posY;
	public int iterator;
	public int iterator_limit;
	public int direction;
	public LinkedList<DrawRect> snake = new LinkedList<DrawRect>();
	public DrawRect food = new DrawRect();
	public boolean safe = false;
	public boolean isFood = false;
	public Random generator = new Random();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class DrawRect extends JPanel{
		private int posX;
		private int posY;
		private int edge;
		private Color col = Color.LIGHT_GRAY;
		@Override
		public void paint(Graphics g) {
		      super.paint(g);
		      
		      g.setColor(col);
		      g.fillRect(posX, posY, edge, edge);
		 
		   }

		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}

		public int getEdge() {
			return edge;
		}

		public void setEdge(int edge) {
			this.edge = edge;
		}
		
		public void setCol(Color col){
			this.col = col;
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, Definitions.getWIDTH(), Definitions.getHEIGHT());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.GRAY);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setUndecorated(true);
		cards = new JPanel(layout);
		
		
		/////////////////////////////////////////////
		cards.add(cardMenu, MENUPANEL);
		
		GridBagLayout gbl_cardMenu = new GridBagLayout();
		gbl_cardMenu.columnWidths = new int[] {300};
		gbl_cardMenu.rowHeights = new int[] {80, 50, 80, 80, 80, 80, 80, 80, 80, 30};
		gbl_cardMenu.columnWeights = new double[]{0.0};
		gbl_cardMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		cardMenu.setLayout(gbl_cardMenu);
		cardMenu.setMaximumSize(new Dimension(300, 300));
		cardMenu.setBackground(Color.LIGHT_GRAY);
		
		GridBagConstraints gbc_lblSnakeTheGame = new GridBagConstraints();
		gbc_lblSnakeTheGame.anchor = GridBagConstraints.SOUTH;
		gbc_lblSnakeTheGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblSnakeTheGame.gridx = 0;
		gbc_lblSnakeTheGame.gridy = 0;
		snakeLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		cardMenu.add(snakeLbl, gbc_lblSnakeTheGame);
		
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 8;
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 6;
		sizeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, SIZEPANEL);
			}
		});
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		diffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, DIFFPANEL);
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		
		
		// // // // // // // // // // // // // // // // // // //
		
		backBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, MENUPANEL);
			}
		});
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1190, 890);
		cardGame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		backBtn3.setForeground(Color.WHITE);
		backBtn3.setBackground(Color.BLACK);
		backBtn3.setBounds(945, 244, 150, 80);
		cardGame.add(backBtn3);
		
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, GAMEPANEL);
				cardGame.setLayout(null);
				cardGame.setFocusable(true);
				cardGame.requestFocusInWindow();
				cardGame.addKeyListener(new KeyListener(){
					  @Override
	                    public void keyTyped(KeyEvent e) {}

	                    @Override
	                    public void keyReleased(KeyEvent e) {}

	                    @Override
	                    public void keyPressed(KeyEvent e) {
	                    	int key = e.getKeyCode();
	                		
	                		switch(key){
	                			case KeyEvent.VK_LEFT:
	                				if(direction != 2 && safe == true){
	                					direction = 4;
	                					safe = false;
	                				}
	                				break;
	                			case KeyEvent.VK_UP:
	                				if(direction != 3 && safe == true){
	                					direction = 1;
	                					safe = false;
	                				}
	                				break;
	                			case KeyEvent.VK_RIGHT:
	                				if(direction != 4 && safe == true){
	                					direction = 2;
	                					safe = false;
	                				}
	                				break;
	                			case KeyEvent.VK_DOWN:
	                				if(direction != 1 && safe == true){
	                					direction = 3;
	                					safe = false;
	                				}
	                				break;
	                		}
	                		
	                    }
				});
				int size = Definitions.getGRIDSIZE();
				int gSize = Definitions.getGSIZE();
				int edge = (800/size)-5;

				rectArray = new DrawRect[size][size];
				for(int i = 0; i < size; i++){
					for(int j = 0; j < size; j++){
					rectArray[i][j] = new DrawRect();
					rectArray[i][j].setBounds(50+i*(edge+5),20+j*(edge+5),edge,edge);
					rectArray[i][j].setEdge(edge);
					//rectArray[i][j].setVisible(false);
					//rect.setBounds(50+i*(edge+5),20+j*(edge+5), edge, edge);
					cardGame.add(rectArray[i][j]);
					}
				}
				getContentPane().setLayout(null);
				
				
				
			}
		});
		startBtn.setBackground(Color.BLACK);
		startBtn.setForeground(Color.WHITE);
		cardMenu.add(startBtn, gbc_btnNewButton_2);
		diffBtn.setBackground(Color.BLACK);
		diffBtn.setForeground(Color.WHITE);
		cardMenu.add(diffBtn, gbc_btnNewButton_3);
		sizeBtn.setBackground(Color.BLACK);
		sizeBtn.setForeground(Color.WHITE);
		cardMenu.add(sizeBtn, gbc_btnNewButton_4);
		exitBtn.setBackground(Color.BLACK);
		exitBtn.setForeground(Color.WHITE);
		cardMenu.add(exitBtn, gbc_btnNewButton_5);
		cardGame.setBackground(Color.GRAY);
		
		//////////////////////////////////////
		cards.add(cardGame, GAMEPANEL);
		cardGame.setLayout(null);
		
		startGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGameBtn.setEnabled(false);
				backBtn3.setEnabled(false);
				
				int size = Definitions.getGRIDSIZE();
				int edge = (800/size)-5;
				
				
				// creating snake
				DrawRect snakeHead = new DrawRect();
				snake.add(snakeHead);
				snakeHead.setCol(Color.RED);
				snakeHead.setEdge(edge);
				//posX = 50+(size/2-1)*(edge+5);
				//posY = 20+(size/2-1)*(edge+5);
				posX = rectArray[(int)size/2][(int)size/2].getBounds().x;
				posY = rectArray[(int)size/2][(int)size/2].getBounds().y;
				snakeHead.setBounds(posX, posY, edge, edge);
				cardGame.add(snakeHead);
				snakeHead.repaint();
				
				
				
				timer.schedule(myTask, 50, 50);
				
				
				cardGame.requestFocus();
				
				///////////////////////////////////////////////////////////////////////////
			}
			
	
			
		});
		startGameBtn.setSize(150,75);
		startGameBtn.setMaximumSize(getSize());
		startGameBtn.setBounds(945, 100, 150, 75);
		cardGame.add(startGameBtn);
		exitGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitGameBtn.setSize(150,75);
		exitGameBtn.setMaximumSize(getSize());
		exitGameBtn.setBounds(945, 400, 150, 75);
		cardGame.add(exitGameBtn);
		
		slider = new JSlider(JSlider.HORIZONTAL, 1, 10, Definitions.getDIFFICULTY());
		slider.setBounds(930, 660, 200, 50);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(1), new JLabel("£atwy"));
		labelTable.put(new Integer(5), new JLabel("åredni"));
		labelTable.put(new Integer(10), new JLabel("Trudny"));
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		        Definitions.setDIFFICULTY(slider.getValue());
		        iterator = 0;
		        iterator_limit = 10 - slider.getValue();
		        cardGame.requestFocus();
		      }
		    });
		cardGame.add(slider);
		
		
		//////////////////////////////////////
		cards.add(cardDiff, DIFFPANEL);
		GridBagLayout gbl_cardDiff = new GridBagLayout();
		gbl_cardDiff.columnWidths = new int[] {300};
		gbl_cardDiff.rowHeights = new int[] {80, 80, 80, 80, 80, 80, 80, 80, 80, 30};
		gbl_cardDiff.columnWeights = new double[]{0.0};
		gbl_cardDiff.rowWeights = new double[]{0.0, 0.0};
		cardDiff.setLayout(gbl_cardDiff);
		easyBtn.setBackground(Color.BLACK);
		easyBtn.setForeground(Color.WHITE);
		medBtn.setBackground(Color.BLACK);
		medBtn.setForeground(Color.WHITE);
		hardBtn.setBackground(Color.BLACK);
		hardBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblPoziomTrudnoci = new GridBagConstraints();
		gbc_lblPoziomTrudnoci.anchor = GridBagConstraints.NORTH;
		gbc_lblPoziomTrudnoci.insets = new Insets(0, 0, 5, 0);
		gbc_lblPoziomTrudnoci.gridx = 0;
		gbc_lblPoziomTrudnoci.gridy = 0;
		poziomLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		cardDiff.add(poziomLbl, gbc_lblPoziomTrudnoci);
		
		GridBagConstraints gbc_lblObecnyatwy = new GridBagConstraints();
		gbc_lblObecnyatwy.insets = new Insets(0, 0, 5, 0);
		gbc_lblObecnyatwy.gridx = 0;
		gbc_lblObecnyatwy.gridy = 1;
		obecnyLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		cardDiff.add(obecnyLbl, gbc_lblObecnyatwy);
		
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_22.gridx = 0;
		gbc_btnNewButton_22.gridy = 2;
		cardDiff.add(easyBtn,gbc_btnNewButton_22);
		
		GridBagConstraints gbc_btnNewButton_32 = new GridBagConstraints();
		gbc_btnNewButton_32.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_32.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_32.gridx = 0;
		gbc_btnNewButton_32.gridy = 4;
		cardDiff.add(medBtn,gbc_btnNewButton_32);
		
		GridBagConstraints gbc_btnNewButton_42 = new GridBagConstraints();
		gbc_btnNewButton_42.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_42.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_42.gridx = 0;
		gbc_btnNewButton_42.gridy = 6;
		cardDiff.add(hardBtn,gbc_btnNewButton_42);
		
		GridBagConstraints gbc_btnNewButton_52 = new GridBagConstraints();
		gbc_btnNewButton_52.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_52.gridx = 0;
		gbc_btnNewButton_52.gridy = 8;
		cardDiff.add(backBtn,gbc_btnNewButton_52);
		
		easyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setDIFFICULTY(1);
				slider.setValue(Definitions.getDIFFICULTY());
		        iterator = 0;
		        iterator_limit = 10 - slider.getValue();
				obecnyLbl.setText("(OBECNIE: \u0141ATWY)");
			}
		});
		
		hardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setDIFFICULTY(10);
				slider.setValue(Definitions.getDIFFICULTY());
		        iterator = 0;
		        iterator_limit = 10 - slider.getValue();
				obecnyLbl.setText("(OBECNIE: TRUDNY)");
			}
		});
		
		medBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setDIFFICULTY(5);
				slider.setValue(Definitions.getDIFFICULTY());
		        iterator = 0;
		        iterator_limit = 10 - slider.getValue();
				obecnyLbl.setText("(OBECNIE: \u015AREDNI)");
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, MENUPANEL);
			}
		});


		////////////////////////////////
		cards.add(cardSize, SIZEPANEL);
		GridBagLayout gbl_cardSize = new GridBagLayout();
		gbl_cardSize.columnWidths = new int[] {350};
		gbl_cardSize.rowHeights = new int[] {80, 80, 80, 80, 80, 80, 80, 80, 80, 30};
		gbl_cardSize.columnWeights = new double[]{0.0};
		gbl_cardSize.rowWeights = new double[]{0.0, 0.0};
		cardSize.setLayout(gbl_cardSize);
		
		GridBagConstraints gbc_lblWielkoSiatki = new GridBagConstraints();
		gbc_lblWielkoSiatki.insets = new Insets(0, 0, 5, 0);
		gbc_lblWielkoSiatki.gridx = 0;
		gbc_lblWielkoSiatki.gridy = 0;
		lblWielkoSiatki.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		cardSize.add(lblWielkoSiatki, gbc_lblWielkoSiatki);
		
		GridBagConstraints gbc_lblobecnieMaa = new GridBagConstraints();
		gbc_lblobecnieMaa.insets = new Insets(0, 0, 5, 0);
		gbc_lblobecnieMaa.gridx = 0;
		gbc_lblobecnieMaa.gridy = 1;
		lblobecnieMaa.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		cardSize.add(lblobecnieMaa, gbc_lblobecnieMaa);
		
		smBtn.setBackground(Color.BLACK);
		smBtn.setForeground(Color.WHITE);
		mdBtn.setBackground(Color.BLACK);
		mdBtn.setForeground(Color.WHITE);
		bgBtn.setBackground(Color.BLACK);
		bgBtn.setForeground(Color.WHITE);
		backBtn2.setBackground(Color.BLACK);
		backBtn2.setForeground(Color.WHITE);
		
		
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_23.gridx = 0;
		gbc_btnNewButton_23.gridy = 2;
		cardSize.add(smBtn,gbc_btnNewButton_23);
		
		GridBagConstraints gbc_btnNewButton_33 = new GridBagConstraints();
		gbc_btnNewButton_33.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_33.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_33.gridx = 0;
		gbc_btnNewButton_33.gridy = 4;
		cardSize.add(mdBtn,gbc_btnNewButton_33);
		
		GridBagConstraints gbc_btnNewButton_43 = new GridBagConstraints();
		gbc_btnNewButton_43.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_43.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_43.gridx = 0;
		gbc_btnNewButton_43.gridy = 6;
		cardSize.add(bgBtn,gbc_btnNewButton_43);
		
		GridBagConstraints gbc_btnNewButton_53 = new GridBagConstraints();
		gbc_btnNewButton_53.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_53.gridx = 0;
		gbc_btnNewButton_53.gridy = 8;
		cardSize.add(backBtn2,gbc_btnNewButton_53);
		
		smBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setGRIDSIZE(10);
				lblobecnieMaa.setText("(OBECNIE: MA\u0141A)");
			}
		});
		
		mdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setGRIDSIZE(25);
				lblobecnieMaa.setText("(OBECNIE: åREDNIA)");
			}
		});
		
		bgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setGRIDSIZE(40);
				lblobecnieMaa.setText("(OBECNIE: DUØA)");
			}
		});
		
		backBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, MENUPANEL);
			}
		});
		
		
		
		
		getContentPane().add(cards);
		layout.show(cards, MENUPANEL);
		
	}
	
	TimerTask myTask = new TimerTask(){
		@Override
		public void run(){
			int size = Definitions.getGRIDSIZE();
			int edge = (800/size)-5;
			
			int dif = Definitions.getDIFFICULTY();
			
			/*cardGame.add(food);
			food.repaint();
			for(int i = 0; i < snake.size(); ++i) {
				cardGame.add(snake.get(i));
				snake.get(i).repaint();
			}*/
			
			iterator = (iterator + 1) % 11;
			if(iterator >= iterator_limit){
				System.out.println(snake.peek().getBounds().x + " " + food.getBounds().x);
//				DrawRect clear = new DrawRect();
//				clear.setCol(Color.LIGHT_GRAY);
//				clear.setEdge(edge);
//				clear.setBounds(posX, posY,edge,edge);
//				cardGame.add(clear);
//				clear.repaint();
				panel.removeAll();
				if(snake.peek().getBounds().x == food.getBounds().x && snake.peek().getBounds().y == food.getBounds().y) {
					food = new DrawRect();
					panel.add(food);
					food.repaint();
					DrawRect newSnake = new DrawRect();
					newSnake.setCol(Color.RED);
					newSnake.setEdge(edge);
					//newSnake.setBounds(snake.get(snake.size()-1).getBounds().x, snake.get(snake.size()-1).getBounds().y, edge, edge);
					newSnake.setBounds(posX, posY, edge, edge);
					snake.addLast(newSnake);
					panel.add(newSnake);
					newSnake.repaint();
					isFood = false;
					//food.setCol(Color.LIGHT_GRAY);
					//food.setEdge(edge);
					//cardGame.add(food);
					//food.repaint();
				}
				
				switch(direction){
				case 2:
					posX = (posX + (edge+5));
					if(posX > (50 + (size-1)*(edge+5)))
						posX = 50;
					break;
				case 4:
					posX = (posX - (edge+5));
					if(posX < 50)
						posX = 50 + (size-1)*(edge+5);
					break;
				case 1:
					posY = (posY - (edge+5));
					if(posY < 20)
						posY = 20 + (size-1)*(edge+5);
					break;
				case 3:
					posY = (posY + (edge+5));
					if(posY > 20 + (size-1)*(edge+5))
						posY = 20;
				}
				safe = true;
				
				DrawRect cleartmp = snake.getLast();
				cleartmp.setCol(Color.LIGHT_GRAY);
				cleartmp.setEdge(edge);
				panel.add(cleartmp);
				cleartmp.repaint();
				snake.getLast().setBounds(posX, posY, edge, edge);
				snake.push(snake.getLast());
				snake.removeLast();
				for(int i = 0; i < snake.size(); ++i) {
					if(i < snake.size()-1)
						if(snake.getFirst().getBounds().x == snake.get(i+1).getBounds().x && snake.getFirst().getBounds().y == snake.get(i+1).getBounds().y) {
							JOptionPane.showMessageDialog(cardGame, "GAME OVER");
							System.exit(0);
						}
					snake.get(i).setCol(Color.RED);
					snake.get(i).setEdge(edge);
					panel.add(snake.get(i));
					snake.get(i).repaint();
				}
				
				/*
				// creating snake
				DrawRect snake = new DrawRect();
				snake.setCol(Color.RED);
				snake.setEdge(edge);
				snake.setBounds(posX, posY, edge, edge);
				cardGame.add(snake);
				snake.repaint();
				*/
				
				// creating food
				if(!isFood) {
					isFood = true;
					randPosX = size - 1 - generator.nextInt(size);
					randPosY = size - 1 - generator.nextInt(size);
					//if(!snake.isEmpty())
						//while (rectArray[randPos][randPos].getBounds().x == snake.peek().getBounds().x && rectArray[randPos][randPos].getBounds().y == snake.peek().getBounds().y)
							//randPos = size - generator.nextInt(size);
					food.setCol(Color.GREEN);
					food.setEdge(edge);
					food.setBounds(rectArray[randPosX][randPosY].getBounds());
					panel.add(food);
					food.repaint();
				}
				else {
					DrawRect food = new DrawRect();
					food.setCol(Color.GREEN);
					food.setEdge(edge);
					food.setBounds(rectArray[randPosX][randPosY].getBounds());
					panel.add(food);
					food.repaint();
				}
				
				iterator = 0;
			}
		}
	};
}
