import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;

//��� � �������� ��� ������ - ��������� �������� � ������� �� ��������� toolBar ����� ��������� ������������ ����������.

public class SelectItems {
	
	static int hmEku;
	static String hmPok;
	static String hsPok;
	private int i;
	private String[] nameButton = {"Add ���", "Add ���", "Show ���", "Show ���", "Modify ���", "Modify ���", "Create ���", "Show GFL"};

	JFrame mainFrame;
	JLabel cLabel;
	JPanel mainPanel;
	JToolBar toolBar;	
	String headLine;
	JButton[] button = new JButton[8];
	AddSus aSus;
	AddPok aPok;
	ModifyPok mPok;
	ShowPok sPok;
	JDialog dialogFrame;
	JLabel dialogLabel;
	JPanel dialogPanel;
	JButton dialogButton;
	JTextField dialogText;
	String askText;
	JList<String> list;
	JList<String> listSP;
	
	public static void main(String[] args) {
		SelectItems gui = new SelectItems();
		gui.guiPanel();
	}
	
	public void guiPanel() {
		headLine = ("<html>� ���� ����� ��������� " +
				"HTML-��������������, �������: <ul><li> <i>������</i>," +
				"<li><b>����������</b> <li><font size = +2> ���������� ������� </font>" +
				"<li>������������� ������ </ul></html>");
		
		mainFrame = new JFrame("OpticalFiber CRM");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		cLabel = new JLabel(headLine, SwingConstants.CENTER);
		
		// ������� ������ ������� JButton, ����� �� ������� ���� ���������� ���������� ������ JButton
		for( i = 0; i < 8; i++){
		   button[i] = new JButton(nameButton[i]);  // �� ������ nameButton ����������� ����� ������� �������������� i 
		}

		toolBar = new JToolBar("Tool Panel");
			// ��� � ����� ��������� ������ �� ��� toolBar 
			for( i = 0; i < 8; i++){
				toolBar.add(button[i]);
				// � ��������� �� ����������� � ��������������� ������
				if (i == 1 || i == 3 || i == 5 || i == 6) {
					toolBar.addSeparator();
				}
			}
		
		mainPanel.add(cLabel);
		// ��� �������� ��� ��������� ���������� �� ������ � �����
		button[0].addActionListener(new B1Listener()); // AddSus
		button[1].addActionListener(new B2Listener()); // AddPok
		//button[2].addActionListener(new B3Listener()); // ShowSus
		button[3].addActionListener(new B4Listener()); // ShowPok
		button[4].addActionListener(new B5Listener()); // ModifySus
		button[5].addActionListener(new B6Listener()); // ModifyPok
		//button[6].addActionListener(new B7Listener()); // CreateEos
		button[7].addActionListener(new B8Listener()); // ShowGfl
		
		mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		mainFrame.getContentPane().add(BorderLayout.NORTH, toolBar);
		mainFrame.setSize(800, 600);
		mainFrame.setVisible(true);		
	}
	
	public void goMore() {		
		System.out.println("Metod 'goMore' start!");
		System.out.println("hmEku = "+hmEku);
		aSus = new AddSus();
		System.out.println("��������� ����������� ����");
		mainPanel.removeAll();
		mainPanel.add(aSus.addPanel());
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore' stop!");
	}
	
	public void goMore2() {		
		System.out.println("Metod 'goMore2' start!");
		aPok = new AddPok();
		System.out.println("��������� ����������� ����");
		mainPanel.removeAll();
		mainPanel.add(aPok.addPanel2());
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore2' stop!");
	}
	
	// ��� ����� �������� ������ ����������� ���
	public void goMore4() {		
		System.out.println("�������� ����� ��������� ���");
		sPok = new ShowPok();
		System.out.println("��������� ����������� ����");
		mainPanel.removeAll();
		mainPanel.add(sPok.addPanel());//
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore4' stop!");
	}
	
	public void goMore5() {
		
		System.out.println("������ goMore5");
		
	}
	
	// ��� ����� �������� ������ ����������� ���
	public void goMore6() {		
		System.out.println("�������� ����� ����������� ���");
		mPok = new ModifyPok();
		System.out.println("��������� ����������� ����");
		mainPanel.removeAll();
		mainPanel.add(mPok.addPanel());//
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore6' stop!");
	}
	
