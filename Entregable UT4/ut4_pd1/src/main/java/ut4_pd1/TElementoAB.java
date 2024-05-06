package ut4_pd1;

public class TElementoAB<T> implements IElementoAB {

    Comparable etiqueta;
    TElementoAB hijoIzq;
    TElementoAB hijoDer;
    T datos;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos){
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        TElementoAB resultado = null;
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            resultado = this;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (this.hijoIzq != null) {
                    resultado = hijoIzq.buscar(unaEtiqueta);
                }
            } else {
                if (hijoDer != null) {
                    resultado = hijoDer.buscar(unaEtiqueta);
                }
            }
        }
        return resultado;
    }

    @Override
    public boolean insertar(TElementoAB elemento) {
        if(this.etiqueta.equals(elemento.etiqueta)){
            return false;
        }
        if(elemento.etiqueta.compareTo(etiqueta) == -1){
            if(this.hijoIzq == null){
                this.hijoIzq = elemento;
                
                return true;
            }
            else{
                hijoIzq.insertar(elemento);
            }
        }
        else{
            if(this.hijoDer == null){
                this.hijoDer = elemento;
                return true;
            }
            else{
                hijoDer.insertar(elemento);
            }
        }
        return false;
    }

    @Override
    public String preOrden() {
        String fin = "";
        fin += this.getEtiqueta();
        if(this.getHijoIzq() != null){
            fin += this.getHijoIzq().preOrden();
        }
        if(this.getHijoDer() != null){
            fin += this.getHijoDer().preOrden();
        }
        return fin;
    }

    @Override
    public String inOrden() {
        String fin = "";
        if(this.getHijoIzq() != null){
            fin += this.getHijoIzq().inOrden();
        }
        fin += this.getEtiqueta();
        if(this.getHijoDer() != null){
            fin += this.getHijoDer().inOrden();
        }
        return fin;
    }

    @Override
    public String postOrden() {
        String fin = "";
        if(this.getHijoIzq() != null){
            fin += this.getHijoIzq().postOrden();
        }
        if(this.getHijoDer() != null){
            fin += this.getHijoDer().postOrden();
        }
        fin += this.getEtiqueta();
        return fin;
    }

    @Override
    public Object getDatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDatos'");
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }

            return this; 
        }
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }

            return this;
        }
        return quitaElNodo();
    }

    public TElementoAB quitaElNodo() {
        if (this.hijoIzq == null) {
            return hijoDer;
        } else {
            if (this.hijoDer == null) {
                return hijoIzq;
            } else {
                TElementoAB elHijo = this.hijoIzq;
                TElementoAB elPadre = this;
                while (elHijo.hijoDer != null) {
                    elPadre = elHijo;
                    elHijo = elHijo.hijoDer;
                }

                if (elPadre != this) {
                    elPadre.hijoDer = elHijo.hijoIzq;
                    elHijo.hijoIzq = hijoIzq;
                }

                elHijo.hijoDer = hijoDer;
                return elHijo;
            }
        }
        

    }

    public int obtenerTamano() {
        return 0;
    }
    
    public int obtenerAltura() {
        return 0;
    }
}
