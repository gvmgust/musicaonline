package directoriosarchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class archivo {
    
public static void CrearArchivo(String archivo, String contenido){
        try {
            File outFile = new File(archivo);
            if(outFile.exists())
                outFile.delete();
            outFile = new File(archivo);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            writer.write(contenido);
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
    }
}   
}
