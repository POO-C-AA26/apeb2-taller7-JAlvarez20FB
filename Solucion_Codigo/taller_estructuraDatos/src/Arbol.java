public class Arbol{
    NodoArbol raiz;
    public Arbol(){
        raiz=null;
    }
    //=========================================
    //INSERTAR
    //=========================================
    private NodoArbol insertar(NodoArbol nodo,int dato){
        if(nodo==null){
            return new NodoArbol(dato);
        }
        if(dato<nodo.dato){
            nodo.izquierda=insertar(nodo.izquierda,dato);
        }else{
            nodo.derecha=insertar(nodo.derecha,dato);
        }
        return nodo;
    }
    public void insertar(int dato){
        raiz=insertar(raiz,dato);
    }
    //=========================================
    //RECORRIDO INORDEN
    //=========================================
    private void inOrden(NodoArbol nodo){
        if(nodo!=null){
            inOrden(nodo.izquierda);
            System.out.print(nodo.dato+" ");
            inOrden(nodo.derecha);
        }
    }
    public void inOrden(){
        inOrden(raiz);
        System.out.println();
    }
    //=========================================
    //14. ALTURA DEL ÁRBOL
    //=========================================
    private int altura(NodoArbol nodo){
        if(nodo==null)
            return 0;
        int izquierda=altura(nodo.izquierda);
        int derecha=altura(nodo.derecha);
        if(izquierda>derecha){
            return izquierda+1;
        }else{
            return derecha+1;
        }
    }
    public int altura(){
        return altura(raiz);
    }
}