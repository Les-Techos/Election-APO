package utils;

import java.io.IOException;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Personne.CSVReady;

/**
 * Gestionnaire de sauvegarde pour collections CSVReady
 */
public class SaveManager {    
    /**
     * Sauvegarde une collection CSVReady au format CSV
     * @param <B> : Collection de CSVReady
     * @param <A> : Item CSVReady
     * @param ls : Collection à sauvegarder
     * @param path : Chemin de sauvegarde
     * @param items_class : Classe des items à sauvegarder
     * @throws Exception
     */
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

    /**
     * Récupère une collection 
     * @param <B> : Collection de CSVReady
     * @param <A> : Item CSVReady
     * @param ls : Collection à charger
     * @param pathToFile : Chemin de chargement
     * @throws IOException
     */
    public static <B extends Collection<A>, A extends CSVReady> void saveIterableTo(B ls, String pathToFile) throws IOException {
        FileWriter writer = null;
        try{
            writer = new FileWriter(pathToFile);
            for(A a : ls){
                writer.write(a.toCSVString() + "\n");
            }  
        }catch(Exception e){ throw e;}
        finally{
            if(writer != null) writer.close();
        }
    }
}
