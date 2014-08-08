package directoriosarchivos;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author Josimar Velasquez Merida
 */
public class Conexion {
private Connection cnx;

   public Conexion() {
     Conectar();
   }

   public void Conectar(){
     try {
     Class.forName("com.mysql.jdbc.Driver");
     String dbURL = "jdbc:mysql://localhost:3306/musica";
     cnx = DriverManager.getConnection(dbURL,"root","");
     }
     catch (Exception err) {
     System.out.println("Error al intentar abrir la conexion: " + err);
     }
   }

   public void EjecutarComando(String Comando) {
     try {
     Statement Cmd = cnx.createStatement();
     Cmd.execute(Comando);
     }
     catch (Exception err) {
     System.out.println("Error al intentar ejecutar comando: " + err);
     }
   }

   public ResultSet EjecutarConsulta(String Consulta) {
     ResultSet res = null;
     try {
     Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     res = stmt.executeQuery(Consulta);
     }
     catch (Exception err) {
     System.out.println("Error al intentar ejecutar consulta: " + err);
     }
     return res;
   }
}

