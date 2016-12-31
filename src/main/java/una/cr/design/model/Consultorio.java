package una.cr.design.model;

import java.util.Calendar;

public abstract class Consultorio {

    protected String nombre;
    protected String[] fechaAtencion;
    protected String telefonoContacto;

    public Consultorio() {
    }

    public Consultorio(String nombre, String[] fechaAtencion, String telefonoContacto) {
        this.nombre = nombre;
        this.fechaAtencion = fechaAtencion;
        this.telefonoContacto = telefonoContacto;
    }

    public String diasConsulta() {
        return fechaAtencion[0] + " y " + fechaAtencion[1];
    }

    // ----- Metodos de prueba para obtener la fecha por medio de Calendar ----- //
    
    /*public String mostrarFecha() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.YEAR);

        return Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);
    }*/

 /*
    public void mostrarFecha() {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        System.out.println(formatoFecha.format(c)); //2016/11/16 12:08:43
    }*/
    @Override
    public String toString() {
        return "\nConsultorio{" + "nombre=" + nombre + ", fechaAtencion=" + diasConsulta() + ", telefonoContacto=" + telefonoContacto + '}';
    }

}
