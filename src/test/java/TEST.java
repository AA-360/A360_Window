import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import org.apache.commons.dbcp2.BasicDataSource;

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




    public void teste(){

        try {
            URL u = new URL("jar:file:C:/Users/Melque/Documents/Git/RPA/AA2019/Template/mysql-connector-java-8.0.23.jar!/");
            String classname = "com.mysql.cj.jdbc.Driver";
            URLClassLoader ucl = new URLClassLoader(new URL[] { u });
            Driver d = (Driver)Class.forName(classname, true, ucl).newInstance();
            DriverManager.registerDriver(new DriverShim(d));
            DriverManager.getConnection("jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_5a62528efd385e9", "b98ada1e570103", "af21c926");
        } catch (Exception e) {
            alert(e.getMessage());
        }

        alert("OK");

        BasicDataSource crunchifyDS = new BasicDataSource();

        // Define Driver Class
        //mysql://b98ada1e570103:af21c926@us-cdbr-east-03.cleardb.com/heroku_5a62528efd385e9?reconnect=true
        crunchifyDS.setDriverClassName("com.mysql.jdbc.Driver");

        // Define Server URL
        crunchifyDS.setUrl("jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_5a62528efd385e9");

        // Define Username
        crunchifyDS.setUsername("b98ada1e570103");

        // Define Your Password
        crunchifyDS.setPassword("af21c926");
        try {
            crunchifyDS.getConnection();
        } catch (SQLException e) {
            alert(e.getMessage());
        }


    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}

