
/**
 * Se desea desarrollar un sistema de nómina para los trabajadores de una empresa.
 * Los datos personales de los trabajadores son nombre y apellidos, dirección y DNI.
 * Además, existen diferentes tipos de trabajadores:

Fijos Mensuales: que cobran una cantidad fija al mes.
Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
Por Horas: cobran un precio por cada una de las horas que han realizado durante
* el mes. El precio es fijo para las primeras 40 horas y es otro para las horas
* realizadas a partir de la 40 hora mensual.
Jefe: cobra un sueldo fijo (no hay que calcularlo). Cada empleado tiene
* obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). El programa 
* debe permitir dar de alta a trabajadores, así como fijar horas o ventas 
* realizadas e imprimir la nómina correspondiente al final de mes.
 * @author Jonathan Alvarez
 * @version 1.0
 */
import java.util.Arrays;
class Empresa {
    Trabajador[] trabajadores;
    public Empresa(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }
    @Override
    public String toString() {
        return "Empresa{\n" + "  trabajadores=" + Arrays.toString(trabajadores) + "\n}";
    }
}
class Trabajador {
    String nombre, apellido, direccion, DNI;
    double sueldo;
    Jefe jefe;
    public Trabajador(String nombre, String apellido, String direccion, String DNI, Jefe jefe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.DNI = DNI;
        this.jefe = jefe; 
    }
    public Trabajador(String nombre, String apellido, String direccion, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.DNI = DNI;
    }
    @Override
    public String toString() {
        return "\n  Trabajador{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' + ", DNI='" + DNI + '\'' +
                ", sueldo=" + sueldo + ", jefe=" + (jefe != null ? jefe.nombre : "Ninguno") + "}";
    }
}
class FijosMensuales extends Trabajador {
    double cantidad_fija;
    public FijosMensuales(double cantidad_fija, String nombre, String apellido, String direccion, String DNI, Jefe jefe) {
        super(nombre, apellido, direccion, DNI, jefe);
        this.cantidad_fija = cantidad_fija;
        this.sueldo = cantidad_fija; 
    }
    @Override
    public String toString() {
        return super.toString() + " -> FijosMensuales{" + "cantidad_fija=" + cantidad_fija + "}";
    }
}
class Comisionista extends Trabajador {
    double porcentaje_comision;
    int ventas;
    public Comisionista(double porcentaje_comision, int ventas, String nombre, String apellido, String direccion, String DNI, Jefe jefe) {
        super(nombre, apellido, direccion, DNI, jefe);
        this.porcentaje_comision = porcentaje_comision;
        this.ventas = ventas;
        this.sueldo = (this.porcentaje_comision / 100) * ventas;
    }
    @Override
    public String toString() {
        return super.toString() + " -> Comisionista{" + "porcentaje_comision=" + porcentaje_comision + ", ventas=" + ventas + "}";
    }
}
class PorHoras extends Trabajador {
    double sueldo_fijo, sueldo_horasextra;
    int horas;
    public PorHoras(double sueldo_fijo, double sueldo_horasextra, int horas, String nombre, String apellido, String direccion, String DNI, Jefe jefe) {
        super(nombre, apellido, direccion, DNI, jefe);
        this.sueldo_fijo = sueldo_fijo;
        this.sueldo_horasextra = sueldo_horasextra;
        this.horas = horas;
        this.sueldo = calcularSueldo();
    }

    public double calcularSueldo() {
        if (horas > 40) {
            return (sueldo_fijo * 40) + ((horas - 40) * sueldo_horasextra);
        } else {
            return sueldo_fijo * horas;
        }
    }
    @Override
    public String toString() {
        return super.toString() + " -> PorHoras{" + "sueldo_fijo=" + sueldo_fijo + ", sueldo_horasextra=" + sueldo_horasextra + ", horas=" + horas + "}";
    }
}
class Jefe extends Trabajador {
    double cantidad_fija;
    public Jefe(double cantidad_fija, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.cantidad_fija = cantidad_fija;
        this.sueldo = cantidad_fija;
    }
    @Override
    public String toString() {
        return super.toString() + " -> Jefe{" + "cantidad_fija=" + cantidad_fija + "}";
    }
}
public class Problema_04_Ejecutor_Empresa {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe(20500, "Jonathan", "Alvarez", "KGM", "485");
        Comisionista comisionista = new Comisionista(18.0, 500, "Juan", "Quezada", "sauces norte", "1", jefe1);
        PorHoras trabajadorHoras = new PorHoras(10, 15, 50, "Vannesa", "Merino", "San Cayetano", "458", jefe1);
        Trabajador[] trabajadores = {jefe1, comisionista, trabajadorHoras};
        Empresa empresa = new Empresa(trabajadores);
        System.out.println(empresa);
    }
}
/**
 * run:
Empresa{
  trabajadores=[
  Trabajador{nombre='Jonathan', apellido='Alvarez', direccion='KGM', DNI='485', sueldo=20500.0, jefe=Ninguno} -> Jefe{cantidad_fija=20500.0}, 
  Trabajador{nombre='Juan', apellido='Quezada', direccion='sauces norte', DNI='1', sueldo=90.0, jefe=Jonathan} -> Comisionista{porcentaje_comision=18.0, ventas=500}, 
  Trabajador{nombre='Vannesa', apellido='Merino', direccion='San Cayetano', DNI='458', sueldo=550.0, jefe=Jonathan} -> PorHoras{sueldo_fijo=10.0, sueldo_horasextra=15.0, horas=50}]
}
BUILD SUCCESSFUL (total time: 0 seconds)
 */