package ut4_ta4;

public class Main {
    public static void main(String[] args) {
        TElementoAB<Integer> nodo =  new TElementoAB<Integer>("T", 1);
        TElementoAB<Integer> nodo2 = new TElementoAB<Integer>("Y", 2);
        TElementoAB<Integer> nodo3 = new TElementoAB<Integer>("U", 3);
        TElementoAB<Integer> nodo4 =  new TElementoAB<Integer>("P", 4);
        TElementoAB<Integer> nodo5 =  new TElementoAB<Integer>("L", 5);
        TElementoAB<Integer> nodo6 = new TElementoAB<Integer>("K", 6);
        TElementoAB<Integer> nodo7 = new TElementoAB<Integer>("J", 7);
        TElementoAB<Integer> nodo8 = new TElementoAB<Integer>("S", 8);
        TElementoAB<Integer> nodo9 = new TElementoAB<Integer>("A", 9);
        TElementoAB<Integer> nodo10 = new TElementoAB<Integer>("Z",10);
        TElementoAB<Integer> nodo11 = new TElementoAB<Integer>("X",11);
        TElementoAB<Integer> nodo12 = new TElementoAB<Integer>("C",12);
        TElementoAB<Integer> nodo13 = new TElementoAB<Integer>("V",13);
        TElementoAB<Integer> nodo14 = new TElementoAB<Integer>("N", 14);
        TArbolBB arbol = new TArbolBB();
        arbol.insertar(nodo);
        arbol.insertar(nodo2);
        arbol.insertar(nodo3);
        arbol.insertar(nodo4);
        arbol.insertar(nodo5);
        arbol.insertar(nodo6);
        arbol.insertar(nodo7);
        arbol.insertar(nodo8);
        arbol.insertar(nodo9);
        arbol.insertar(nodo10);
        arbol.insertar(nodo11);
        arbol.insertar(nodo12);
        arbol.insertar(nodo13);
        arbol.insertar(nodo14);
        arbol.ObtenerHojas();
    }
}
//T,Y,U,P,L,K,J,S,A,Z,X,C,V,N