import java.io.*;

import javax.swing.JOptionPane;

public class Pok {
	File filePok;
	int i;
	
	private boolean save;// используем состояние переменной для понимания есть такая ПОК или ещё нет
	
	public void setPok(String[] aP) {
		if(save == true) {
			try {
				PrintWriter writerPok = new PrintWriter(filePok);
				//writerPok.write(aP[1]+"\n");
				for(i = 1; i < (Integer.parseInt(aP[1])+1); i++){
					
					/*Описание значений для каждого порта*/
// номер порта/дистанция/затухание/активность/ответный ПОК/номер ответного порта/клиент //
					
					writerPok.write(i+"/"+"000"+"/"+"0,00"+"/"+"N"+"/"+"XX-XXX-XXX"+"/"+"0"+"/"+"XX-XXX-XXX|XX|XX"+"/"+"Client"+"/"+"\n");
				}
				writerPok.close();
				JOptionPane.showMessageDialog(null, "ПОК сохранен");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Такой ПОК уже существует");
			System.out.println("Ни чего не сохраняем");
		}
	}
	
	public void setPokName(String sPN) {
		//namePok = sPN;
		filePok = new File((new File("").getAbsolutePath())+"\\Base\\"+sPN+".pok");
		
		try {
	        //проверяем, что если файл не существует то создаем его
	        if(!filePok.exists()){
	        	filePok.createNewFile();
	            System.out.println("newFile");
	            save = true;
	            // Добавляем в специальный список данный СУ
	    		RollSusPok rollEku = new RollSusPok();
	    		rollEku.setRollPok(sPN);
	        } else {
	        	//Тут необходимо вернуть сообщение о существующем файле !!! И поинтересоваться о замене!!!!
	        	System.out.println("Такой ПОК уже есть");
	        	save = false;
	        }
		} catch(Exception ex){
			ex.printStackTrace();
		}	
	}	
}
