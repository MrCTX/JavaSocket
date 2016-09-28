package com.panda.CS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
	public static void main(String[] args) {
		ServerSocket sc = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		DataInputStream inReader = null;
		DataOutputStream outWrite = null;
		boolean flag = true;
		
		try {
			Scanner scanner = new Scanner(System.in);
			sc = new ServerSocket(2000);
			socket = sc.accept();
			in = socket.getInputStream();
			inReader = new DataInputStream(in);
			out = socket.getOutputStream();
			outWrite = new DataOutputStream(out);
			String inStr  = "" ;
			String outStr = "" ;
			while (flag) {
				inStr = inReader.readUTF();
				System.out.println("从客户端接收到消息:" + inStr);
				System.out.println("请输入要发送给客户端的消息:");
				outStr = scanner.nextLine().trim();
				if (!outStr.equals("bye")) {
					outWrite.writeUTF(outStr);
					outWrite.flush();
				} else {
					flag = false;
				}
			}
			outWrite.close();
			inReader.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
