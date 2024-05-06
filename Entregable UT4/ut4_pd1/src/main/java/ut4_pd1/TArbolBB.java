package ut4_pd1;

public class TArbolBB implements IArbolBB {

    TElementoAB raiz;

    public TArbolBB() {
        this.raiz = null;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if (this.raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public boolean insertar(Comparable etiqueta, Object dato) {
        TElementoAB nodo = new TElementoAB(etiqueta, dato);
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo);
    }

    /*
    Mismo metodo con el nodo ya instanciado como parametro
    */
    public boolean insertar(TElementoAB nodo) {
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo);
    }

   
    public boolean insertaObjeto(TElementoAB nodo) {
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo);
    }

    @Override
    public String preOrden() {
        String fin = "";
        if(raiz != null){
            fin += raiz.preOrden();
        }
        return fin;
    }

    @Override
    public String inOrden() {
        String fin = "";
        if(raiz != null){
            fin += raiz.inOrden();
        }
        return fin;
    }

    @Override
    public String postOrden() {
        String fin = "";
        if(raiz != null){
            fin += raiz.postOrden();
        }
        return fin;
    }

    @Override
    public Object eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
            return raiz;
        } else {
            System.out.println("Arbol vacío");
            return null;
        }
    }

    public int obtenerTamano() {
        return 0;
    }

    public int obtenerAltura() {
        return 0;
    }
}
