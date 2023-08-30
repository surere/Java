import java.io.*;
import java.net.*;

public class MultiServer5
{
	 ServerSocket serverSocket = null;
	 Socket socket = null;
		
		
		public MultiServer5() {
		}
		
		public void init()
		{
			try {
				serverSocket = new ServerSocket(9999);
				System.out.println("서버가 시작되었습니다.");
				
				while(true) {
					socket = serverSocket.accept();
					System.out.println(socket.getInetAddress() + ":" + socket.getPort());
				
					Thread msr = new MultiserverT(socket);
					msr.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{
					serverSocket.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
				
	public static void main(String[] args)
	{
		MultiServer5 ms = new MultiServer5();
		ms.init();
	}
	class MultiserverT extends Thread
	{
		static Socket socket = null;
		static PrintWriter out = null;
		static BufferedReader in = null;
		static String name = "";
		
		public MultiserverT (Socket socket)
		{
			this.socket = socket;
			try{
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
												this.socket.getInputStream() ));
			}catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
		public void run()
		{
			String s="";
			
			try{
				name = in.readLine();
				System.out.println("[" +name+ "]님이 대화방에 입장하셨습니다.");
				out.println("[" +name+ "]대화방에 입장");
				
				while (in!=null) {
					s= in.readLine();
					
					if( s==null)
						break;
					if(s.equals("q") || s.equals("Q"))
						break;
				
	
				System.out.println(name + ">" +s);
				sendAllMsg(s, out);
			}
				System.out.println("쓰레드 종료");
			}catch (Exception e) {
				System.out.println("예외:"+e);
			}finally {
				try {
					in.close();
					out.close();
					
					socket.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void sendAllMsg(String msg, PrintWriter out)
		{
			try {
				out.println(name + ">" +msg);
			}catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
	}
}
