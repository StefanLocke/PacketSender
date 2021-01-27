package boss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Controller;

import java.io.IOException;
import java.net.*;

public class Sender extends Application {

    public Controller con = null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/intro.fxml"));
        Parent root = loader.load();
        con = (Controller) loader.getController();
        con.setMain(this);
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(720);
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {


        launch();

        /*int SendPort = 6969;
        byte buffer[] = new byte[100];
        DatagramSocket SenderSocket = new DatagramSocket();
        DatagramPacket toSend = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),SendPort);
        SenderSocket.send(toSend);*/


    }



    public void send() throws IOException {
        System.out.println("Sending");
        byte buffer[] = con.getUDPText().getBytes();
        int port = Integer.parseInt(con.getPort());
        InetAddress addr = null;
        if (con.getLocal()) {
            addr = InetAddress.getLocalHost();
        }else {
            addr = InetAddress.getByName(con.getIp());
        }
        DatagramSocket SenderSocket = new DatagramSocket();

        DatagramPacket toSend = new DatagramPacket(buffer,buffer.length, addr,port);
        SenderSocket.send(toSend);
        SenderSocket.close();
        System.out.println("Sent");
    }


}
