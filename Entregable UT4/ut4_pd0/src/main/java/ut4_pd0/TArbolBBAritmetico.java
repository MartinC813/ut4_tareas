package ut4_pd0;

public class TArbolBBAritmetico extends TArbolBB{

    TElementoAB raiz;

    public TArbolBBAritmetico() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(Comparable etiqueta, Object dato, int[] cont) {
        TElementoAB nodo = new TElementoAB(etiqueta, dato);
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo, cont);
    }
}
