// ����� ��� ���������� � ������ �� ������ ������������ ��� � ���
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;


public class RollSusPok {
	public int i;
	String susRoll;
	String pokRoll;
	File susFile;
	File pokFile;
	private ArrayList<String> listSusRoll = new ArrayList<String>();
	private ArrayList<String> listPokRoll = new ArrayList<String>();
	
	public RollSusPok() {
		String line;
		System.out.println("Roll");
		susFile = new File("sus.rol");
		pokFile = new File("pok.rol");
	// !!! ��� � �� ������ �������� �������� ����� 2 ������!!! ��� �������� �� ��������������, �� ���� ��������� ���������� ������������, ���, ��� ���� ������� ���.
		try {
			FileReader fileReader = new FileReader(susFile);
			BufferedReader reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null) {
				listSusRoll.add(line);
				System.out.println("� ������ ��� : "+line);
			}
			reader.close();
			
			FileReader fileReader2 = new FileReader(pokFile);
			BufferedReader reader2 = new BufferedReader(fileReader2);
			while((line = reader2.readLine()) != null) {
				listPokRoll.add(line);
				System.out.println("� ������ ��� : "+line);
			}
			reader2.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public void setRollSus(String sus) {
		susRoll = sus;
		System.out.println("����� ��� �� �������� � Roll"+ pokRoll);
		//������� ������� ��������� ������������� ������ � ����� ���� ����������� ��� ����!, �� �����, ��� � ����� ������ ����� ����� ��������� ��������
		if(listSusRoll.indexOf(susRoll) == -1) {
			listSusRoll.add(susRoll);
			// �������� � ���� ��������� ������
			try {
				FileWriter fileWriter = new FileWriter(susFile);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for(String line : listSusRoll ) {
					writer.write(line+"\n");
				}
				writer.close();
				System.out.println("������ � ����");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "����� ��� ��� ����������");
			System.out.println("���-�� ����� �� ��� � RollSusPok");
		}
	}
	
	public void setRollPok(String pok) {
		pokRoll = pok;
		System.out.println("����� ��� �� �������� � Roll"+ pokRoll);
		System.out.println("��� ��� ������ ����� ��������� ����, ��� �� �������� � �� ��� ���� � ������"+listPokRoll.indexOf(pokRoll));
		//������� ������� ��������� ������������� ������ � ����� ���� ����������� ��� ����!, �� �����, ��� � ����� ������ ����� ����� ��������� ��������
		if(listPokRoll.indexOf(pokRoll) == -1) {
			listPokRoll.add(pokRoll);
			// �������� � ���� ��������� ������
			try {
				FileWriter fileWriter2 = new FileWriter(pokFile);
				BufferedWriter writer2 = new BufferedWriter(fileWriter2);
				for(String line2 : listPokRoll ) {
					writer2.write(line2+"\n");
				}
				writer2.close();
				System.out.println("������ � ����");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "����� ��� ��� ����������");
			System.out.println("���-�� ����� �� ��� � RollSusPok");
		}				
	}
	
	public void getRollSus() {
		// ��� ����������� ������ �� ������ ������������ ���		
	}
	
	public void getRollPok() {
		// ��� ����������� ������ �� ������ ������������ ���	
	}
}
