package com.automationanywhere.botcommand.samples.commands.basic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import javax.swing.*;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.LIST;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "GetCmdResponse",
        description = "Runs a CMD command and returns the response",
        icon = "pkg.svg",
        name = "GetCmdResponse",
        return_description = "return value",
        node_label = "runs command {{command}} and gets reponse to {{returnTo}}",
        return_type = STRING,
        return_required = true
)


public class GetCmdResponse {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "command",description = "command to run")
            @NotEmpty
                    String command
    ) {
        try{

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String text = "";
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                text += "\n" + line;
                //System.out.println(line);
            }
            return new StringValue(text);
        }
        catch (Exception e){
            throw new BotCommandException("Error:" + e.getMessage());
        }

    }
}
