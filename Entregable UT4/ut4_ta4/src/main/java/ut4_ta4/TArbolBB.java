package ut4_ta4;

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
    public Comparable MenorClave(){
        if(this.raiz != null){
            return raiz.MenorClave();
        }
        return null;
    }
    public Comparable MayorClave(){
        if(this.raiz != null){
            return raiz.MayorClave();
        }
        return null;
    }

    public int obtenerTamano() {
        int res = 0;
        if(this.raiz != null){
            res += raiz.obtenerTamano();
        }
        return res;
    }

    public int obtenerAltura() {
        int res = 0;
        if(this.raiz != null){
            res += raiz.obtenerAltura();
        }
        return res;
    }
    public int ObtenerHojas(){
        int res = 0;
        if(raiz!= null){
            res += raiz.ObtenerHojas();
        }
        return res;
    }
    public int SumaDeEnteros(){
        int res = 0;
        if(raiz!= null){
            res += raiz.SumaDeEnteros();
        }
        return res;
    }
    public int Nivelnodos(int nivel){
        int cantidad = 0;
        if(raiz != null){
            return raiz.Nivelnodos(nivel, cantidad);
        }
        return 0;
    }
    public int NivelNodoEspecifico(Comparable et){
        int nivelActual = 1;
        if(raiz != null){
            return raiz.NivelNodoEspecifico(et, nivelActual);
        }
        return 0;
    }
}
