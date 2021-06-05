import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.ListWindows;
import org.testng.annotations.Test;

import javax.swing.*;

public class ConvertDateTest {
    @Test
    public void teste(){
        ListWindows a = new ListWindows();
        a.action("");

    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}