import javax.swing.*;
import java.awt.event.*;

// В этом классе будет набор методов которые будут отвечать за разные всплывающие диалоговые окна
public class DialogWindows{
	JDialog dialogFrame;
	JLabel dialogLabel;
	JPanel dialogPanel;
	JButton dialogButton;
	JTextField dialogText;
	String askText;

	public void matchEku() {
		System.out.println("Metod 'run' DialogWindow start!");
		askText = ("<html>"+
					"<font size = +1> Выберите кол-во ЭКУ </font>"+
					"</html>");
		
		dialogFrame = new JDialog();
		dialogFrame.setTitle("DialWin");
		dialogPanel = new JPanel();
		dialogLabel = new JLabel(askText, SwingConstants.CENTER);
		dialogText = new JTextField("0", 3);
		dialogButton = new JButton("OK");
		dialogPanel.add(dialogLabel);
		dialogPanel.add(dialogText);
		dialogPanel.add(dialogButton);
		dialogButton.addActionListener(new ButtonListener ());
		dialogFrame.getContentPane().add(dialogPanel, BoxLayout.X_AXIS);
		dialogFrame.setSize(300, 200);
		dialogFrame.setVisible(true);

		
		System.out.println("Metod 'run' DialogWindow stop!");
		
	}
	
	public class ButtonListener implements ActionListener {		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("Listener DialogWindow start!");
			SelectItems.hmEku = Integer.parseInt(dialogText.getText());
			//match = Integer.parseInt(dialogText.getText());
			System.out.println("Кол-во линеек Еку в Диалоговом окне");
			dialogFrame.setVisible(false);
			System.out.println("Закрываем Диалогове окно");
		}
		
		
	}

}
