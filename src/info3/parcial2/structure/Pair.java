public class Pair<K extends Comparable<K>, T> implements Comparable<Pair<K,T>> {

    K clave;
    T valor;

    
    public Pair() {
    }


    public K getClave() {
        return clave;
    }


    public void setClave(K clave) {
        this.clave = clave;
    }


    public T getValor() {
        return valor;
    }


    public void setValor(T valor) {
        this.valor = valor;
    }


    @Override
    public int compareTo(Pair<K, T> o) {
        return clave.compareTo(o.getClave());
    }


    @Override
    public String toString() {
        return "Pair [clave=" + clave + ", valor=" + valor + "]";
    }

    

    
}
