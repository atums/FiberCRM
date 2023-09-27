import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;
import java.io.*;

//Класс отвечает за Модификацию (наполнение данными или их исправление) в ПОК.
public class ModifyPok {
	// номер порта/дистанция/затухание/активность/ответный ПОК/номер ответного порта/ЕКУ-ВОЛОКНО/клиент //
	int horizontalBox = 64; 
	String item;
	private int i;
	JTextField[] arrPort = new JTextField[horizontalBox];
	JTextField[] arrDist = new JTextField[horizontalBox];
	JTextField[] arrFade = new JTextField[horizontalBox];
	JTextField[] arrAct = new JTextField[horizontalBox];
	JTextField[] arrPok = new JTextField[horizontalBox];
	JTextField[] arrNum = new JTextField[horizontalBox];
	JTextField[] arrEku = new JTextField[horizontalBox];
	JTextField[] arrClient = new JTextField[horizontalBox];
	
	String[][] dataPok = new String[7][horizontalBox];	
	File pokFile = new File((new File("").getAbsolutePath())+"\\Base\\"+SelectItems.hmPok+".pok");
	
	public ModifyPok() { //Тут мы узнаем число портов в кросс и инициализируем переменную.
		int counter = 0;
		try {
			FileReader fileReader1 = new FileReader(pokFile);
			BufferedReader readFile = new BufferedReader(fileReader1);
			while((item = readFile.readLine()) != null) {
				counter++;
			}
			horizontalBox = counter;
			readFile.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public JPanel addPanel() {
		System.out.println("(Кол-во портов): "+horizontalBox);
		Box[] boxX = new Box[horizontalBox];
		JPanel panel = new JPanel();		
		for (i = 0; i < horizontalBox; i++) {
			arrDist[i] = new JTextField();
			arrFade[i] = new JTextField();
			arrAct[i] = new JTextField();
			arrPok[i] = new JTextField();
			arrNum[i] = new JTextField();
			arrEku[i] = new JTextField();
			arrClient[i] = new JTextField();
		}
		// Тут надо вставить описание с наименованием и данными ПОК который редактируем
		Box box1 = Box.createHorizontalBox();
		JLabel pokNameLabel = new JLabel("ПОК "+SelectItems.hmPok);
		box1.add(pokNameLabel);
		box1.add(Box.createHorizontalStrut(7));		
		//Читаем файл и заполняем поля его содержимым
		try {
			FileReader fileReader2 = new FileReader(pokFile);
			BufferedReader readFile = new BufferedReader(fileReader2);
			for( i = 0; i < horizontalBox; i++){
		// Настраиваем общую горизонтальную панель для ввода данных о конкретном порте			
			item = readFile.readLine();
			String[] resultText = item.split("/");	
			
			boxX[i] = Box.createHorizontalBox();
			//JLabel numPort = new JLabel("Port"+resultText[0]+" : ");
			JLabel numPort = new JLabel("Port"+resultText[0]+" : ");
			JLabel distLabel = new JLabel("Dist ");
			JLabel fadeLabel = new JLabel("Fade ");
			JLabel actLabel = new JLabel("Act ");
			JLabel pokLabel = new JLabel("Pok ");
			JLabel numLabel = new JLabel("Num ");
			JLabel EkuLabel = new JLabel("Eku ");
			JLabel clientLabel = new JLabel("Client ");
			
			arrDist[i] = new JTextField(resultText[1], 4);
			arrFade[i] = new JTextField(resultText[2], 4);	
			arrAct[i] = new JTextField(resultText[3], 1);
			arrPok[i] = new JTextField(resultText[4], 10);
			arrNum[i] = new JTextField(resultText[5], 2);
			arrEku[i] = new JTextField(resultText[6], 16);
			arrClient[i] = new JTextField(resultText[7], 6);
			
			boxX[i].add(numPort);
			boxX[i].add(distLabel);
			boxX[i].add(arrDist[i]);
			boxX[i].add(fadeLabel);
			boxX[i].add(arrFade[i]);
			boxX[i].add(actLabel);
			boxX[i].add(arrAct[i]);
			boxX[i].add(pokLabel);
			boxX[i].add(arrPok[i]);
			boxX[i].add(numLabel);
			boxX[i].add(arrNum[i]);
			boxX[i].add(EkuLabel);
			boxX[i].add(arrEku[i]);
			boxX[i].add(clientLabel);
			boxX[i].add(arrClient[i]);
			
		}		
		readFile.close();
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		
		// Настраиваем горизонтальную панель с кнопками
		Box box8 = Box.createHorizontalBox();
		JButton save = new JButton("Save");
		JButton cancel = new JButton("Отмена");
		box8.add(Box.createHorizontalGlue());
		box8.add(save);
		box8.add(Box.createHorizontalStrut(12));
		box8.add(cancel);	
		// Размещаем горизонтальные панели на одной вертикальной
		Box mainBox = Box.createVerticalBox();
		mainBox.setBorder(new EmptyBorder(20,12,12,12));
		mainBox.add(box1);
		mainBox.add(Box.createVerticalStrut(25));
		
		for(i = 0; i < horizontalBox; i++) {
			mainBox.add(boxX[i]);
			mainBox.add(Box.createVerticalStrut(17));
		}		
		mainBox.add(box8);
		panel.add(BorderLayout.WEST, mainBox);		
		save.addActionListener(new SaveListener());
		cancel.addActionListener(new CancelListener());	
		return panel;
	}
	
	public void savePok() {		
		//	Сохраняем
		int count = 1;
		try {
			FileWriter fileWriter = new FileWriter(pokFile);
			BufferedWriter fWriter = new BufferedWriter(fileWriter);
			for (i = 0; i < horizontalBox; i++) {
				fWriter.write(count+"/"+dataPok[0][i]+"/"+dataPok[1][i]+"/"+dataPok[2][i]+"/"+dataPok[3][i]+"/"+dataPok[4][i]+"/"+dataPok[5][i]+"/"+dataPok[6][i]+"\n");
				count++;
			}
				fWriter.close();
				JOptionPane.showMessageDialog(null, "ПОК "+SelectItems.hmPok+"модифицирован");
			} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
		//тут выдераем данные полей и передаем в Sus как параметр для заполнения массива POK	
			for(i = 0; i < horizontalBox; i++) {		
				dataPok[0][i] = arrDist[i].getText();
				dataPok[1][i] = arrFade[i].getText();
				dataPok[2][i] = arrAct[i].getText();
				dataPok[3][i] = arrPok[i].getText();
				dataPok[4][i] = arrNum[i].getText();
				dataPok[5][i] = arrEku[i].getText();
				dataPok[6][i] = arrClient[i].getText();
			}
		savePok();
		}
	}
	
	public class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			//Тут отчищаем все поля	
			for(i = 0; i < horizontalBox; i++) {
				arrDist[i].setText("000");
				arrFade[i].setText("1,00");
				arrAct[i].setText("N");
				arrPok[i].setText("XX-XXX-XXX");
				arrNum[i].setText("0");
				arrEku[i].setText("XX-XXX-XXX/XX/XX");
				arrClient[i].setText("Client");
			}
		}
	}
}
