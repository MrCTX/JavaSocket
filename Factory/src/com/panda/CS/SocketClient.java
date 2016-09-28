package com.panda.CS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//��Ļ�������
		Scanner scanner = new Scanner(System.in);
	    //������־
		boolean flag = true;
		//�û���������
		String inStr = "" ;
		//�ӷ�������ȡ����
		String outStr = "" ;
		try {
			//��ñ��� ip
			InetAddress inetAddress2 = InetAddress.getLocalHost();
			//����socket����
			Socket socket = new Socket(inetAddress2, 2000);
			//���socket�����������
			InputStream in = socket.getInputStream();
			DataInputStream inReader = new DataInputStream(in);
			//��������
			OutputStream out = socket.getOutputStream();
			DataOutputStream outWrite = new DataOutputStream(out);
			//ֻҪflag��־Ϊtrue���ͳ�������Ϣ
			while (flag) {
				System.out.println("����������Ҫ���͸�����˵���Ϣ:");
				inStr = scanner.nextLine();
				if (!inStr.equals("bybe") ) {
					outWrite.writeUTF(inStr);
					outWrite.flush();
					outStr = inReader.readUTF();
					System.out.println("�ӷ�������ȡ������Ϊ:"+outStr);
				}else {
					flag = false;
				}
			}
			outWrite.close();
			inReader.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
