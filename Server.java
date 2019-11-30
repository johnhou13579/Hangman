
import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
	// to do --> data structure to hold server threads s
	private Vector<Client> clientList;

	//read Config.txt file and storing into Property Class
	private Properties configProp = new Properties();

	ServerSocket serverSocket = null; 
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

			serverSocket = new ServerSocket(Integer.parseInt(configProp.getProperty("ServerPort")));

			clientList = new Vector<Client>();
			while (true) {
				Socket s = serverSocket.accept(); // blocking

				//logic to put into room or create room

				Client client = new Client(s);
				client.start();
				//Client st = new Client(s);
				//clientList.add(st); 

			}
		} catch (IOException ioe) {
			System.out.println("Configuration file " + config +"could not be found.");
		}		
	}

	class Client extends Thread{
		Socket socket;
		Client(Socket socket){
			this.socket = socket;
		}

		public void run(){
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				String inputLine;
				out.println("Username: ");
				String username = in.readLine();
				out.println("Password: ");
				String password = in.readLine();

				out.println("Account is "+username+" with password "+password);
				
			}catch(IOException io){

			}
		}
	}
	
	public static void main(String [] args) {
		// to do --> implement your main()
		Server svr = new Server();
	}
}
