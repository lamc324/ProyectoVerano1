package una.cr.design.datos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.cr.design.model.Paciente;

/**
 *
 * @author John
 */


public class PacienteDao {
private final Session session = HibernateUtil.getSessionFactory().openSession();

public PacienteDao(){}

  public Paciente FindById(String id) {
        Paciente paciente = null;
        
        
        
//                Student student = null;
//List<Paciente> result = (List<Paciente>) session.createQuery("from Paciente").list();
       Query query = session.createQuery("from Paciente where id =  :id" );
        query.setParameter("id", id);
        query.setString("id",id);

//        if (result.size() > 0) {
//            paciente = (Paciente) result.get(0);
//        }
        
        
//        //OPCION 1
//        Query query = session.createQuery("from Paciente where id = :id");
//        query.setString("id",id);
        
        //OPCION 2
        //Query query = session.createQuery("from Paciente where id = " + id);

        if (query.list().size() > 0) {
            paciente = (Paciente) query.list().get(0);
        }

        return paciente;
    }
  
  
  
  
  
      public Paciente save(Paciente paciente) {
        session.beginTransaction();
        session.save(paciente);
        session.getTransaction().commit();

        return paciente;
    }
}
