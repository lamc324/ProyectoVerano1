package una.cr.design.datos;

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




       Query query = session.createQuery("FROM Paciente");
        //query.setParameter("id", id);
//        query.setString("id",id);

//        if (result.size() > 0) {
//            paciente = (Paciente) result.get(0);
//        }
      
        if (query.list().size() == 1) {
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
