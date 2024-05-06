package ut4_ta4;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

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
        //Si la diferencia es menor a 0, es que es menor el elemento.
        if(elemento.etiqueta.compareTo(etiqueta) < 0){
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
    public boolean insertarErroneoDerecha(TElementoAB elemento) {
        this.hijoDer = elemento;
        return true;
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
    //1
    public Comparable MenorClave(){
        if(getHijoIzq() != null)
            return getHijoIzq().MenorClave();
        return getEtiqueta();
    }
    //2
    public Comparable MayorClave(){
        if(getHijoDer() != null)
            return getHijoDer().MayorClave();
        return getEtiqueta();
    }
    //3
    public Comparable EtiquetaAnterior(Comparable etiqueta){
        if(getHijoIzq() != null){
            if(getHijoIzq().getEtiqueta().equals(etiqueta))
                return getEtiqueta();
        }
        if(getHijoDer() != null){
            if(getHijoDer().getEtiqueta().equals(etiqueta))
                return getEtiqueta();
        }
        Comparable res = null;
        if(getHijoIzq() != null){
            res = getHijoIzq().EtiquetaAnterior(etiqueta);
            if(res != null)
                return res;
        }
        if(getHijoDer() != null)
            res = getHijoDer().EtiquetaAnterior(etiqueta);
        return res;
    }
    //4 
    public int Nivelnodos(int nivel, int nivelActual){
        int cantidad = 0;
        if(nivel == nivelActual){
            cantidad++;
            return cantidad;
        }
        if(getHijoIzq() != null){
            cantidad += getHijoIzq().Nivelnodos(nivel, nivelActual+ 1);
        }
        if(getHijoDer() != null){
            cantidad += getHijoDer().Nivelnodos(nivel, nivelActual+ 1);
        }
        return cantidad;
    }

    //5
    public Map<IElementoAB,Integer> ListarHojasConNivel(int nivelActual){
        Map<IElementoAB,Integer> res = new HashMap<>();
        if(getHijoIzq() == null && getHijoDer() == null){
            res.put(this, nivelActual);
            return res; 
        }
        if(getHijoDer() != null){
            res.putAll(getHijoDer().ListarHojasConNivel(nivelActual + 1 ));
        }
        if(getHijoIzq() != null){
            res.putAll(getHijoIzq().ListarHojasConNivel(nivelActual + 1 ));
        }
        return res;
    }

    //6
    public boolean VerificarArbolBB(){
        if(getHijoIzq() == null && getHijoDer() == null){
            return true; //Es hoja
        }
        boolean bandera = true;
        if(getHijoIzq() != null){
            if(getHijoIzq().getEtiqueta().compareTo(getEtiqueta()) > 0)
                return false;
        }
        if(getHijoDer() != null){
            if(getHijoDer().getEtiqueta().compareTo(getEtiqueta()) < 0){
                return false;
            }
        }
        if(getHijoIzq() != null){
            bandera = getHijoIzq().VerificarArbolBB();
            if(bandera == false){
                return bandera;
            }
        }
        if(getHijoDer() != null){
            bandera = getHijoDer().VerificarArbolBB();
        }
        return bandera;
    }

    public int obtenerTamano() {
        int tamano = 1;
        if(getHijoIzq() != null){
            tamano += getHijoIzq().obtenerTamano();
        }
        if(getHijoDer() != null){
            tamano += getHijoDer().obtenerTamano();
        }
        return tamano;
    }
    
    public int obtenerAltura() {
        int resIz = 0;
        int resDer = 0;
        if(getHijoIzq() != null){
            resIz += 1;
            resIz += getHijoIzq().obtenerAltura();
        }
        if(getHijoDer() != null){
            resDer += 1;
            resDer += getHijoDer().obtenerAltura();
        }
        return Math.max(resIz, resDer);
    }
    public int ObtenerHojas(){
        int res = 0;
        if(getHijoIzq() == null && getHijoDer() == null){
            res++;
            System.out.println(this.etiqueta);
            return res; 
        }
        if(getHijoDer() != null){
            res += getHijoDer().ObtenerHojas();
        }
        if(getHijoIzq() != null){
            res += getHijoIzq().ObtenerHojas();
        }
        return res;
    }
    public int SumaDeEnteros(){
        int res = 0;
        if(getHijoDer() == null && getHijoIzq() == null){
            res += (int) this.etiqueta;
            return res;
        }
        if(getHijoIzq() != null){
            res += getHijoIzq().SumaDeEnteros();
        }
        if(getHijoDer() != null){
            res += getHijoDer().SumaDeEnteros();
        }
        res += (int) this.etiqueta;
        return res;
    }
    public int NivelNodoEspecifico(Comparable et, int nivelActual){
        int cantidad = 0;
        if(etiqueta == et)
            return nivelActual;
        if(getHijoIzq() != null){
            cantidad = hijoIzq.NivelNodoEspecifico(et, nivelActual + 1);
        }
        if(cantidad != 0)
            return cantidad;
        if(getHijoDer() != null)
            cantidad = getHijoDer().NivelNodoEspecifico(et, nivelActual + 1);
        return cantidad;
    }

}
