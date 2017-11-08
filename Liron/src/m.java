import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;

public class m {
	public static void main(String[]args) throws IOException, UnknownHostException, InterruptedException 
	{
		Thread client = new Thread()
				{
					public void run() 
					{
						Socket sock = null;
						OutputStreamWriter out = null;
				        DataInputStream in = null;
				        Scanner read = new Scanner(System.in);
				        String s,input;
			        	try {
			        		while(true)
			        		{
			        			//System.out.println("Client Start");
								sock = new Socket("10.0.0.32",55286);
								out = new OutputStreamWriter(sock.getOutputStream());
								System.out.println("Write Something:");
								s = read.nextLine();
					    		out.write(s);
					    		out.flush();
					    		sock.close();	
			        		}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println(e.toString());
						}
			        }
				};
		Thread server = new Thread()
				{
					public void run()
					{
						try {
							//while(true)
							//{
							 	System.out.println("server is started");
						        ServerSocket serverSocket= new ServerSocket(55286);
						    while(true)
							{
						        //System.out.println("server is waiting");
						        Socket socket=serverSocket.accept();
						        //System.out.println("Client connected");
						        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						        String str=reader.readLine();
						        System.out.println("Client data: "+str);
						        //socket.close();
						        //serverSocket.close();
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.toString());
						}
				       
					}
				};
		server.start();
		client.start();
	}
}
