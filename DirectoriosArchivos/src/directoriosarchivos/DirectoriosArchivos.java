package directoriosarchivos;

import java.io.*;

public class DirectoriosArchivos {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        new interfaz();
    }

    public static void Ejecutar(String dir) {
        Conexion c = new Conexion();
        File directorio = new File(dir);
        String[] ficheros = directorio.list();
        for (int i = 0; i <= ficheros.length - 1; i++) {
            File d = new File(dir + ficheros[i]);
            String[] f = d.list();
            if (d.isDirectory()/* && (Directorio.hayMp3(f))*/) {
                /*for (int j = 0; j <= f.length - 1; j++) {
                    if (Directorio.mp3(f[j])) {
                        String sql = "";
                        sql = "insert into cancion(dir,tit)values('"+ ficheros[i] + "','"+f[j]+"');";
                        //c.EjecutarComando(sql);
                       // System.out.println(sql);
                    }else{
                        String arch = "D:/musica/"+ficheros[i]+"/"+f[j];
                        File a = new File(arch);
                        if(a.delete())
                            System.out.println(arch);
                    }
                }*/
                if(d.isDirectory()){
                    int u = 0;
                    for(int k=0;k<f.length;k++)
                        u++;
                    if(u==0){
                        System.out.println(u +": "+ ficheros[i]);
                        File h = new File("D:/musica/"+ficheros[i]);
                        h.delete();
                    }
                }
            }
        }
    }
}
