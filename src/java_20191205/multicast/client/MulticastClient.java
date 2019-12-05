package java_20191205.multicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MulticastClient implements ActionListener {
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	private BufferedReader br;
	private BufferedWriter bw;

	public MulticastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;

		jframe = new JFrame("Unicast Chatting");
		jta = new JTextArea("", 20, 50);

		/******************* 북 시작 ********************************/
		JPanel j1 = new JPanel();
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		JLabel jl2 = new JLabel("Server IP : " + ip);
		j1.setLayout(new BorderLayout());
		j1.add(jl1, BorderLayout.CENTER);
		j1.add(jl2, BorderLayout.EAST);

		/******************* 북 끝 ********************************/

		/******************* 중앙 시작 ********************************/
		jframe.add(jta);
		JScrollPane jsp = new JScrollPane(jta,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setBackground(new Color(255, 255, 150));
		jta.setEditable(false);
		/******************* 중앙 끝 ********************************/

		/******************* 하단 시작 ********************************/
		JPanel j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		j2.setLayout(new BorderLayout());
		j2.add(jtf, BorderLayout.CENTER);
		j2.add(jbtn, BorderLayout.EAST);
		/******************* 하단 끝 *********************************/

		jframe.add(j1, BorderLayout.NORTH);
		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j2, BorderLayout.SOUTH);

		jframe.pack();
		jframe.setResizable(false);
		jframe.setVisible(true);

		jbtn.addActionListener(this);
		jtf.addActionListener(this);

		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					bw.write("exit");
					bw.newLine();
					bw.flush();
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.exit(0);
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
	}

	private void connect() {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket(ip, port);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			MultiClientThread mct = new MultiClientThread(br, jta);
			Thread t = new Thread(mct);
			t.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MulticastClient("바보바보", "192.168.0.210", 3000).connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String message = jtf.getText();
		if (obj == jbtn) {
			try {
				bw.write(id + ":" +message);
				bw.newLine();
				bw.flush();
				
				
				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (obj == jtf) {
			try {
				bw.write(id + ":" +message);
				bw.newLine();
				bw.flush();
				

				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
