public class Lista{
    Nodo raiz;
    public Lista(){
        raiz=null;
    }
    //=================================================
    //INSERTAR AL FINAL
    //=================================================

    public void insertarFinal(int dato){

        Nodo nuevo=new Nodo(dato);
        if(raiz==null){
            raiz=nuevo;
            return;
        }
        Nodo aux=raiz;
        while(aux.siguiente!=null){
            aux=aux.siguiente;
        }
        aux.siguiente=nuevo;
    }
    //=================================================
    //MOSTRAR
    //=================================================
    public void mostrar(){
        Nodo aux=raiz;
        while(aux!=null){
            System.out.print(aux.dato+" ");
            aux=aux.siguiente;
        }
        System.out.println();
    }

    //=================================================
    //1. INSERTAR DESPUÉS DE UN NÚMERO
    //=================================================
    public void insertarDespues(int buscar,int nuevo){
        Nodo aux=raiz;
        while(aux!=null){
            if(aux.dato==buscar){
                Nodo n=new Nodo(nuevo);
                n.siguiente=aux.siguiente;
                aux.siguiente=n;
                return;
            }
            aux=aux.siguiente;
        }
        System.out.println("Numero no encontrado.");
    }
    //=================================================
    //2. PROMEDIO
    //=================================================

    public double promedio(){
        if(raiz==null)
            return 0;
        int suma=0;
        int contador=0;
        Nodo aux=raiz;
        while(aux!=null){
            suma+=aux.dato;
            contador++;
            aux=aux.siguiente;
        }
        return (double)suma/contador;
    }
    //=================================================
    //3. ELIMINAR EL MAYOR
    //=================================================

    public void eliminarMayor(){

        if(raiz==null)
            return;
        Nodo mayor=raiz;
        Nodo anteriorMayor=null;
        Nodo anterior=null;
        Nodo aux=raiz;
        while(aux!=null){
            if(aux.dato>mayor.dato){
                mayor=aux;
                anteriorMayor=anterior;
            }
            anterior=aux;
            aux=aux.siguiente;
        }
        if(anteriorMayor==null){
            raiz=raiz.siguiente;
        }else{
            anteriorMayor.siguiente=mayor.siguiente;
        }
    }
    //=================================================
    //4. UNIR DOS LISTAS ORDENADAS
    //=================================================
    public static Lista unirListas(Lista l1,Lista l2){
        Lista nueva=new Lista();
        Nodo p=l1.raiz;
        Nodo q=l2.raiz;
        while(p!=null && q!=null){
            if(p.dato<q.dato){
                nueva.insertarFinal(p.dato);
                p=p.siguiente;
            }
            else if(q.dato<p.dato){
                nueva.insertarFinal(q.dato);
                q=q.siguiente;
            }
            else{
                nueva.insertarFinal(p.dato);
                p=p.siguiente;
                q=q.siguiente;
            }
        }
        while(p!=null){
            nueva.insertarFinal(p.dato);
            p=p.siguiente;
        }
        while(q!=null){
            nueva.insertarFinal(q.dato);
            q=q.siguiente;
        }
        return nueva;
    }
    //=================================================
    //5. DEVOLVER LISTA DE REPETIDOS
    //=================================================
    public Lista repetidos(){
        Lista r=new Lista();
        Nodo p=raiz;
        while(p!=null){
            int contador=0;
            Nodo q=raiz;
            while(q!=null){
                if(q.dato==p.dato)
                    contador++;
                q=q.siguiente;
            }
            if(contador>1){
                boolean existe=false;
                Nodo x=r.raiz;
                while(x!=null){
                    if(x.dato==p.dato){
                        existe=true;
                        break;
                    }
                    x=x.siguiente;
                }
                if(!existe)

                    r.insertarFinal(p.dato);
            }
            p=p.siguiente;
        }
        return r;
    }
    //=================================================
    //6. MOSTRAR LA LISTA EN FORMA INVERTIDA
    //=================================================
    public void mostrarInvertido(){
        mostrarInvertido(raiz);
        System.out.println();
    }
    private void mostrarInvertido(Nodo nodo){

        if(nodo==null)
            return;
        mostrarInvertido(nodo.siguiente);
        System.out.print(nodo.dato+" ");
    }
    //=================================================
    //7. VERIFICAR SI LA LISTA ESTÁ ORDENADA
    //1 = Ascendente
    //2 = Descendente
    //0 = No ordenada
    //=================================================
    public int orden(){
        if(raiz==null || raiz.siguiente==null)
            return 1;
        boolean asc=true;
        boolean des=true;
        Nodo aux=raiz;
        while(aux.siguiente!=null){
            if(aux.dato>aux.siguiente.dato)
                asc=false;
            if(aux.dato<aux.siguiente.dato)
                des=false;
            aux=aux.siguiente;
        }
        if(asc)
            return 1;
        if(des)
            return 2;
        return 0;
    }
    //=================================================
    //8. ELIMINAR LOS MAYORES QUE UN LÍMITE
    //=================================================

