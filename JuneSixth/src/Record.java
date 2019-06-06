import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Record extends JFrame{
	public static final int WIDTH = 300;
	public static final int WEIGHT = 200;
	public static final int RECORD_NUM = 10;
	int [] record = new int [10]; //���� record 10���� �о�´ٰ� ����.
	
	public Record() {
		super("Record");
		setSize(WIDTH, WEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		//���ڵ� ���� �о����
		try {			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("record"));
			record = (int[])inputStream.readObject();
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			System.exit(0);
		}
		catch(ClassNotFoundException e) {
			System.exit(0);
		}
		catch(IOException e) {
			System.exit(0);
		}
		//���ڵ� ����
		JLabel TextLabel =new JLabel("      RECORD"); 
		TextLabel.setFont(new Font("Serif", Font.BOLD, 19));
		add(TextLabel, BorderLayout.NORTH);
		//���ڵ� ���
		JPanel RecordPanel = new JPanel();
		RecordPanel.setLayout(new GridLayout(RECORD_NUM/2,2));
		JLabel[] scoreL = new JLabel[RECORD_NUM];
		for(int i=0; i<scoreL.length; i++)
			scoreL[i] = new JLabel(Integer.toString(record[i]));
		for(int i=0; i<scoreL.length; i++)
			RecordPanel.add(scoreL[i]);
		add(RecordPanel, BorderLayout.CENTER);
	}
}
