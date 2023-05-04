package Input;
import Errors.MyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Program {
    private List<CommandContext> toCalculate;

    private String[] removeElement(String[] line, int index){
        String[] newLine = new String[line.length - 1];
        System.arraycopy(line, 0, newLine, 0, index);
        if(line.length != index){
            System.arraycopy(line, index+1, newLine, index, line.length - index - 1);
        }
        return newLine;
    }
    private CommandContext MakeContext(String[] commands, String[] line){
        CommandContext context = null;
        for (String com: commands) {
            int ind = Arrays.binarySearch(line,com);
            if(ind >= 0 && com != "#") {
                line = removeElement(line,ind);
                context = new CommandContext(com, line);
            }
            else continue;
        }
        return context;
    }
    private CommandContext ParseLine(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            String[] partsOfLine;
            String[] commands = {"PUSH","POP","+","-","*","/","SQRT","DEFINE","PRINT","#"};
            toCalculate = new ArrayList<>();
            CommandContext con = null;
            while((line = br.readLine()) != null){
                partsOfLine = line.split(" ");
                con = MakeContext(commands,partsOfLine);
                if (con == null)
                    return null;
                toCalculate.add(con);
            }
            br.close();
            return con;
        }
        catch (IOException error){
            System.out.println(error);
        }
        return null;
    }

    private CommandContext ParseStandard(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        String line;
        String[] partsOfLine;
        String[] commands = {"PUSH","POP","+","-","*","/","SQRT","DEFINE","PRINT","#"};
        toCalculate = new ArrayList<>();
        CommandContext con = null;
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            partsOfLine = line.split(" ");
            con = MakeContext(commands,partsOfLine);
            if (con == null)
                return null;
            toCalculate.add(con);
        }
        scanner.close();
        return con;
    }

    public void Parse(String[] args){
        try {
            if (args.length == 0) {
                System.out.println("Введите программу:");
                if (ParseStandard() == null)
                    throw new MyException("Неправильная команда");
            } else {
                if (ParseLine(args) == null)
                    throw new MyException("Неправильная команда");
            }
        }
        catch (MyException error){
            System.out.println(error.getErrorCode());
        }
    }

    public List<CommandContext> getToCalculate(){
        return toCalculate;
    }
}
