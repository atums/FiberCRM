import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class ShowPok {
	// ����� �����/���������/���������/����������/�������� ���/����� ��������� �����/������ //
	int horizontalBox;
	String item;
	private int i;	
	File pokFile = new File((new File("").getAbsolutePath())+"\\Base\\"+SelectItems.hsPok+".pok");	
	public ShowPok() { //��� �� ������ ����� ������ � ����� � �������������� ����������.
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
		System.out.println("(���-�� ������): "+horizontalBox);
		Box[] boxX = new Box[horizontalBox];
		JPanel panel = new JPanel();		
		// ��� ���� �������� �������� � ������������� � ������� ��� ������� �����������
		Box box1 = Box.createHorizontalBox();
		JLabel pokNameLabel = new JLabel("��� "+SelectItems.hsPok);
		box1.add(pokNameLabel);
		box1.add(Box.createHorizontalStrut(6));		
		//������ ���� � ��������� ���� ��� ����������
		try {
			FileReader fileReader = new FileReader(pokFile);
			BufferedReader readFile = new BufferedReader(fileReader);
			for( i = 0; i < horizontalBox; i++){
		// ����������� ����� �������������� ������ ��� ����� ������ � ���������� �����			
				item = readFile.readLine();
				String[] resultText = item.split("/");			
				boxX[i] = Box.createHorizontalBox();
				JLabel numPort = new JLabel("Port: "+resultText[0]+"  |  ");
				JLabel distLabel = new JLabel("Distance: "+resultText[1]+"  |  ");
				JLabel fadeLabel = new JLabel("Fade: "+resultText[2]+"  |  ");
				JLabel actLabel = new JLabel("Active: "+resultText[3]+"  |  ");
				JLabel pokLabel = new JLabel("POK: "+resultText[4]+"  |  ");
				JLabel numLabel = new JLabel("Number Port: "+resultText[5]+"  |  ");
				JLabel ekuLabel = new JLabel("EKU: "+resultText[6]+"  |  ");
				JLabel clientLabel = new JLabel("Client: "+resultText[7]+"  |  ");
				boxX[i].add(numPort);
				boxX[i].add(distLabel);
				boxX[i].add(fadeLabel);
				boxX[i].add(actLabel);
				boxX[i].add(pokLabel);
				boxX[i].add(numLabel);
				boxX[i].add(ekuLabel);
				boxX[i].add(clientLabel);			
		}		
		readFile.close();
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		// ��������� �������������� ������ �� ����� ������������
		Box mainBox = Box.createVerticalBox();
		mainBox.setBorder(new EmptyBorder(20,12,12,12));
		mainBox.add(box1);
		mainBox.add(Box.createVerticalStrut(25));		
		for(i = 0; i < horizontalBox; i++) {
			mainBox.add(boxX[i]);
			mainBox.add(Box.createVerticalStrut(17));
		}		
		panel.add(BorderLayout.WEST, mainBox);			
		return panel;
	}	
}
