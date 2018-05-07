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
public class ListaCircular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        lista.insertar(1, "Primero");
        lista.insertar(2, "Segundo");
        lista.insertar(3, "Tercero");
        lista.insertar(4, "Cuarto");
        lista.insertar(5, "Quinto");
        
        lista.mostrar();
        
        lista.insertar(2, "Sexto");
        
        lista.mostrar();
        System.out.println(lista.getTamanio());
        

        System.out.println(lista.buscar(3));
        System.out.println(lista.buscar(6));
        
        lista.modificar(1, "Primero modificado");
        lista.mostrar();
        
        System.out.println("");
        
        lista.eliminar(1);
        lista.mostrar();
        
        System.out.println("");
        
        lista.eliminar(5);
        lista.mostrar();
        
        System.out.println("");
        
        lista.eliminar(3);
        lista.mostrar();
        System.out.println(lista.getTamanio());
        
        lista.insertar(10, "Nuevo");
        lista.mostrar();
        System.out.println(lista.getTamanio());
        
        
        System.out.println(lista.getUltimo());
    }
    
}
