package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connection.ConnectionJdbcOffline;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BinnacleTwo extends JPanel {

	private JLabel lblIEP11;
	private JLabel lblTitleBinnacle;
	private JLabel lblQuestion;
	private JLabel lblChosenQuestion;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnAdministration;
	private String nameGroup;
	private JTextField textQuestionOne;
	private JTextField textQuestionTwo;
	private JTextField textQuestionThree;
	private JTextField textQuestionFour;
	private JTextField textQuestionFive;
	private JComboBox comboQuestion;
	private PanelHeader panelHeader;
    
	
	public BinnacleTwo(int id) {
				
		this.setBounds(50, 100, 700, 406);
		
		panelHeader=new PanelHeader(id);
		panelHeader.setBounds(25, 25, 650, 77);
		
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 700, 406);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP11.png")));
		
		lblTitleBinnacle = new JLabel("Bitácora II. Perturbación de las ondas");
		lblTitleBinnacle.setForeground(Color.MAGENTA);
		lblTitleBinnacle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitleBinnacle.setBounds(250, 120, 400, 20);
		
		lblQuestion = new JLabel("Escriba las 5 preguntas");
		lblQuestion.setBounds(50, 150, 400, 20);
		
		lblChosenQuestion = new JLabel("Escoja la pregunta elegida");
		lblChosenQuestion.setBounds(380, 150, 400, 20);
		
		comboQuestion = new JComboBox();
		comboQuestion.setBounds(380, 180, 300, 20);
				
		textQuestionOne = new JTextField();
		textQuestionOne.setBounds(50, 180, 300, 20);
		textQuestionOne.setColumns(300);
		
		textQuestionTwo = new JTextField();
		textQuestionTwo.setBounds(50, 205, 300, 20);
		textQuestionTwo.setColumns(300);
		
		textQuestionThree = new JTextField();
		textQuestionThree.setBounds(50, 230, 300, 20);
		textQuestionThree.setColumns(300);
		
		textQuestionFour = new JTextField();
		textQuestionFour.setBounds(50, 255, 300, 20);
		textQuestionFour.setColumns(300);
		
		textQuestionFive = new JTextField();
		textQuestionFive.setBounds(50, 280, 300, 20);
		textQuestionFive.setColumns(300);
		
		btnNext = new JButton("");
		btnNext.setBackground(new Color(0,0,0,0));
		btnNext.setBounds(200, 365, 104, 36);
		btnNext.setIcon(new ImageIcon(IEP.class.getResource("/imgs/next.png")));
		
		btnBack = new JButton("");
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setBounds(50, 365, 104, 36);
		btnBack.setIcon(new ImageIcon(IEP.class.getResource("/imgs/back.png")));
		
		
		btnAdministration = new JButton("");
		btnAdministration.setBackground(new Color(0,0,0,0));
		btnAdministration.setBounds(500, 365, 161, 42);
		btnAdministration.setIcon(new ImageIcon(IEP.class.getResource("/imgs/admon.png")));
		
		
		setLayout(null);
		this.add(panelHeader);
		this.add(btnAdministration);
		this.add(btnNext);
		this.add(btnBack);
		this.add(textQuestionFive);
		this.add(textQuestionFour);
		this.add(textQuestionThree);
		this.add(textQuestionTwo);
		this.add(textQuestionOne);
		this.add(lblQuestion);
		this.add(comboQuestion);
		this.add(lblChosenQuestion);
		this.add(lblTitleBinnacle);
		this.add(lblIEP11);			
	}
}
