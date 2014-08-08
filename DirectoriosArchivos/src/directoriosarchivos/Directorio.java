package directoriosarchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Directorio {
    public String palabra;
    public Directorio(String s){
        palabra = s;
    }
    
    public static boolean carpeta(String s){
        char[]let = s.toCharArray();
        for(int i= let.length-1;i>=0;i--)
            if(let[i]=='.')
                return false;
        return true;
    }
    
    public static boolean mp3(String s){
        char[]let = s.toCharArray();
        String aux = ""+let[let.length-3]+let[let.length-2]+let[let.length-1];
        if(aux.toUpperCase().equals("MP3"))
            return true;
        return false;        
    }
    
    public static boolean wma(String s){
        char[]let = s.toCharArray();
        if((let[let.length-1]=='a')&&(let[let.length-2]=='m')&&(let[let.length-3]=='w'))            
            return true;
        if((let[let.length-1]=='A')&&(let[let.length-2]=='M')&&(let[let.length-3]=='W'))            
            return true;  
        if((let[let.length-1]=='a')&&(let[let.length-2]=='m')&&(let[let.length-3]=='W'))            
            return true;
        return false;        
    }
    
    public static boolean vacio(String []s){
        int n = s.length-1;
        if(n <5)
            return true;
        else
            return false;
    }
    
    public static boolean otro(String s){
        char[]let = s.toCharArray();
        if((let[let.length-1]=='v')&&(let[let.length-2]=='m')&&(let[let.length-3]=='w'))            
            return true;  
        if((let[let.length-1]=='v')&&(let[let.length-2]=='m')&&(let[let.length-3]=='W'))            
            return true;  
        if((let[let.length-1]=='V')&&(let[let.length-2]=='M')&&(let[let.length-3]=='W'))            
            return true;   
        if((let[let.length-1]=='D')&&(let[let.length-2]=='I')&&(let[let.length-3]=='M'))            
            return true;  
        if((let[let.length-1]=='a')&&(let[let.length-2]=='m')&&(let[let.length-3]=='W'))            
            return true;  
        if((let[let.length-1]=='v')&&(let[let.length-2]=='a')&&(let[let.length-3]=='W'))            
            return true; 
        if((let[let.length-1]=='V')&&(let[let.length-2]=='A')&&(let[let.length-3]=='W'))            
            return true; 
        if((let[let.length-1]=='v')&&(let[let.length-2]=='a')&&(let[let.length-3]=='w'))            
            return true;
        if((let[let.length-1]=='g')&&(let[let.length-2]=='p')&&(let[let.length-3]=='m'))            
            return true;
        if((let[let.length-1]=='a')&&(let[let.length-2]=='d')&&(let[let.length-3]=='c'))            
            return true;
        if((let[let.length-1]=='2')&&(let[let.length-2]=='p')&&(let[let.length-3]=='m'))            
            return true;
        if((let[let.length-1]=='a')&&(let[let.length-2]=='4')&&(let[let.length-3]=='m'))            
            return true;
        if((let[let.length-1]=='u')&&(let[let.length-2]=='3')&&(let[let.length-3]=='m'))            
            return true;
        if((let[let.length-1]=='i')&&(let[let.length-2]=='m')&&(let[let.length-3]=='r'))            
            return true;
        if((let[let.length-1]=='4')&&(let[let.length-2]=='p')&&(let[let.length-3]=='m'))            
            return true;
        return false;                 
    }
       
    public static boolean hayMp3(String []s){
        int n = 0;
        for(int i = 0; i<= s.length-1;i++){
            if(mp3(s[i]))
                n++;
        }
        if(n!=0)
            return true; 
        else
            return false;
    }

    public static String quitarExtension(String palabra){
        char[]pal = palabra.toCharArray();
        String s = "";
        for(int i = 0; i<= pal.length-5; i++)
            s += pal[i];
        return s;
    } 
    
    public static char primeraLetra(String palabra){
        char[]pal = palabra.toCharArray();
        char r = pal[0];
        return r;
    }
    
    private static void Copiar(File dirOrigen, File dirDestino) throws Exception { 
        InputStream in = new FileInputStream(dirOrigen); 
        OutputStream out = new FileOutputStream(dirDestino); 
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = in.read(buffer)) > 0) { 
                 out.write(buffer, 0, len); 
            }
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close(); 
            out.close(); 
        }
    }
    
    public static int carpetasFichero(String []s){
        int n = 0;
        for(int i = 0; i<= s.length-1;i++){
            if(carpeta(s[i]))
                n++;
        }
        return n;
    }
    
    public static void insertarArchivos(String dir){
        try {
           // Copiar(new File("mediaplayer.swf"),new File("D:/musica/"+dir+"/mediaplayer.swf"));
            new File("D:/musica/"+dir+"/mediaplayer.swf").delete();
            //Copiar(new File("swfobject.js"),new File("D:/musica/"+dir+"/swfobject.js"));
            new File("D:/musica/"+dir+"/swfobject.js").delete();
            //Copiar(new File("imagen.jpg"),new File("D:/musica/"+dir+"/imagen.jpg"));    
            new File("D:/musica/"+dir+"/imagen.jpg").delete();
        } catch (Exception ex) {
            Logger.getLogger(Directorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
