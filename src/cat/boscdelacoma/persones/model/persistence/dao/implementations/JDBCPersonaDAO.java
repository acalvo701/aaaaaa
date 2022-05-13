/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.boscdelacoma.persones.model.persistence.dao.implementations;

import cat.boscdelacoma.persones.model.business.entities.Persona;
import cat.boscdelacoma.persones.model.persistence.dao.contracts.PersonaDAO;
import cat.boscdelacoma.persones.model.persistence.dao.implementations.imp.jdbc.mysql.MySQLConnection;
import cat.boscdelacoma.persones.model.persistence.exception.DAOException;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCPersonaDAO implements PersonaDAO {

    @Override
    public Persona get(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM persones.persona");
            List<Persona> llista = new ArrayList<>();
            while (result.next()) {

                llista.add(new Persona(result.getString("dni"), result.getString("name"), result.getInt("edat")));

            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }

    @Override
    public void add(Persona p) throws DAOException {
               try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("INSERT INTO persones.persona(name,edat,dni) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            
            query.setString(1,p.getNom());
            query.setInt(2, p.getEdat());
            query.setString(3,p.getDni());
            query.executeUpdate();
            
            ResultSet rst = query.getGeneratedKeys();
            if(rst.next()){
                    p.setID(rst.getInt(1));
            }
                 
        } catch (SQLException ex) {
            throw new DAOException();
        }
        
    }

    @Override
    public void update(Persona p) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Persona p) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
