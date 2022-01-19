package utils;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Personne.CSVReady;

public class SaveManager {
    public static <B extends Collection<A>, A extends CSVReady> void saveIterableTo(B ls, String path) throws IOException {
        FileWriter writer = null;
        try{
            writer = new FileWriter(path);
            for(A a : ls){
                writer.write(a.toCSVString() + "\n");
            }  
        }catch(Exception e){ throw e;}
        finally{
            if(writer != null) writer.close();
        }
    }

    public static <B extends Collection<A>, A extends CSVReady> void readIterableFrom(B ls, String path, Class<A> items_class) throws Exception {
        File file = new File(path);
        BufferedReader br
            = null;
        try{
            br = new BufferedReader(new FileReader(file));

            String st;
                       
            while ((st = br.readLine()) != null){
                ls.add(items_class.getDeclaredConstructor(String.class).newInstance(st));
            }  
        }catch(Exception e){ throw e;}
        finally{
            br.close();
        }
    }
}
