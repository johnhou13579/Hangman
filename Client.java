
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

public class Client {

	public static void main(String[] args){
		System.out.println("Enter name of configuration file.");
		Properties configProp = new Properties();
		Scanner sc = new Scanner(System.in);
		String config = sc.nextLine();
		System.out.println("Reading config file...");
		
		
		try{
			configProp.load(new FileInputStream(config));
			configProp.list(System.out);
			System.out.print("Trying to connect to server...");

			Socket socket = new Socket(configProp.getProperty("ServerHostname"), Integer.parseInt(configProp.getProperty("ServerPort")));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader((new InputStreamReader(socket.getInputStream())));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String serverInput=null;

			System.out.println("Connected!");
			System.out.print(in.readLine());

			while((serverInput=stdIn.readLine())!=null){
				out.println(serverInput);
				System.out.print(in.readLine());
			}
			
		}catch(IOException e){
			System.out.println("Configuration file "+config+" could not be found.");
		}
		
	}	
}
