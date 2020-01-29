/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonia;

import java.util.Scanner;

/**
 *
 *Edwan santos  autor
 */
public class Telefonia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner entrada = new Scanner(System.in);
        String numeroTel = "99001122";
        double saldoLempiras = 70;
        double datosNavegacion = 0;
        double mensjTexto = 0;
        double totalRecargas = 0;
        double monto = 0;
        double transfSaldo  = 0;
        double pedirSaldo = 0;
        int resp = 0;
    
        
        while(resp != 9){
            System.out.println("---- Bienvenido a su cuenta telefonica ---- ");
            System.out.println(" 1. Consulta de saldo  "); 
            System.out.println(" 2. Transferir saldo ");
            System.out.println(" 3. Pedir saldo ");
            System.out.println(" 9. Salir ");
            System.out.println(" Que desea realizar... ? ");
            resp = entrada.nextInt(); 
            
            switch(resp){
                case 1:
                    System.out.println("");
                    System.out.println("----------------------------------------");
                    System.out.println("El estado de la cuenta "+numeroTel);
                    System.out.println("Total recargas ... "+totalRecargas);
                    System.out.println("Total transferencias  "+transfSaldo);
                    System.out.println("Total datos de navegacion  "+datosNavegacion);
                    System.out.println("Total mensajes de texto "+mensjTexto);
                    System.out.println(" Saldo disponible "+saldoLempiras );
                    System.out.println("Credito pendiente "+pedirSaldo );
                    System.out.println("----------------------------------------");
                    break;
                case 2: 
                    System.out.println("");
                    System.out.println("Transferencia de saldo #"+numeroTel);
                    System.out.println("Saldo disponible...   "+saldoLempiras);
                    System.out.println("Ingrese el monto a transferir... ");
                    monto = entrada.nextDouble();
                    
                    if((saldoLempiras-monto)> 7) {
                        transfSaldo += monto;
                        saldoLempiras = totalRecargas - transfSaldo;
                    }else{
                        System.err.println("No se puede transferir, monto mayor al disponible");
                        resp = 0;
                    }
                    break;
                case 3: 
                    System.out.println("----------------------------------------");
                    System.out.println("Pedir saldo #"+numeroTel);
                    System.out.println("Ingrese el monto a solicitar... ");
                    monto = entrada.nextDouble();
                    
                    if(monto<(saldoLempiras*1)){
                        totalRecargas += monto;
                        pedirSaldo +=monto;
                        saldoLempiras = totalRecargas - transfSaldo;
                    }else{
                       System.err.println("Monto no valido, excede de lo permitido.");
                       resp = 0; 
                    }
                    break; 
                    default: 
                        resp = 0;
            }
            System.out.println("");
            System.out.println(" ===================================================  "); 
            System.out.println(" Presione 9 para salir, 0 para volver al menu ");
            resp = entrada.nextInt();
            
        }
    }
    
  }
        