import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer6
{
	 ServerSocket serverSocket = null;
	 Socket socket = null;
	 Map<String, PrintWriter> clientMap;
	
		
		public MultiServer6() {
		clientMap = new HashMap<String, PrintWriter>();
		
		Collections.synchronizedMap(clientMap);
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
	
		
	public void sendAllMsg(String msg, String name)
	{
		Iterator it = clientMap.keySet().iterator();
		
		while (it.hasNext()){
			try
			{
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
			if(name.equals("")) {
				it_out.print(msg);
			} else {
				it_out.print(name+">"+msg);
			}
			}catch(Exception e){
			System.out.println("예외:"+e);
			}
		}
	}

	public static void main(String[] args)
	{
		MultiServer6 ms = new MultiServer6();
		ms.init();
	}
	class MultiserverT extends Thread
	{
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String name = "";
		
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
		@Override
		public void run()
		{
			String s="";
			
			try{
				name = in.readLine();
				System.out.println("[" +name+ "]님이 대화방에 입장하셨습니다.");
				sendAllMsg(name+ "님이 입장하셨습니다.","");
				clientMap.put(name, out);
				
				System.out.println("현재 접속자 수는"+clientMap.size()+"명 입니다.");
				
				while (in!=null) {
					s= in.readLine();
					
					if(s.equals("q") || s.equals("Q"))
						break;
				
	
				System.out.println(name + ">" +s);
				sendAllMsg(s, name);
			}
				System.out.println("쓰레드 종료");
				
			}catch (Exception e) {
				System.out.println("예외:"+e);
			}finally {
				clientMap.remove(name);
				sendAllMsg(name, "님이 퇴장하셨습니다.");
				
				System.out.println("현재 접속자 수는"+clientMap.size()+"명 입니다.");
				
				try {
					in.close();
					out.close();
					
					socket.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}	