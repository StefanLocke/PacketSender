package view;

import boss.Sender;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller {




    private Sender myMain;
    public TextField ipInput;
    public TextField portInput;
    public CheckBox local;
    public TextArea UDPContent;

    public void initialize(){
        System.out.println("initializing");
        setBinds();
    }

    public String getIp() {
        return ipInput.getText();
    }
    public String getPort() {
        return portInput.getText();
    }

    public boolean getLocal() {
        return local.isSelected();
    }

    public String getUDPText() {
        return UDPContent.getText();
    }

    public void setBinds() {
        ipInput.editableProperty().bind(local.selectedProperty().not());
    }

    public void sendUDP() throws IOException {
        myMain.send();
    }


    public void setMain(Sender m) {
        this.myMain = m;
    }


}
