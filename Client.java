
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

public class Client {
	// to do --> private variables for the server thread 
	private Server svr; 
	//private ObjectOutputStream oos;
	//private ObjectInputStream ois; 
	private BufferedReader br;
	private PrintStream out;
	public Socket s;

	private Properties configProp = new Properties();

	public static void main(String[] args){
		String port;
		String db;
		Scanner sc = null;

		try{
			System.out.println("Enter name of configuration file.");
			Properties configProp = new Properties();
			sc = new Scanner(System.in);
			String config = sc.nextLine();
			System.out.println("Reading config file...")

			configProp.load(new FileInputStream(config));
			configProp.list(System.out);
			System.out.print("Trying to connect to server...");

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			/* while((userInput = stdIn.readLine()) != null){
				System.out.println(userInput);
			} */
			port = configProp.getProperty("ServerPort");
			Socket clientSocket = new Socket("localhost", Integer.parseInt(port));
			System.out.println("Connected!");

			db = configProp.getProperty("DBConnection");
			username = config.getProperty("DBUsername");
			password = config.getProperty("DBPassword");
			System.out.print("Trying to connect to server..." + db);
			//Implement connect to DB method
			if(true){
				System.out.println("Connected!");
			}else{
				System.out.println("Unable to connec to database "+ db +" with username "+ username+" and password "+ password);
			}

			System.out.print("Username: ");
			String inputUser = sc.nextLine();
			System.out.print("Password: ");
			String inputPassword = sc.nextLine();

			//Check if exists in DB 
			if(true){
				System.out.println("Great! You are now logged in as "+inputUser+". "+inputUser+"'s Record'");
				System.out.println("--------------");
				//Get wins and losses here
				System.out.println("Wins - " + "1");
				System.out.println("Losses - " + "0");
			}else{
				//Make sure error stops running the rest of code.
			}
			
		}catch(ConnectException e){
			System.err.println("Unable to connect to server localhost on port "+port);
			System.exit(1);
		}catch(IOException e){
			System.err.println("Dont know input file");
			System.exit(1);
		}
		
	}
	
	
	
}
