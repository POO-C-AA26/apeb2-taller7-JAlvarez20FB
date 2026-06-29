import java.util.Scanner;

public class Principal{
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        Lista lista=new Lista();
        int opcion;
        int dato;
        int buscar;
        int nuevo;
        int limite;
        int posicion;
        int cantidad;
        do{
            System.out.println("\n========= MENU =========");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Insertar despues de un numero");
            System.out.println("4. Calcular promedio");
            System.out.println("5. Eliminar el mayor");
            System.out.println("6. Mostrar repetidos");
            System.out.println("7. Mostrar lista invertida");
            System.out.println("8. Verificar orden");
            System.out.println("9. Eliminar mayores que un limite");
            System.out.println("10. Invertir lista");
            System.out.println("11. Ordenar por burbuja");
            System.out.println("12. Eliminar n nodos desde una posicion");
            System.out.println("13. Particionar lista");
            System.out.println("14. Eliminar elementos repetidos");
            System.out.println("15. Union de dos listas");
            System.out.println("16. Altura de un arbol binario");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion=entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.print("Dato: ");
                    dato=entrada.nextInt();
                    lista.insertarFinal(dato);
                break;
                case 2:
                    lista.mostrar();
                break;
                case 3:
                    System.out.print("Numero a buscar: ");
                    buscar=entrada.nextInt();
                    System.out.print("Nuevo numero: ");
                    nuevo=entrada.nextInt();
                    lista.insertarDespues(buscar,nuevo);
                break;
                case 4:
                    System.out.println("Promedio = "+lista.promedio());
                break;
                case 5:
                    lista.eliminarMayor();
                    System.out.println("Mayor eliminado.");
                break;
                case 6:
                    Lista r=lista.repetidos();
                    System.out.println("Lista de repetidos:");
                    r.mostrar();
                break;
                case 7:
                    lista.mostrarInvertido();
                break;
                case 8:
                    int estado=lista.orden();
                    if(estado==1)
                        System.out.println("Lista Ascendente");
                    else if(estado==2)
                        System.out.println("Lista Descendente");
                    else
                        System.out.println("Lista Desordenada");
                break;
                case 9:
                    System.out.print("Limite: ");
                    limite=entrada.nextInt();
                    lista.eliminarMayores(limite);
                break;
                case 10:
                    lista.invertirLista();
                    System.out.println("Lista invertida.");
                break;
                case 11:
                    lista.ordenarBurbuja();
                    System.out.println("Lista ordenada.");
                break;
                case 12:
                    System.out.print("Posicion: ");
                    posicion=entrada.nextInt();
                    System.out.print("Cantidad de nodos: ");
                    cantidad=entrada.nextInt();
                    lista.eliminarDesdePosicion(posicion,cantidad);
                break;
                case 13:
                    Lista[] listas=lista.particionar();
                    System.out.println("Lista 1");
                    listas[0].mostrar();
                    System.out.println("Lista 2");
                    listas[1].mostrar();
                break;
                case 14:
                    lista.eliminarRepetidos();
                    System.out.println("Repetidos eliminados.");
                break;
                case 15:
                    Lista l1=new Lista();
                    Lista l2=new Lista();

                    l1.insertarFinal(1);
                    l1.insertarFinal(3);
                    l1.insertarFinal(5);
                    l1.insertarFinal(7);

                    l2.insertarFinal(2);
                    l2.insertarFinal(3);
                    l2.insertarFinal(4);
                    l2.insertarFinal(7);
                    l2.insertarFinal(8);
                    Lista union=Lista.unirListas(l1,l2);
                    System.out.println("Lista 1");
                    l1.mostrar();
                    System.out.println("Lista 2");
                    l2.mostrar();
                    System.out.println("Union");
                    union.mostrar();
                break;
                case 16:
                    Arbol arbol=new Arbol();
                    arbol.insertar(50);
                    arbol.insertar(30);
                    arbol.insertar(70);
                    arbol.insertar(20);
                    arbol.insertar(40);
                    arbol.insertar(60);
                    arbol.insertar(80);
                    System.out.print("Recorrido InOrden: ");
                    arbol.inOrden();
                    System.out.println("Altura = "+arbol.altura());
                break;
                case 0:
                    System.out.println("Programa finalizado.");

                break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }while(opcion!=0);
    }
}1