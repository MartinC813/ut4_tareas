package ut4_pd0;

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
    public boolean insertar(Comparable etiqueta, Object dato, int[] cont) {
        TElementoAB nodo = new TElementoAB(etiqueta, dato);
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo, cont);
    }

   
    public boolean insertaObjeto(TElementoAB nodo, int[] cont) {
        if(raiz== null){
            raiz = nodo;
            return true;
        }
        return raiz.insertar(nodo, cont);
    }

    @Override
    public String preOrden() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preOrden'");
    }

    @Override
    public String inOrden() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrden'");
    }

    @Override
    public String postOrden() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrden'");
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
