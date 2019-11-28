
import java.io.IOException;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.Properties;
import java.util.Scanner;

public class Server {
	// to do --> data structure to hold server threads s
	private Vector<Client> clientList;

	//read Config.txt file and storing into Property Class
	private Properties configProp = new Properties();

	ServerSocket ss = null; 
	Scanner sc = null;
	String config = null;

	public Server() {
		// to do --> implement your constructor
		
		try {
			System.out.println("Enter name of configuration file.");
			sc = new Scanner(System.in);
			config = sc.nextLine();
			configProp.load(new FileInputStream(config));
			configProp.list(System.out);

			ss = new ServerSocket(Integer.parseInt(configProp.getProperty("ServerPort")));

			sc.close();

			clientList = new Vector<Client>();
			while (clientList.size() <= 4) {
				Socket s = ss.accept(); // blocking
				System.out.println("connected");
				//Client st = new Client(s);
				//clientList.add(st); 

			}
		} catch (IOException ioe) {
			System.out.println("ioe in ChatRoom constructor: " + ioe.getMessage());
			
		}		
	}
	
	public static void main(String [] args) {
		// to do --> implement your main()
		Server svr = new Server();
	}
}
