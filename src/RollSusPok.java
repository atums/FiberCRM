// Класс для добавления и выдачи из списка существующих ПОК и ЕКУ
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
	// !!! Тут я на верное ошибаюсь загружая сразу 2 архива!!! это повлияет на быстродействие, но зато описывает применение конструктора, так, что пока оставим так.
		try {
			FileReader fileReader = new FileReader(susFile);
			BufferedReader reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null) {
				listSusRoll.add(line);
				System.out.println("В списке СУС : "+line);
			}
			reader.close();
			
			FileReader fileReader2 = new FileReader(pokFile);
			BufferedReader reader2 = new BufferedReader(fileReader2);
			while((line = reader2.readLine()) != null) {
				listPokRoll.add(line);
				System.out.println("В списке ПОК : "+line);
			}
			reader2.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public void setRollSus(String sus) {
		susRoll = sus;
		System.out.println("Такой СУС мы передали в Roll"+ pokRoll);
		//Излишне конечно проверять существование записи в файле если отсутствует сам файл!, но думаю, что в таком случае можно будет запускать проверку
		if(listSusRoll.indexOf(susRoll) == -1) {
			listSusRoll.add(susRoll);
			// Записать в файл изменение архива
			try {
				FileWriter fileWriter = new FileWriter(susFile);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for(String line : listSusRoll ) {
					writer.write(line+"\n");
				}
				writer.close();
				System.out.println("Запись в файл");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Такой СУС уже существует");
			System.out.println("Что-то пошло не так в RollSusPok");
		}
	}
	
	public void setRollPok(String pok) {
		pokRoll = pok;
		System.out.println("Такой ПОК мы передали в Roll"+ pokRoll);
		System.out.println("Что нам скажет метод сравнения того, что мы получили и то что есть в списке"+listPokRoll.indexOf(pokRoll));
		//Излишне конечно проверять существование записи в файле если отсутствует сам файл!, но думаю, что в таком случае можно будет запускать проверку
		if(listPokRoll.indexOf(pokRoll) == -1) {
			listPokRoll.add(pokRoll);
			// Записать в файл изменение архива
			try {
				FileWriter fileWriter2 = new FileWriter(pokFile);
				BufferedWriter writer2 = new BufferedWriter(fileWriter2);
				for(String line2 : listPokRoll ) {
					writer2.write(line2+"\n");
				}
				writer2.close();
				System.out.println("Запись в файл");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Такой ПОК уже существует");
			System.out.println("Что-то пошло не так в RollSusPok");
		}				
	}
	
	public void getRollSus() {
		// Тут запрашиваем данные из архива существующих СУС		
	}
	
	public void getRollPok() {
		// Тут запрашиваем данные из архива существующих ПОК	
	}
}
