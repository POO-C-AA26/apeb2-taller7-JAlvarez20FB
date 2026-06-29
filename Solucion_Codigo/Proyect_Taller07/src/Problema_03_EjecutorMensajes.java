/**
 * Implemente un sistema de envío de mensajes a móviles. Existen dos tipos de
 * mensajes que se pueden enviar entre móviles, mensajes de texto (SMS) y mensajes que contienen imágenes (MMS). Por un lado, los mensajes de texto contienen un mensaje en caracteres que se desea enviar de un móvil a otro. Por otro lado, los mensajes que contienen imágenes almacenan información sobre la imagen a enviar, la cual se representará por el nombre del fichero que la contiene. Independientemente del tipo de mensaje, cada mensaje tendrá asociado un remitente de dicho mensaje y un destinatario. Ambos estarán definidos obligatoriamente por un número de móvil, y opcionalmente se podrá guardar información sobre su nombre. Además, los métodos enviarMensaje y visualizarMensaje deben estar definidos.
Note
Para probar el diseño jerarquico de clases, instancia en el clase de
* prueba Ejecutor, con datos ficticios.
 * @author Jonathan Alvarez
 * @version 1.0
 */

class Mensaje{
    int remitente_num;
    int destinario_num;
    String remitente = "";
    String destinario = "";
    public Mensaje(int remitente_num, int destinario_num) {
        this.remitente_num = remitente_num;
        this.destinario_num = destinario_num;
    }
    public Mensaje(int remitente_num, int destinario_num, String remitente, String destinario) {
        this.remitente_num = remitente_num;
        this.destinario_num = destinario_num;
        this.remitente = remitente;
        this.destinario = destinario;
    }
    public String enviarmensaje(String msj){
        String envio;
        envio= "("+msj+")";
        envio += " ENVIADO A "+this.destinario+" "+this.destinario_num + "\n";
        return envio;
    }
    public String visualizarmensaje(String msj){
        String visualizacion;
        visualizacion = "De: "+this.remitente+" "+this.remitente_num + "\n";
        visualizacion += "Para: "+this.destinario+" "+this.destinario_num + "\n";
        visualizacion+= msj+"\n";
        return visualizacion;
    }
    @Override
    public String toString() {
        return "Mensaje{" + "remitente_num=" + remitente_num + ", destinario_num=" + destinario_num + ", remitente=" + remitente + ", destinaario=" + destinario + '}';
    }
}
class SMS extends Mensaje{
    String mensaje;
    public SMS(String mensaje, int remitente_num, int destinario_num) {
        super(remitente_num, destinario_num);
        this.mensaje = mensaje;
    }
    public SMS(String mensaje, int remitente_num, int destinario_num, String remitente, String destinario) {
        super(remitente_num, destinario_num, remitente, destinario);
        this.mensaje = mensaje;
    }
    @Override
    public String toString() {
        return "SMS{" + "mensaje=" + mensaje + '}';
    }
}
class MMS extends Mensaje{
    String fichero;
    public MMS(String fichero, int remitente_num, int destinario_num) {
        super(remitente_num, destinario_num);
        this.fichero = fichero;
    }
    public MMS(String fichero, int remitente_num, int destinario_num, String remitente, String destinario) {
        super(remitente_num, destinario_num, remitente, destinario);
        this.fichero = fichero;
    }
    @Override
    public String toString() {
        return "MMS{" + "fichero=" + fichero + '}';
    }
}
public class Problema_03_EjecutorMensajes{
    public static void main(String[] args) {
       SMS msj1 = new SMS("Hola", 15584451,61451465);
       SMS msj2 = new SMS("hey, como estas?", 515,548, "Francisca","Jonathan");
       MMS img1 = new MMS("C://documentos/2026/varios", 777, 911, "Jonathan","Emergencias Loja");
       MMS img2 = new MMS("C://documentos/tareas/poo_taller7", 158, 15458);
        System.out.println(msj1.enviarmensaje(msj1.mensaje));
        System.out.println(msj2.enviarmensaje(msj2.mensaje));
        System.out.println(img1.enviarmensaje(img1.fichero));
        System.out.println(img2.enviarmensaje(img2.fichero));
        System.out.println(msj1.visualizarmensaje(msj1.mensaje));
        System.out.println(msj2.visualizarmensaje(msj2.mensaje));
        System.out.println(img1.visualizarmensaje(img1.fichero));
        System.out.println(img2.visualizarmensaje(img2.fichero));
    }
}
/**
run:
(Hola) ENVIADO A  61451465

(hey, como estas?) ENVIADO A Jonathan 548

(C://documentos/2026/varios) ENVIADO A Emergencias Loja 911

(C://documentos/tareas/poo_taller7) ENVIADO A  15458

De:  15584451
Para:  61451465
Hola

De: Francisca 515
Para: Jonathan 548
hey, como estas?

De: Jonathan 777
Para: Emergencias Loja 911
C://documentos/2026/varios

De:  158
Para:  15458
C://documentos/tareas/poo_taller7

BUILD SUCCESSFUL (total time: 0 seconds)
 */
