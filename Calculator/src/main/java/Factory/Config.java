package Factory;

import Errors.MyException;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
public class Config {
    private Map<String,String> classes;

    public Config(String fileName){
        try {
            InputStream in = Config.class.getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            classes = new HashMap<>();
            String line;
            String[] partOfLine;
            while ((line = br.readLine()) != null) {
                partOfLine = line.split(" ");
                if (partOfLine.length != 2)
                    throw new MyException("Неправильный формат конфигурационного файла");
                classes.put(partOfLine[0],partOfLine[1]);
            }
        }
        catch (IOException error){
            System.out.println(error);
        }
        catch (MyException error){
            System.out.println(error.getErrorCode());
        }
    }

    public Map<String ,String> getClasses(){
        return classes;
    }
}
