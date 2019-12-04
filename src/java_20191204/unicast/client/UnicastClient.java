package java_20191204.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener {
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	
	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		jframe = new JFrame("Unicast Chatting");
		jta = new JTextArea("", 20, 50);
		
		/*******************북 시작********************************/
		JPanel j1 = new JPanel();
		JLabel jl1 = new JLabel("User ID : ["+id+"]");
		JLabel jl2 = new JLabel("Server IP : " +ip);
		j1.setLayout(new BorderLayout());
		j1.add(jl1,BorderLayout.CENTER);
		j1.add(jl2,BorderLayout.EAST);
		
		/*******************북 끝********************************/
		
		
		/*******************중앙 시작********************************/
		jframe.add(jta);
		JScrollPane jsp = new JScrollPane(jta,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setBackground(new Color(255,255,150));		
		jta.setEditable(false);
		/*******************중앙 끝********************************/
		
		
		/*******************하단 시작********************************/
		JPanel j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		j2.setLayout(new BorderLayout());
		j2.add(jtf, BorderLayout.CENTER);
		j2.add(jbtn,BorderLayout.EAST);
		/*******************하단 끝*********************************/
		
		
		
		jframe.add(j1,BorderLayout.NORTH);
		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j2, BorderLayout.SOUTH);
		
		jframe.pack();
		jframe.setResizable(false);
		jframe.setVisible(true);
		
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
		
		jframe.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			public void windowOpened(WindowEvent e){
				jtf.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("바보바보", "192.168.0.210", 3000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String message = jtf.getText();
		if(obj == jbtn){
			jta.append(id + ":" +jtf.getText()+"\n");
			jtf.setText("");
		}else if (obj == jtf){
			jta.append(id + ":" +jtf.getText()+"\n");
			jtf.setText("");
		}
		
	}
}
