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
		//屏幕输入对象
		Scanner scanner = new Scanner(System.in);
	    //结束标志
		boolean flag = true;
		//用户输入数据
		String inStr = "" ;
		//从服务器读取数据
		String outStr = "" ;
		try {
			//获得本机 ip
			InetAddress inetAddress2 = InetAddress.getLocalHost();
			//建立socket对象
			Socket socket = new Socket(inetAddress2, 2000);
			//获得socket对象的输入流
			InputStream in = socket.getInputStream();
			DataInputStream inReader = new DataInputStream(in);
			//获得输出流
			OutputStream out = socket.getOutputStream();
			DataOutputStream outWrite = new DataOutputStream(out);
			//只要flag标志为true，就持续发消息
			while (flag) {
				System.out.println("请输入您想要发送给服务端的信息:");
				inStr = scanner.nextLine();
				if (!inStr.equals("bybe") ) {
					outWrite.writeUTF(inStr);
					outWrite.flush();
					outStr = inReader.readUTF();
					System.out.println("从服务器读取的数据为:"+outStr);
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
