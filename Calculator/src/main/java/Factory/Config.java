package Factory;

import Errors.MyException;
import org.example.Main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.logging.Logger;

public class Config {

    public static final Logger logger = Logger.getLogger(
            Config.class.getName());
    private Map<String,String> classes;

    public Config(String fileName){
        try {
            InputStream in = Config.class.getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            logger.info("Config file has been open");
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
            logger.info("Something went wrong in opening file");
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
