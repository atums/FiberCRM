import java.io.*;

import javax.swing.JOptionPane;

public class Pok {
	File filePok;
	int i;
	
	private boolean save;// ���������� ��������� ���������� ��� ��������� ���� ����� ��� ��� ��� ���
	
	public void setPok(String[] aP) {
		if(save == true) {
			try {
				PrintWriter writerPok = new PrintWriter(filePok);
				//writerPok.write(aP[1]+"\n");
				for(i = 1; i < (Integer.parseInt(aP[1])+1); i++){
					
					/*�������� �������� ��� ������� �����*/
// ����� �����/���������/���������/����������/�������� ���/����� ��������� �����/������ //
					
					writerPok.write(i+"/"+"000"+"/"+"0,00"+"/"+"N"+"/"+"XX-XXX-XXX"+"/"+"0"+"/"+"XX-XXX-XXX|XX|XX"+"/"+"Client"+"/"+"\n");
				}
				writerPok.close();
				JOptionPane.showMessageDialog(null, "��� ��������");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "����� ��� ��� ����������");
			System.out.println("�� ���� �� ���������");
		}
	}
	
	public void setPokName(String sPN) {
		//namePok = sPN;
		filePok = new File((new File("").getAbsolutePath())+"\\Base\\"+sPN+".pok");
		
		try {
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!filePok.exists()){
	        	filePok.createNewFile();
	            System.out.println("newFile");
	            save = true;
	            // ��������� � ����������� ������ ������ ��
	    		RollSusPok rollEku = new RollSusPok();
	    		rollEku.setRollPok(sPN);
	        } else {
	        	//��� ���������� ������� ��������� � ������������ ����� !!! � ���������������� � ������!!!!
	        	System.out.println("����� ��� ��� ����");
	        	save = false;
	        }
		} catch(Exception ex){
			ex.printStackTrace();
		}	
	}	
}
