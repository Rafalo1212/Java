import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JLabel;
import java.awt.Font;


public class MainWindow extends JFrame {

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
	CardLayout layout = new CardLayout();
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
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(cards, GAMEPANEL);
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
		
		//////////////////////////////////////
		cards.add(cardGame, GAMEPANEL);
		
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
				obecnyLbl.setText("(OBECNIE: \u0141ATWY)");
			}
		});
		
		hardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setDIFFICULTY(3);
				obecnyLbl.setText("(OBECNIE: TRUDNY)");
			}
		});
		
		medBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Definitions.setDIFFICULTY(2);
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

}
