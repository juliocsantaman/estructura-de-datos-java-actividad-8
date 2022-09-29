/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedabinaria;

import java.util.Scanner;

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class BusquedaBinaria {
    
    int [] arr;
    int elemento;
    
    public BusquedaBinaria(int [] arr, int elemento) {
        this.arr = arr;
        this.elemento = elemento;
    }
    
    public int busqBinaria(int min, int max) {
        
        int medio = (min + max) / 2;
        
        //Caso base o de salida.
        if(min > max) {
            return -1;
        } else if(arr[medio] == elemento) {  
            return medio;
        } else if(arr[medio] > elemento) { 
            return busqBinaria(min, medio-1); //Caso recursivo.
        } else {
            return busqBinaria(medio+1, max); //Caso recursivo.
        }
             
    }
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        int [] arr = {1,2,3,4,5};
        int elemento=0;
        boolean verificar=false;
        
        System.out.println("***** BÚSQUEDA BINARIA *****");
        
        do {         
            
            try {
                
                System.out.print("Digite el elemento a buscar en el arreglo: ");
                elemento=entrada.nextInt();
                
                verificar=true;
                
            } catch (Exception e) {
                System.out.println("Error: no ha digitado un valor válido.");
                entrada.nextLine();
            }
            
        } while (!verificar);
        
        BusquedaBinaria obj = new BusquedaBinaria(arr, elemento);
        
        if(obj.busqBinaria(0, arr.length-1) == -1) {
            System.out.println("El elemento a buscar no existe en el arreglo.");
        } else {
            System.out.println("La posición del elemento es: " + obj.busqBinaria(0, arr.length-1) + ".");
        }
 
    }
    
}
