/**
 * El banco UN BANCO mantiene las cuentas de varios clientes. Los datos que 
 * describen a cada una de las cuentas consisten en el número de cuenta, el
 * nombre del cliente y el balance actual. Escriba una clase para implementar 
 * dicha cuenta bancaria. El método constructor debe aceptar como parámetros el 
 * número de cuenta y el nombre. Debe proporcionarse métodos para depositar o 
 * retirar una cantidad de dinero y obtener el balance actual.

El banco ofrece a sus clientes dos tipos de cuentas, una de CHEQUES y una de
* AHORROS. Una cuenta de cheques puede sobregirarse (el balance puede ser menor 
* que cero), pero una cuenta de ahorros no. Al final de cada mes, se calcula el 
* interés sobre la cantidad que tenga la cuenta de ahorros. Este interés se suma
* al balance. Escriba clases para describir cada uno de estos tipos de cuentas, 
* haciendo un máximo uso de la herencia. La clase de la cuenta de ahorros debe 
* proporcionar un método que sea invocado para calcular el interés. Además, el 
* banco está pensando en implementar una cuenta PLATINO que viene siendo similar
* a los otros dos tipos anteriores de cuentas bancarias, ésta tiene el interés 
* del 10%, sin cargos ni castigos por sobregiro.
 * @author Jonathan Alvarez
 * @version 1.0
 */
import java.util.ArrayList;

class CuentaBancaria {
    public String numeroCuenta;
    public String nombreCliente;
    public double balanceActual;
    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balanceActual = 0.0; 
    }
    public void depositar(double cantidad) {
        this.balanceActual += cantidad;
    }

    public void retirar(double cantidad) {
        this.balanceActual -= cantidad;
    }
}
class CuentaCheques extends CuentaBancaria {
    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }
}
class CuentaAhorros extends CuentaBancaria {
    public double tasaInteres;
    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }
    public void calcularIntereses() {
        double interes = this.balanceActual * this.tasaInteres;
        this.balanceActual += interes;
    }
    public void retirar(double cantidad) {
        if (this.balanceActual - cantidad >= 0) {
            this.balanceActual -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" + "tasaInteres=" + tasaInteres + '}';
    }
     
}

class CuentaPlatino extends CuentaBancaria {
    public double tasaInteres = 0.10;
    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }
    public void calcularInteresPlatino() {
        double interes = this.balanceActual * this.tasaInteres;
        this.balanceActual += interes;
    }

    @Override
    public String toString() {
        return "CuentaPlatino{" + "tasaInteres=" + tasaInteres + '}';
    }
    
}
class Banco {
    public ArrayList<CuentaCheques> cuentasCheques;
    public ArrayList<CuentaAhorros> cuentasAhorros;
    public ArrayList<CuentaPlatino> cuentasPlatino;
    public Banco() {
        this.cuentasCheques = new ArrayList<>();
        this.cuentasAhorros = new ArrayList<>();
        this.cuentasPlatino = new ArrayList<>();
    }
    public String obtenerEstado(String numCuenta) {
        for (int i = 0; i < cuentasCheques.size(); i++) {
            if (cuentasCheques.get(i).numeroCuenta.equals(numCuenta)) {
                return "Cheques | Cliente: " + cuentasCheques.get(i).nombreCliente + 
                       " | Balance: " + cuentasCheques.get(i).balanceActual + "$";
            }
        }
        for (int i = 0; i < cuentasAhorros.size(); i++) {
            if (cuentasAhorros.get(i).numeroCuenta.equals(numCuenta)) {
                return "Ahorros | Cliente: " + cuentasAhorros.get(i).nombreCliente + 
                       " | Balance: " + cuentasAhorros.get(i).balanceActual + "$";
            }
        }
        for (int i = 0; i < cuentasPlatino.size(); i++) {
            if (cuentasPlatino.get(i).numeroCuenta.equals(numCuenta)) {
                return "Platino | Cliente: " + cuentasPlatino.get(i).nombreCliente + 
                       " | Balance: " + cuentasPlatino.get(i).balanceActual + "$";
            }
        }
        return "Cuenta no encontrada.";
    }
    @Override
    public String toString() {
        return "Banco{" + "cuentasCheques=" + cuentasCheques + ", cuentasAhorros=" + cuentasAhorros + ", cuentasPlatino=" + cuentasPlatino + '}';
    }
}
public class Problema_06_EjecutorBanco {
    public static void main(String[] args) {
        Banco miBanco = new Banco();
        CuentaCheques ch1 = new CuentaCheques("01", "Jonathan Alvarez");
        CuentaAhorros ah1 = new CuentaAhorros("02", "Lionel Messi", 0.05);
        CuentaPlatino pl1 = new CuentaPlatino("03", "Cristiano Ronaldo");

        miBanco.cuentasCheques.add(ch1);
        miBanco.cuentasAhorros.add(ah1);
        miBanco.cuentasPlatino.add(pl1);

        ch1.depositar(8465);
        ch1.retirar(454);

        ah1.depositar(1000);
        ah1.retirar(200);
        ah1.calcularIntereses();

        pl1.depositar(5488);
        pl1.retirar(1500);  
        pl1.calcularInteresPlatino();  
 
        System.out.println(miBanco.obtenerEstado("01"));
        System.out.println(miBanco.obtenerEstado("02"));
        System.out.println(miBanco.obtenerEstado("03"));
        System.out.println(miBanco.obtenerEstado("04")); 
    }
}
/**
run:
Cheques | Cliente: Jonathan Alvarez | Balance: 8011.0$
Ahorros | Cliente: Lionel Messi | Balance: 840.0$
Platino | Cliente: Cristiano Ronaldo | Balance: 4386.8$
Cuenta no encontrada.
BUILD SUCCESSFUL (total time: 0 seconds)

 */