	public class B1Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("Metod 'run' DialogWindow start!");
			askText = ("<html>"+
						"<font size = +1> �������� ���-�� ��� </font>"+
						"</html>");		
			dialogFrame = new JDialog();
			dialogFrame.setTitle("Dialog Eku");
			dialogPanel = new JPanel();
			dialogLabel = new JLabel(askText, SwingConstants.CENTER);
			dialogText = new JTextField("0", 3);
			dialogButton = new JButton("OK");
			dialogPanel.add(dialogLabel);
			dialogPanel.add(dialogText);
			dialogPanel.add(dialogButton);
			dialogButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					hmEku = Integer.parseInt(dialogText.getText());
					dialogFrame.setVisible(false);
					goMore();
				}
			});
			dialogFrame.getContentPane().add(dialogPanel, BoxLayout.X_AXIS);
			dialogFrame.setSize(300, 200);
			dialogFrame.setVisible(true);			
			System.out.println("Metod 'run' DialogWindow stop!");
		}
	}
	
	public class B2Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("��������� AddPok");

				goMore2();

		}
	}
	
	public class B4Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("Metod 'run' DialogWindow start!");
					
			listSP = new JList<>();
			listSP.setLayoutOrientation(JList.VERTICAL);
			listSP.setVisibleRowCount(0);
			
			JScrollPane listScroll = new JScrollPane(listSP);
			listScroll.setPreferredSize(new Dimension(100, 100));
			
	        try {
	        	BufferedReader buffer = new BufferedReader(new FileReader(new File("pok.rol")));
	            String item;
	            DefaultListModel<String> listModel = new DefaultListModel<String>();
	            while ((item = buffer.readLine()) != null) {
	                listModel.addElement(item);
	            }
	            listSP.setModel(listModel);
	            buffer.close();
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
			askText = ("<html>"+
					"<font size = +1> �������� ��� </font>"+
					"</html>");
			dialogFrame = new JDialog();
			dialogFrame.setTitle("Dialog Pok");
			dialogPanel = new JPanel();
			dialogLabel = new JLabel(askText, SwingConstants.CENTER);
			dialogButton = new JButton("OK");
			
			dialogPanel.add(dialogLabel);
			dialogPanel.add(listScroll);
			dialogPanel.add(dialogButton);
			dialogButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					hsPok = listSP.getSelectedValue();
					dialogFrame.setVisible(false);
					System.out.println("������ ����: "+hsPok);
					goMore4();
				}
			});
			dialogFrame.getContentPane().add(dialogPanel, BoxLayout.X_AXIS);
			dialogFrame.setSize(300, 200);
			dialogFrame.setVisible(true);
					
			System.out.println("Metod 'run' DialogWindow stop!");
		}
	}
	
	public class B5Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("��������� ��������� ����������� ����(��������� ���������)");
			
			WindowDialog dialog = new WindowDialog();
			
			dialog.okListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					goMore5();
				}
			};
			
			//goMore5();
			
		}
	}
	
	public class B6Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("Metod 'run' DialogWindow start!");
					
			list = new JList<>();
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(0);
			
			JScrollPane listScroll = new JScrollPane(list);
			listScroll.setPreferredSize(new Dimension(100, 100));
			
	        try {
	        	BufferedReader buffer = new BufferedReader(new FileReader(new File("pok.rol")));
	            String item;
	            DefaultListModel<String> listModel = new DefaultListModel<String>();
	            while ((item = buffer.readLine()) != null) {
	                listModel.addElement(item);
	            }
	            list.setModel(listModel);
	            buffer.close();
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
			askText = ("<html>"+
					"<font size = +1> �������� ��� </font>"+
					"</html>");
			dialogFrame = new JDialog();
			dialogFrame.setTitle("Dialog Pok");
			dialogPanel = new JPanel();
			dialogLabel = new JLabel(askText, SwingConstants.CENTER);
			dialogButton = new JButton("OK");
			
			dialogPanel.add(dialogLabel);
			dialogPanel.add(listScroll);
			dialogPanel.add(dialogButton);
			dialogButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					hmPok = list.getSelectedValue();
					dialogFrame.setVisible(false);
					System.out.println("������ ����: "+hmPok);
					goMore6();
				}
			});
			dialogFrame.getContentPane().add(dialogPanel, BoxLayout.X_AXIS);
			dialogFrame.setSize(300, 200);
			dialogFrame.setVisible(true);
					
			System.out.println("Metod 'run' DialogWindow stop!");
		}
	}
	
	public class B8Listener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("��������� ������ ��������");
			JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green");

				//goMore8();

		}
	}
	
}