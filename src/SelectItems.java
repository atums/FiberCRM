import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;

//Тут в принципе все просто - заглавная страница в которую по средствал toolBar будем загружать моделируемые интерфейсы.

public class SelectItems {
	
	static int hmEku;
	static String hmPok;
	static String hsPok;
	private int i;
	private String[] nameButton = {"Add СУС", "Add ПОК", "Show СУС", "Show ПОК", "Modify СУС", "Modify ПОК", "Create ЕОС", "Show GFL"};

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
		headLine = ("<html>К этой метке применено " +
				"HTML-форматирование, включая: <ul><li> <i>курсив</i>," +
				"<li><b>полужирный</b> <li><font size = +2> увеличение размера </font>" +
				"<li>маркированный список </ul></html>");
		
		mainFrame = new JFrame("OpticalFiber CRM");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		cLabel = new JLabel(headLine, SwingConstants.CENTER);
		
		// Создаем массив классов JButton, чтобы не плодить кучу переменных экземпляра класса JButton
		for( i = 0; i < 8; i++){
		   button[i] = new JButton(nameButton[i]);  // Из архива nameButton присваеваем имена кнопкам соответственно i 
		}

		toolBar = new JToolBar("Tool Panel");
			// Тут в цикле добавляем кнопки на наш toolBar 
			for( i = 0; i < 8; i++){
				toolBar.add(button[i]);
				// и разделяем их сепаратором в соответствующих местах
				if (i == 1 || i == 3 || i == 5 || i == 6) {
					toolBar.addSeparator();
				}
			}
		
		mainPanel.add(cLabel);
		// ТУТ ПОдумать как назначить слушателей на кнопки в цикле
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
		System.out.println("Запускаем перерисовку окна");
		mainPanel.removeAll();
		mainPanel.add(aSus.addPanel());
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore' stop!");
	}
	
	public void goMore2() {		
		System.out.println("Metod 'goMore2' start!");
		aPok = new AddPok();
		System.out.println("Запускаем перерисовку окна");
		mainPanel.removeAll();
		mainPanel.add(aPok.addPanel2());
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore2' stop!");
	}
	
	// Сей метод вызывает модуль модификации ПОК
	public void goMore4() {		
		System.out.println("Вызываем метод Просмотра ПОК");
		sPok = new ShowPok();
		System.out.println("Запускаем перерисовку окна");
		mainPanel.removeAll();
		mainPanel.add(sPok.addPanel());//
		mainPanel.validate();
		mainPanel.repaint();
		System.out.println("Metod 'goMore4' stop!");
	}
	
	public void goMore5() {
		
		System.out.println("Запуск goMore5");
		
	}
	
	// Сей метод вызывает модуль модификации ПОК
	public void goMore6() {		
		System.out.println("Вызываем метод Модификации ПОК");
		mPok = new ModifyPok();
		System.out.println("Запускаем перерисовку окна");
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
						"<font size = +1> Выберите кол-во ЭКУ </font>"+
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
			System.out.println("Запускаем AddPok");

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
					"<font size = +1> Выберите ПОК </font>"+
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
					System.out.println("Выбран поку: "+hsPok);
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
			System.out.println("Запускаем отдельное диаллоговое окно(отдельный экземпляр)");
			
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
					"<font size = +1> Выберите ПОК </font>"+
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
					System.out.println("Выбран поку: "+hmPok);
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
			System.out.println("Запускаем просто проверку");
			JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green");

				//goMore8();

		}
	}
	
}