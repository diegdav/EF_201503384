/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

/**
 *
 * @author DiegDav
 */
public class Lista {

    //indica el primer nodo de la lista
    Nodo primero;
    //indica el ultimo nodo de la lista
    Nodo ultimo;
    //indica el nuevo nodo de la lista
    Nodo nuevo;
    int tamanio;

    public Lista() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    public void insertar(int id, String dato) {
        boolean encontrado;

        if (primero == null) {
            nuevo = new Nodo(id, dato);
            tamanio++;
        } else {
            encontrado = buscar(id);
            if (encontrado) {
                System.out.println("El id ya existe, favor de ingresar un id diferente");
            } else {
                nuevo = new Nodo(id, dato);
                tamanio++;
            }
        }

        if (primero == null) {
            //el primer nodo toma el valor del nuevo
            //el ultimo nodo toma el valor del nuevo
            
            primero = nuevo;
            ultimo = primero;
            
            //el primer nodo apunta a el ultimo
            primero.setSiguiente(ultimo);
        } else {
            
            //el ultimo nodo apunta al nuevo
            ultimo.setSiguiente(nuevo);
            
            //el nuevo nodo apunta al primero
            nuevo.setSiguiente(primero);
            
            //el nuevo nodo se vuelve el ultimo nodo
            ultimo = nuevo;
        }
    }

    public void mostrar() {
        Nodo actual;
        actual = primero;

        //23 --> 12 --> 45 --> primero
        //actual = 23
        //actual = siguiente de actual
        if (primero == null) {
            System.out.println("La lista se encuentra vacia");
        } else {
            do {
                System.out.println("id: " + actual.getId() + ", dato: " + actual.getDato());
                
                //el nodo actual se vuelve el siguiente
                actual = actual.getSiguiente();
            } while (actual != primero);
        }
    }

    public boolean buscar(int id) {
        Nodo actual;
        actual = primero;
        boolean encontrado = false;

        do {
            if (actual.getId() == id) {
                encontrado = true;
            }
            actual = actual.getSiguiente();
        } while (actual != primero);

        return encontrado;
    }

    //23 --> 12 --> 45 --> primero
    //actual = 23
    //actual = 12
    public void modificar(int id, String dato) {
        Nodo actual;
        actual = primero;
        boolean encontrado;
        encontrado = buscar(id);

        if (encontrado) {
            do {
                if (actual.getId() == id) {
                    actual.setDato(dato);
                }
                actual = actual.getSiguiente();
            } while (actual != primero);
        } else {
            System.out.println("El id no existe.");
        }
    }

    public void eliminar(int id) {
        Nodo actual;
        Nodo anterior;
        actual = primero;
        anterior = ultimo;
        boolean encontrado;
        encontrado = buscar(id);

        if (encontrado) {
            do {
                if (actual.getId() == id) {
                    if (actual == primero) {
                        //el primer nodo se vuelve el siguiente
                        primero = primero.getSiguiente();
                        
                        //el ultimo nodo apunta al primero
                        ultimo.setSiguiente(primero);
                        tamanio--;
                    } else if (actual == ultimo) {
                        //el nodo anterior al ultimo apunta al primero
                        anterior.setSiguiente(primero);
                        //el nodo anterior al ultimo se vuelve el ultimo nodo
                        ultimo = anterior;
                        tamanio--;
                    } else {
                        //el nodo anterior del actual apunta al nodo siguiente del actual
                        anterior.setSiguiente(actual.getSiguiente());
                        tamanio--;
                    }
                }
                //23 --> 12 --> 45 --> primero
                //actual = 23
                //anterior = 45
                anterior = actual;
                //23
                actual = actual.getSiguiente();
                //12
            } while (actual != primero);
        }
    }

    //Devuelve el tamaño de la lista
    public int getTamanio() {
        return tamanio;
    }
    
    //Devuelve el ultimo nodo ingresado
    public String getUltimo() {
        return "id: " + ultimo.getId() + ", dato: " + ultimo.getDato();
    }
}
