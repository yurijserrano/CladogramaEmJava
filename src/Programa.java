/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serrano
 */
class Programa 
{

    public static void main(String args[]) throws Exception
    {

        int characterTable [][]= { {0,0,0,0,0,1},
                                   {0,0,0,0,1,1},
                                   {0,0,0,1,1,1},
                                   {0,0,1,1,1,1},
                                   {0,1,1,1,1,1}};
        
        String character[] = {"Hair", "Amniotic egg", "Four walking legs", "Jaws", "Vertebral colunn"};
        String taxa[] = {"Lancelet", "Lamprey", "Tuna", "Salamander", "Turtle", "Leopard"};
        
        Cladogram  cladogram = new Cladogram(character, taxa, characterTable);
        
        System.out.println("Distancia Tuna - Leopard:"+cladogram.distance("Tuna" , "Leopard"));
        
        System.out.println("Caracteristica em comum Tuna - Leopard:"+cladogram.common("Tuna" , "Leopard"));
        
        
    }
}

