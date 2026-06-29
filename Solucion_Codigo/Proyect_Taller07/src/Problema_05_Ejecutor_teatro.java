/**
 *Problema 05: Dadas las siguientes clases, que expresan una relación de herencia entre las entidades:
Se desea gestionar la venta de entradas para un espectáculo en un teatro. 
* El patio de butacas del teatro se divide en varias zonas, cada una identificada 
* por su nombre. Los datos de las zonas son los mostrados en la siguiente tabla:
NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal	200	25$	17.5$
PalcoB	40	70$	40$
Central	400	20$	14$
Lateral	100	15.5$	10$
Para realizar la compra de una entrada, un espectador debe indicar la zona que 
* desea y presentar al vendedor el documento que justifique que tiene algún tipo 
* de descuento (estudiante, abonado o pensionista). El vendedor sacará la entrada 
* del tipo apropiado y de la zona indicada, en el momento de la compra se asignará 
* a la entrada un identificador (un número entero) que permitirá la identificación 
* de la entrada en todas las operaciones que posteriormente se desee realizar con ella.
Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.
Los precios de las entradas dependen de la zona y del tipo de entrada según lo explicado a continuación:
Entradas normales: su precio es el precio normal de la zona elegida sin ningún tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes casos de usos.
Note
Caso de uso “Vende entrada”:
El vendedor elige la opción “vende entrada” e introduce la zona deseada, el
* nombre del espectador y el tipo (normal, abonado o beneficiario de entrada reducida).
Si la zona elegida no está completa, la aplicación genera una nueva entrada con los datos facilitados.
Si no existe ninguna zona con ese nombre, se notifica y finaliza el caso de uso sin generar la entrada.
Si la zona elegida está completa lo notifica y finaliza el caso de uno sin generar la entrada.
La aplicación muestra el identificador y el precio de la entrada.
Caso de uso “Consulta entrada”:
El vendedor elige la opción “consulta entrada” e introduce el identificador de la entrada.
La aplicación muestra los datos de la entrada: nombre del espectador, precio y 
* nombre de la zona. Si no existe ninguna entrada con ese identificador, lo notifica y finaliza el caso de uso
 * @author Jonathan Alvarez
 * @version 2.0
 */
class Zona{
    public String nombre;  public int cantLocalidades;    public double precioNormal, precioAbonado;

    public Zona(String nombre, int cantLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.cantLocalidades = cantLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "zona{" + "nombre=" + nombre + ", cantLocalidades=" + cantLocalidades + ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + '}';
    }
    
}
class Entrada {
    public Zona zona;   public int IdEntrada, numEntradas;   public String nombreComprador;  public double costofinalEntrada;
    public double calcularCostoFinalEntrada(double precioEntrada){
        this.costofinalEntrada = (this.numEntradas *precioEntrada);
        return this.costofinalEntrada;
    }
    public Entrada(Zona zona, int IdEntrada, int numEntradas, String nombreComprador) {
        this.zona = zona;
        this.IdEntrada = IdEntrada;
        this.numEntradas = numEntradas;
        this.nombreComprador = nombreComprador;
    }
    @Override
    public String toString() {
        return "Entrada{" + "zona=" + zona + ", IdEntrada=" + IdEntrada + ", numEntradas=" + numEntradas + ", nombreComprador=" + nombreComprador + ", costofinalEntrada=" + costofinalEntrada + '}';
    }
}
class Entrada_Normal extends Entrada {
    public double calcularCostoFinalEntrada(){
        this.costofinalEntrada = (super.calcularCostoFinalEntrada(zona.precioNormal));
        return this.costofinalEntrada;
    }
    public Entrada_Normal(Zona zona, int IdEntrada, int numEntradas, String nombreComprador) {
        super(zona, IdEntrada, numEntradas, nombreComprador);
    }

    @Override
    public String toString() {
        return "Entrada_Normal{" + '}'+super.toString();
    }
    
}
class Entrada_Reducida extends Entrada {
    public double porcentajeRebaja;
    public double calcularCostoFinalEntrada(){
        this.costofinalEntrada = super.calcularCostoFinalEntrada(zona.precioNormal-(zona.precioNormal *(porcentajeRebaja/100)));
        return this.costofinalEntrada;
    }
    public Entrada_Reducida(double porcentajeRebaja, Zona zona, int IdEntrada, int numEntradas, String nombreComprador) {
        super(zona, IdEntrada, numEntradas, nombreComprador);
        this.porcentajeRebaja = porcentajeRebaja;
    }
    @Override
    public String toString() {
        return "Entrada_Reducida{" + "porcentajeRebaja=" + porcentajeRebaja + '}'+super.toString();
    }
}
class Entrada_Abonado extends Entrada {
    public double calcularCostoFinalEntrada(){
        this.costofinalEntrada = (super.calcularCostoFinalEntrada(zona.precioAbonado));
        return this.costofinalEntrada;
    }
    public Entrada_Abonado(Zona zona, int IdEntrada, int numEntradas, String nombreComprador) {
        super(zona, IdEntrada, numEntradas, nombreComprador);
    }
    @Override
    public String toString() {
        return "Entrada_Abonado{" + '}'+super.toString();
    }
}
public class Problema_05_Ejecutor_teatro {
    public static void main(String[] args) {
        Zona zona1 = new Zona("principal", 200, 25, 17.5);
        Zona zona2 = new Zona("palco B", 40, 70, 40);
        Zona zona3 = new Zona("Central", 400, 20, 14);
        Zona zona4 = new Zona("Lateral", 100, 15.5, 10);
        Entrada_Reducida cli1 = new Entrada_Reducida(15, zona1, 4578954, 4, "jonathan");
        cli1.calcularCostoFinalEntrada();
        Entrada_Normal cli2 = new Entrada_Normal(zona2, 8796754, 5, "Jhon");
        cli2.calcularCostoFinalEntrada();
        Entrada_Normal cli3 = new Entrada_Normal(zona3, 7796754, 10, "Jhony");
        cli3.calcularCostoFinalEntrada();
        Entrada_Abonado cli4 = new Entrada_Abonado(zona4, 8796754, 11, "Jhohan");
        cli4.calcularCostoFinalEntrada();
        System.out.print(cli1+"\n"+cli2+"\n"+cli3+"\n"+cli4);
    }
}
/*
run:
Entrada_Reducida{porcentajeRebaja=15.0}Entrada{zona=zona{nombre=principal, cantLocalidades=200, precioNormal=25.0, precioAbonado=17.5}, IdEntrada=4578954, numEntradas=4, nombreComprador=jonathan, costofinalEntrada=85.0}
Entrada_Normal{}Entrada{zona=zona{nombre=palco B, cantLocalidades=40, precioNormal=70.0, precioAbonado=40.0}, IdEntrada=8796754, numEntradas=5, nombreComprador=Jhon, costofinalEntrada=350.0}
Entrada_Normal{}Entrada{zona=zona{nombre=Central, cantLocalidades=400, precioNormal=20.0, precioAbonado=14.0}, IdEntrada=7796754, numEntradas=10, nombreComprador=Jhony, costofinalEntrada=200.0}
Entrada_Abonado{}Entrada{zona=zona{nombre=Lateral, cantLocalidades=100, precioNormal=15.5, precioAbonado=10.0}, IdEntrada=8796754, numEntradas=11, nombreComprador=Jhohan, costofinalEntrada=110.0}BUILD SUCCESSFUL (total time: 0 seconds)

*/