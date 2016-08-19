/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luba
 * @param <E>
 */
public class VisitorDistance<E> implements Visitor<E> 
{
    private String Taxon1, Taxon2;
    private int height, heightTaxon1, heightTaxon2;
    
    public VisitorDistance(String Taxon1, String Taxon2)
    {
         height = 0;
         this.Taxon1 = Taxon1;
         this.Taxon2 = Taxon2;
    }    
    // Calcula a distancia utilizando o as alturas dos nos

    /**
     *
     * @param n
     */
        @Override
    public void visit(Node<E> n)
    {
        if (n != null) 
        {
           int he=height, hd=height;  // altura dos nós esquerdo e direito
           if (n.getLeft() != null) // Se existe filho na esquerda
           {
               height++;
               n.getLeft().accept(this);  //     visita recursivamente o filho da esquerda
           }
           if (height>he)
               he=height;
           height=hd;
           if (n.getRight() != null) // Se existe filho na direita
           {
               height++;
               n.getRight().accept(this);
           }
           if (height>hd)
               hd=height;
           height=Math.max(he, hd);
           
           // guarda a altura do Taxon1
           if(n.getElement().equals(Taxon1))
           {
               heightTaxon1 = height;
           }
           // guarda a altura do Taxon1
           if(n.getElement().equals(Taxon2))
           {
               heightTaxon2 = height;
           }
       }


   }
   public int getDistance()
   {
        // distancia comeca com 2 pois se tiverem a mesma altura a distancia jah eh 2
        int distancia=2;
         
        distancia += Math.abs(heightTaxon1 - heightTaxon2); // pega o valor absoluto
        
        return distancia;
   }
}


