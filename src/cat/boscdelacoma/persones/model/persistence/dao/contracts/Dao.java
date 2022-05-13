
package cat.boscdelacoma.persones.model.persistence.dao.contracts;

import cat.boscdelacoma.persones.model.persistence.exception.DAOException;
import java.util.List;


public interface Dao <T>{
  //Metodes de consulta
    T get(long id) throws DAOException;
    List<T>getAll() throws DAOException;
    
  //Metodes modificadors 
    void add(T t) throws DAOException;
    void update(T t) throws DAOException;
    void delete(T t) throws DAOException;
}
