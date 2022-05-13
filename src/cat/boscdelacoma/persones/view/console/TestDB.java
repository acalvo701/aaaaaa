
package cat.boscdelacoma.persones.view.console;

import cat.boscdelacoma.persones.model.business.entities.Persona;
import cat.boscdelacoma.persones.model.persistence.dao.contracts.PersonaDAO;
import cat.boscdelacoma.persones.model.persistence.dao.implementations.JDBCPersonaDAO;
import cat.boscdelacoma.persones.model.persistence.dao.implementations.imp.jdbc.mysql.MySQLConnection;
import cat.boscdelacoma.persones.model.persistence.exception.DAOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class TestDB {

   
    public static void main(String[] args) {
       MySQLConnection conn = MySQLConnection.getInstance();
       System.out.println(conn.getConnection());
      JDBCPersonaDAO dades = new JDBCPersonaDAO();  
        try {
           
            //
            Persona p = new Persona("77872333P", "Joan", 23);
            dades.add(p);
            
        } catch (DAOException ex) {
            System.out.println(ex);
        }
      
        
        
        
    }
    
}
