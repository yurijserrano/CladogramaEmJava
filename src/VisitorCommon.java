/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luba
 */
public class VisitorCommon<E>
   implements Visitor<E> {
    private String Taxon1, Taxon2;
    private boolean taxon1Ok, taxon2Ok;
    private Node<String> noComum;
   
    
    public VisitorCommon(String Taxon1, String Taxon2){
         this.Taxon1 = Taxon1;
         this.Taxon2 = Taxon2;
         taxon1Ok = false;
         taxon2Ok = false;
         noComum  = null;
    }    
    // Verifica as caracteristicas em comum usando PosOrdem
    public void visit(Node<E> n){
       if (n.getLeft()!=null)  // Se existe filho na esquerda
           n.getLeft().accept(this);     //     visita recursivamente o filho da esquerda
       if (n.getRight()!=null) // Se existe filho na direita
           n.getRight().accept(this);     //     visita recursivamente o filho da direita
       
        if(n.getElement().equals(Taxon1)){
            taxon1Ok = true;
            return;
        }
        if(n.getElement().equals(Taxon2)){
            taxon2Ok = true;
            return;
        }
        if( taxon1Ok && taxon2Ok ){
            noComum = (Node) n.getParent();
            taxon1Ok = taxon2Ok = false; // seta false para nao entrar mais aqui
        }


   }
   public Node<String> getCommon(){

         return noComum;
   }
}