    public void eliminarMayores(int limite){

        while(raiz!=null && raiz.dato>limite){
            raiz=raiz.siguiente;
        }
        Nodo aux=raiz;
        while(aux!=null && aux.siguiente!=null){
            if(aux.siguiente.dato>limite){
                aux.siguiente=aux.siguiente.siguiente;
            }else{
                aux=aux.siguiente;
            }
        }
    }

    //=================================================
    //9. INVERTIR LOS NODOS DE LA LISTA
    //=================================================

    public void invertirLista(){
        Nodo anterior=null;
        Nodo actual=raiz;
        Nodo siguiente;
        while(actual!=null){
            siguiente=actual.siguiente;
            actual.siguiente=anterior;
            anterior=actual;
            actual=siguiente;
        }
        raiz=anterior;
    }
    //=================================================
    //10. ORDENAR POR BURBUJA
    //=================================================

    public void ordenarBurbuja(){
        if(raiz==null)
            return;
        boolean cambio;
        do{
            cambio=false;
            Nodo aux=raiz;
            while(aux.siguiente!=null){
                if(aux.dato>aux.siguiente.dato){
                    int temp=aux.dato;
                    aux.dato=aux.siguiente.dato;
                    aux.siguiente.dato=temp;
                    cambio=true;
                }
                aux=aux.siguiente;
            }
        }while(cambio);
    }

    //=================================================
    //11. ELIMINAR N NODOS DESDE LA POSICIÓN X
    //=================================================

    public void eliminarDesdePosicion(int posicion,int cantidad){
        if(raiz==null || cantidad<=0)
            return;
        if(posicion==1){
            while(raiz!=null && cantidad>0){
                raiz=raiz.siguiente;
                cantidad--;
            }
            return;
        }
        Nodo aux=raiz;
        for(int i=1;i<posicion-1 && aux!=null;i++){
            aux=aux.siguiente;
        }
        if(aux==null)
            return;
        Nodo borrar=aux.siguiente;
        while(borrar!=null && cantidad>0){
            borrar=borrar.siguiente;
            cantidad--;
        }
        aux.siguiente=borrar;
    }
    //=================================================
    //12. PARTICIONAR LA LISTA EN DOS LISTAS
    //=================================================
    public Lista[] particionar(){
        Lista lista1=new Lista();
        Lista lista2=new Lista();
        int total=0;
        Nodo aux=raiz;
        while(aux!=null){
            total++;
            aux=aux.siguiente;
        }
        int mitad=total/2;
        aux=raiz;
        int contador=0;
        while(aux!=null){
            if(contador<mitad){
                lista1.insertarFinal(aux.dato);
            }else{
                lista2.insertarFinal(aux.dato);
            }
            contador++;
            aux=aux.siguiente;
        }
        return new Lista[]{lista1,lista2};
    }
    //=================================================
    //13. ELIMINAR TODOS LOS ELEMENTOS REPETIDOS
    //=================================================

    public void eliminarRepetidos(){
        Nodo actual=raiz;
        Nodo anterior=null;
        while(actual!=null){
            int contador=0;
            Nodo aux=raiz;
            while(aux!=null){
                if(aux.dato==actual.dato)
                    contador++;
                aux=aux.siguiente;
            }
            if(contador>1){
                if(anterior==null){
                    raiz=actual.siguiente;
                    actual=raiz;
                }else{
                    anterior.siguiente=actual.siguiente;
                    actual=actual.siguiente;
                }
            }else{
                anterior=actual;

                actual=actual.siguiente;
            }
        }
    }
}