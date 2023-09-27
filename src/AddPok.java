import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

public class AddPok {
	Pok pok = new Pok();
	JTextField pokName;
	JLabel pokHead;
	JTextField numberPorts;
	JTextField plug;
	JLabel hLine;
	Box box1;
	Box box2;
	Box box3;
	Box mainBox;
	String[] poku;
	String 	headLinePok = ("<html>� ���� ����� ��������� " +
			"HTML-��������������, �������: <ul><li> <i>������</i>," +
			"<li><b>����������</b> <li><font size = +2> ���������� ������� </font>" +
			"<li>������������� ������ </ul></html>");
	
	public JPanel addPanel2() {
		JPanel panel2 = new JPanel();

		pokName = new JTextField("", 15);
		numberPorts = new JTextField("0", 3);
		plug = new JTextField("FC", 3);
		
		JLabel pokLabel = new JLabel("�������� ���: ");
		JLabel pokLabelNum = new JLabel("Number Ports");
		JLabel pokLabelPlug = new JLabel("Plug");
		
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("������");
	
		box1 = Box.createHorizontalBox();
		pokHead = new JLabel(headLinePok, SwingConstants.CENTER);
		box1.add(pokHead);
		box1.add(Box.createHorizontalStrut(6));
		box2 = Box.createHorizontalBox();
		box2.add(pokLabel);
		box2.add(Box.createHorizontalStrut(6));
		box2.add(pokName);
		box2.add(pokLabelNum);
		box2.add(numberPorts);
		box2.add(pokLabelPlug);
		box2.add(plug);
		box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalGlue());
		box3.add(ok);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(cancel);	
		mainBox = Box.createVerticalBox();
		mainBox.setBorder(new EmptyBorder(20,12,12,12));
		mainBox.add(box1);
		mainBox.add(Box.createVerticalStrut(25));
		mainBox.add(box2);
		mainBox.add(Box.createVerticalStrut(17));
		mainBox.add(box3);		
		panel2.add(BorderLayout.WEST, mainBox);		
		ok.addActionListener(new OkListener());
		cancel.addActionListener(new CancelListener());		
		return panel2;	
	}
	
	public void savePok() {
		pok.setPokName(pokName.getText());
		
		poku = new String[3];
		poku[0] = pokName.getText();
		poku[1] = numberPorts.getText();
		poku[2] = plug.getText();
		
		pok.setPok(poku);
	}
	
	public class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
		//����� ������ ����� ����� � ������� ����� ������� ��� ������������ ���� � ��(������� � ����� � ��������� � ������ - ���� �������� ������������.
		savePok();

		}
	}
	
	public class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			//��� �������� ��� ����
			pokName.setText("");	
			numberPorts.setText("");
			plug.setText("");
		}
	}
}
