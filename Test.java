package com.example.libs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class Test extends JFrame implements ActionListener{


//�����ĸ���
JTextField jtf1 = new JTextField();
JTextField jtf2 = new JTextField();
JTextField jtf3 = new JTextField();
JTextField jtf4 = new JTextField();


JButton jb1 = new JButton("url解密");

JButton jb2 = new JButton("tea解密");

JButton jb3 = new JButton("tea加密");

JButton jb4 = new JButton("url加密");


public Test(){

setBounds(800,800,800,800);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setVisible(true);

setLayout(null);
//设置文本框

jtf1.setBounds(50,40,580,80);

add(jtf1);

jtf2.setBounds(50, 200, 580, 80);

add(jtf2);

jtf3.setBounds(50,350,580,80);

add(jtf3);

jtf4.setBounds(50,500,580,80);

add(jtf4);

//设置按钮
jb1.setBounds(50, 125, 90, 70);

add(jb1);

jb2.setBounds(50, 280, 90, 70);

add(jb2);

jb3.setBounds(50, 430, 90, 70);

add(jb3);

jb4.setBounds(50, 570, 90, 70);

add(jb4);



jb1.addActionListener(this);

jb2.addActionListener(this);

jb3.addActionListener(this);

jb4.addActionListener(this);

}

public static void main(String[] args) {

Test t = new Test();

}

public void actionPerformed(ActionEvent e) {

	//url解密 tea解密 tea加密 url加密
try{
	if("url解密".equals(e.getActionCommand())){
		//定义局部变量
		String urlde,urlderesult;
		urlde = jtf1.getText();
		urlderesult = myClass.decode(urlde);
		jtf1.setText(urlderesult);
		}else if("tea解密".equals(e.getActionCommand()))
		{
			String teade,teaderesult;
			teade = jtf2.getText();
			//teade = "1LN2lnXSe8IlpyUe3rJRVnvf1Wgr94FH9JGDTJvQNKGszZHZjwRd7SOnG8iCpyk9r93j3/6RGE3ZJWhUbXbN+8UElDQ+3TdgBfieohqcK0dEfjDlwM9RoBB5Dl4VFWb8Tn8Itaypni4QlTnvTD202WZsuwujlbxFzefT0RI/u7o7cOtpiCNf5CVRJzKemMjWAWuMCDZ3Sa1AlBSPbFOGD0OJ/OAGU/fkY6UifzHlEMrhKwOOP7O5X6Bn/lRECLqlpK+5gD1pOQBNBMd+k0fYkxgRpd9dw09HYv7cbkY8APIQlTnvTD202VYnWNZWJ0uXVouhB79wGw0BGC1Y4tTpCPeESN+adhn8YmZrROPKakfnGurTh/QlLUdFO0jgJCcpZsHRhOCCZbONMDlHevcR32h0gUqQiiM6k637+/rVnroUCI4uLGPg+MXbQZAxYUJwgiBF0OrakDw3av4Q3RGIn1hilADiW+25pA3umROUXxXZgojf9/SbhN5SX4/o/ptoNSzollKH7gMXtDNOp0H3NCBKrYVj0tN5/3XcxPVp5lQDaeHuSLaIeW+jZbNQ8/xPMNanMNYD0lOPKOusTMWmWkaeV5skVM2AeFIv/uNDjXlwRpdsLQJ9ZQ==";
			teaderesult = myClass.decryCode(teade);
			System.out.println(teaderesult);
			jtf2.setText(teaderesult);
		}else if("tea加密".equals(e.getActionCommand())) {
			String teaen,teaenresult;
			teaen = jtf3.getText();
			teaenresult = myClass.encryCode(teaen);
			jtf3.setText(teaenresult);
		}else if("url加密".equals(e.getActionCommand())) {
			String urlen,urlenresult;
			urlen = jtf4.getText();
			urlenresult = myClass.decode(urlen);
			jtf4.setText(urlenresult);
		}
	
	}catch(Exception ex){

		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 

	}

	}

}