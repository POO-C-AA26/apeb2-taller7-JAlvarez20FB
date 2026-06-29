
import java.util.Arrays;

/**
 * Dibuje un diagrama de clases que muestre la estructura de un capítulo de 
 * libro; un capítulo está compuestopor varias secciones, cada una de las cuales 
 * comprende varios párrafos y figuras. Un párrafo incluye varias 
 * sentencias, cada una de las cuales contiene varias palabras.
 * @author Jonathan Alvarez
 * @version 1.0
 */
class Capitulo{
    String titulo;
    Seccion[] secciones;
    public Capitulo(String titulo, Seccion[] secciones) {
        this.titulo = titulo;
        this.secciones = secciones;
    }
    @Override
    public String toString() {
        return "Capitulo{" + "titulo=" + titulo + ", secciones=" + Arrays.toString(secciones) + '}';
    }
}
class Seccion{
    public Seccion() {
    }
    @Override
    public String toString() {
        return "Seccion{" + '}';
    }
}
class Parrafo extends Seccion{
    String[] sentencias;
    public Parrafo(String[] sentencias) {
        this.sentencias = sentencias;
    }
    @Override
    public String toString() {
        return "Parrafo{" + "sentencias=" + Arrays.toString(sentencias) + '}';
    }  
}
class Figura extends Seccion{
    String figura;
    public Figura(String figura) {
        this.figura = figura;
    }
    @Override
    public String toString() {
        return "figura{" + "figura=" + figura + '}';
    }
}
public class Problema_01_Ejecutor_Libro {
    public static void main(String[] args) {
        String[] sentencias1 = {"texto de ejemplo 1","texto de ejemplo 2","texto de ejemplo 3"};
        String[] sentencias2 = {"hola", " HOLA"};
        Parrafo prf1 = new Parrafo(sentencias1);
        Parrafo prf2 = new Parrafo(sentencias2);
        Figura fig1 = new Figura("triangulo");
        Figura fig2 = new Figura("Cuadrado");       
        Seccion[] secciones1 = {prf1, fig1, fig2};
        Seccion[] secciones2 = {prf1,prf2, fig2};
        Seccion[] secciones3 = {fig1,fig1,fig1,fig1,fig1};
        Capitulo cap1 = new Capitulo("la bella y la bestia",secciones1);
        Capitulo cap2 = new Capitulo("la bella sin la bestia",secciones2);
        Capitulo cap3 = new Capitulo("que bestia esa bella",secciones3);
        System.out.println(cap1);
        System.out.println(cap2);
        System.out.println(cap3);
    }
}
/**
run:
Capitulo{titulo=la bella y la bestia, secciones=[Parrafo{sentencias=[texto de ejemplo 1, texto de ejemplo 2, texto de ejemplo 3]}, figura{figura=triangulo}, figura{figura=Cuadrado}]}
Capitulo{titulo=la bella sin la bestia, secciones=[Parrafo{sentencias=[texto de ejemplo 1, texto de ejemplo 2, texto de ejemplo 3]}, Parrafo{sentencias=[hola,  HOLA]}, figura{figura=Cuadrado}]}
Capitulo{titulo=que bestia esa bella, secciones=[figura{figura=triangulo}, figura{figura=triangulo}, figura{figura=triangulo}, figura{figura=triangulo}, figura{figura=triangulo}]}
BUILD SUCCESSFUL (total time: 0 seconds)
 */