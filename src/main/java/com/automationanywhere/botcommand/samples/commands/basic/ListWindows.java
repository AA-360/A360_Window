package com.automationanywhere.botcommand.samples.commands.basic;
import java.util.ArrayList;
import java.util.List;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.User32;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;

import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.LIST;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(label = "GetAllWindowsName",
        description = "Returns all opened windows", icon = "pkg.svg", name = "GetAllWindowsName",
        return_description = "", return_type = LIST,return_sub_type = STRING,  return_required = true)


public class ListWindows {

    @Execute
    public ListValue<String> action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Window Name",description = "Key")
            String name
    ) {
        ListValue<String> returnvalue = new ListValue<String>();
        List<Value> winList = new ArrayList<Value>();

        for (String winName : getAllWindowNames(name)) {
            winList.add(new StringValue(winName));
        }
        returnvalue.set(winList);
        return returnvalue;
    }

    static interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

        interface WNDENUMPROC extends StdCallCallback {
            boolean callback(Pointer hWnd, Pointer arg);
        }

        boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer userData);

        int GetWindowTextA(Pointer hWnd, byte[] lpString, int nMaxCount);

        Pointer GetWindow(Pointer hWnd, int uCmd);
    }

    public static List<String> getAllWindowNames(String pTextoTituloJanelaContem) {

        final List<String> windowNames = new ArrayList<String>();
        final User32 user32 = User32.INSTANCE;

        user32.EnumWindows(new User32.WNDENUMPROC() {

            @Override
            public boolean callback(Pointer hWnd, Pointer arg) {

                byte[] windowText = new byte[512];

                user32.GetWindowTextA(hWnd, windowText, 512);
                String wText = com.sun.jna.Native.toString(windowText).trim();

                //IntByReference PIDRef = new IntByReference();
                //final WinDef.HWND hwnd = new WinDef.HWND();
                //hwnd.setPointer(hWnd);
                //com.sun.jna.platform.win32.User32.INSTANCE.GetWindowThreadProcessId(hwnd,PIDRef);

                if (!wText.isEmpty() && wText.contains(pTextoTituloJanelaContem)) {
                    //System.out.println(PIDRef.getValue() + " - " + wText);
                    windowNames.add(wText);
                }

                return true;
            }
        }, null);

        return windowNames;
    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}
