package una.cr.design.patterns;

import org.hibernate.Hibernate;
import una.cr.design.datos.PacienteDao;
import una.cr.design.patterns.view.MenuView;

public class Application {

    /**
     *
     * @param args
     * @throws org.hibernate.Hibernate
     * @throws org.hibernate.Hibernate
     * @throws Hibernate
     */
    public static void main(String[] args) {
        MenuView p = new MenuView(); 

//        studentDAO = mock(StudentDAOHibernateImpl.class);
//        studentService = new StudentServiceImpl(studentDAO);
//
//        Student student = new Student();
//        student.setName("Mike");
//        student.setCourse("Progra III");
//        student.setRating("A+");
//
//        when(studentService.findById(1)).thenReturn(student);
//
//        assertThat(student.getName(), is("Mike"));
        PacienteDao pacient = new PacienteDao();
   // Paciente p1 = new Paciente("222","kevin","6546","cdsdsd","321312","vcvcdx");
        pacient.FindById("111");
        System.out.println("paciente---->" + pacient.toString() );
    }
}
