public class Cola {
    private Nodo frente;
    private Nodo atras;
    private int longitud;

public Cola() {
    frente = null;
    atras = null;
    longitud = 0;
    }

    
public void insertar(String dato) {
    Nodo nuevoNodo = new Nodo(dato);
    if (estaVacia()) {
        frente = nuevoNodo;
        atras = nuevoNodo;
        atras.setSiguiente(frente);
    } else {
        atras.setSiguiente(nuevoNodo);
        atras = nuevoNodo;
        atras.setSiguiente(frente);
        }
        longitud++;
}

public String quitar() {
    if (frente == null) {
        return null; // La cola está vacía
    }
    String archivo = frente.getDato();
    frente = frente.getSiguiente();
        if (frente == null) {
            atras = null;
        }
    longitud--;
    return archivo;
}

public boolean estaVacia() {
    return frente == null;
}

public Nodo getFrente() {
    if (!estaVacia()) {
        return frente;
    } else {
        System.out.println("La cola está vacía.");
        return null;
    }
}

public Nodo getAtras() {
    if (!estaVacia()) {
        return atras;
    } else {
        System.out.println("La cola está vacía.");
        return null;
    }
}

public int getLongitud() {
    return longitud;
}

public void vaciar() {
    frente = null;
    atras = null;
    longitud = 0;
}

}
