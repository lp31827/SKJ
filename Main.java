import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {
    private static class Client {
        private final InetAddress HOST;
        private final int PORT;
        private final String USERNAME;
        private String PASSWORD;

        Client(String host, int port, String username) {
            try {
                this.HOST = InetAddress.getByName(host);
            } catch (UnknownHostException e) {
                System.out.println("UNKNOWN HOST TRY AGAIN");
                throw new RuntimeException(e);
            }
            this.PORT = port;
            this.USERNAME = username;
            this.init();

        }

        Client(String host, int port, String username, String password) {
            try {
                this.HOST = InetAddress.getByName(host);
            } catch (UnknownHostException e) {
                System.out.println("UNKNOWN HOST TRY AGAIN");
                throw new RuntimeException(e);
            }
            this.PORT = port;
            this.USERNAME = username;
            this.PASSWORD = password;
            

        }

        private void init() {
            System.out.println("Try connect to " + this.HOST.getHostName() + ":" + this.PORT + "\n");
            try (Socket socket = new Socket(this.HOST, this.PORT)) {
                System.out.println("Connected successfully\n");
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                writer.println(this.USERNAME + " " + this.USERNAME);

                if (this.PASSWORD == null)
                    this.PASSWORD = Arrays.stream(reader.readLine().split(":"))
                            .reduce((first, second) -> second)
                            .map(String::strip)
                            .orElse("");

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("\n Connection closed\n");
                input.close();
                writer.close();
                socket.close();

            } catch (IOException e) {
                System.out.println("Connection refused " + this.HOST.getHostName() + ":" + this.PORT);
                throw new RuntimeException(e);
            }
        }

        private void run() {
            System.out.println("Try connect to " + this.USERNAME + "@" + this.HOST.getHostName() + ":" + this.PORT + "\n");
            try (Socket socket = new Socket(this.HOST, this.PORT)) {
                System.out.println("Connected successfully \n"+ this.USERNAME + "@" + this.HOST.getHostName() + ":" + this.PORT +"\n");
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                writer.println(this.USERNAME + " " + this.PASSWORD);

                task1(reader,writer);
                task2(reader,writer);
                task3(reader,writer);
                task4(reader,writer);
                task5(reader,writer);

                input.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Connection refused " + this.USERNAME + "@" + this.HOST.getHostName() + ":"
                        + this.PORT + "\n");
                throw new RuntimeException(e);
            }
        }

        private void task1(BufferedReader reader,PrintWriter writer) throws IOException {}
        private void task2(BufferedReader reader,PrintWriter writer) throws IOException{}
        private void task3(BufferedReader reader,PrintWriter writer) throws IOException{}
        private void task4(BufferedReader reader,PrintWriter writer)throws IOException {}
        private void task5(BufferedReader reader,PrintWriter writer)throws IOException {}
    }
    public static void main(String[] args) {
        //Client s31827=new Client(IPADRESS,PORT,USERNAME);


        //Client s31827=new Client(IPADRESS,PORT,USERNAME,PASSWORD);


        //s31827.run();

    }


}
