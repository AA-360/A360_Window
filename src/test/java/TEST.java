import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.swing.*;


import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TEST {
    @Test
    public void encode(){
        try {
            alert("qsdasdas");
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        }catch (Exception e){
            alert(e.getMessage());
        }
    }


    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}

