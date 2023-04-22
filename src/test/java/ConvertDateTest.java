import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ListWindows;
import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

public class ConvertDateTest {
    //@Test
    public void encode() {
        try {
//            String key = "1234";
//            String data = "1234";
//            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
//            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
//            sha256_HMAC.init(secret_key);
//
//            alert(Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8"))));
//            alert(Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes("UTF-8"))););

        } catch (Exception e) {
            alert(e.getMessage());
        }
    }
    public void teste(){
        ListWindows a = new ListWindows();
        a.action("");

    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}