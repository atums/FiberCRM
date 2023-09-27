// � ������ ������ ����� ��������� ����� � ����( �������� � ��������� ����� ��� ����, ����� ����� ���� ��������� � �� ��� ��������� ����� �� ����.) 
import java.io.*;

import javax.swing.JOptionPane;

public class Sus {
	
	private int cableNum;
	private int modulNum;
	private int i;
	private int j;
	private int a;
	private boolean save;// ���������� ��������� ���������� ��� ��������� ���� ����� ��� ��� ��� ���
	String name;
	String nameEkuFile;
	String pathTwo;
	String pathThree; //��� � ��� ���� � ����� � ��������� ���
	String pathFour;
	File fileNew; //��� ���������� ��� ������ � �������� ��������� ���
	File fileNewEku;
	String[][] archEku;
	PrintWriter writerEku;
	//RollEkuPok rollEku = new RollEkuPok();
	
	public void setSus (String eN) {
		name = eN;

		String path = new File("").getAbsolutePath();
		pathTwo = (path+"\\Base\\"+name+"\\");
		pathThree = (pathTwo+"aSystem.sus");	
		File dir = new File(pathTwo);
		dir.mkdirs();	
		fileNew = new File(pathThree);
		
		try {
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!fileNew.exists()){
	            fileNew.createNewFile();
	            System.out.println("newFile");
	            save = true;
	            // ��������� � ����������� ������ ������ ��
	    		RollSusPok rollSus = new RollSusPok();
	    		rollSus.setRollSus(name);
	    		
	        } else {
	        	//��� ���������� ������� ��������� � ������������ ����� !!! � ���������������� � ������!!!!
	        	System.out.println("����� ��� ��� ����");
	        	save = false;
	        }
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void setEku (String[][] arch) {
		//������ ��� ������ �� ���
		archEku = arch;	
		if( save == true) {
			saveF();
			System.out.println("C��������");
		} else {
			JOptionPane.showMessageDialog(null, "����� ��� ��� ����������"); // �������� ���������� ���� � �������� � ��������������.
			System.out.println("�� ���� �� ���������");
		}
	}
	
	public void saveF() {
		// ����� �������� ������ � ��������� ��������� ����.
		try {
			PrintWriter writerSus = new PrintWriter(fileNew);
			writerSus.write(name+"\n");
			for(i = 0; i < SelectItems.hmEku; i++) {
				for(j = 0; j < 3; j++) {
					writerSus.write(archEku[j][i]);
					if(j != 2) {
						writerSus.write("/");
					}
				}
				writerSus.write("\n");
			}
			writerSus.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
		saveEku();
	}
	// ������ ����� ��� ���������� ������ ���
	public void saveEku() {
		try{
			for(a = 0; a < SelectItems.hmEku; a++) {
				if(archEku[0][a] .equals("")) { 
					System.out.println("����������");
				} else {
				System.out.println(archEku[0][a]);
				nameEkuFile = archEku[0][a];
				
				pathFour = (pathTwo+nameEkuFile+".eku");

				fileNewEku = new File(pathFour);
				fileNewEku.createNewFile();
				//������ ��� ���� ��������� ����� ��� ������������ �� ��������� ������� (���-�� �������) ����� ������ ����� ��������� ������������ ������� ������
				cableNum = Integer.parseInt(archEku[1][a]);
				if(cableNum >= 48) {
					createEku48_316();
				} else {
					createEku4_24();
					}				
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void createEku48_316() {
		//��������� ��� ������� 48 - 316 (�.�. ������ ������� 12 ������� � ������)
		try {
			writerEku = new PrintWriter(fileNewEku);
			System.out.println(cableNum);
			modulNum = (cableNum/12)+1;
			for(i = 1; i < modulNum; i++) {
				for(j = 1; j < 13; j++) {
					if(j < 10) {
						writerEku.write(i+"/"+"0"+j+"/"+"null"+"\n");
					} else {
						writerEku.write(i+"/"+j+"/"+"null"+"\n");
					}
				}
			}
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		writerEku.close();
		JOptionPane.showMessageDialog(null, "��� ��������");
		return;
	}
	
	public void createEku4_24() {
		//��������� ��� ������� 4 - 24 (�.�. ������ �� ������� 12 ������� � ������)
		try {
			writerEku = new PrintWriter(fileNewEku);
			System.out.println(cableNum);
			modulNum = (cableNum/4)+1;
			for(i = 1; i < modulNum; i++) {
				for(j = 1; j < 5; j++) {
						writerEku.write(i+"/"+"0"+j+"/"+"null"+"\n");		 
				}
			}
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		writerEku.close();
		JOptionPane.showMessageDialog(null, "��� ��������");
		return;
	}	
}
