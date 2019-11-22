package afbeans.repository;

import java.io.Serializable;
import java.util.List;

/***

 Created by 
 @author dkammara on Thursday - 10/24/2019

 */
public interface GenericRepository<T extends Serializable> {

    T findOne(final long id);
    List<T> findAll();
    void create(final T entity);
    T update(final T entity);
    void delete(final T entity);
    void deleteById(final long entityId);

}
