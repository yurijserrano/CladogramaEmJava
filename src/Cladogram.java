/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serrano
 */
public class Cladogram 
{
    
    private BinaryTree <String> T;   // árvore que representa o cladograma

    public Cladogram(String characters[], String taxa[], int c[][]) throws Exception
    {
        // Constrói a árvore T
        // Dica: utilize um Vector para ir montando a árvore de baixo para cima
        T = new BinaryTree<String>();
        Node<String> raiz=null;
        Node<String> esq;
        Node<String> dir;
        
        // pega o ultimo taxon, e o define como raiz
        esq  = new Node<String>(taxa[taxa.length - 1]);
        for( int i=0; i < characters.length; i++)
        {
            raiz = new Node<String>(characters[i]);
            dir  = new Node<String>(taxa[taxa.length - (i+2)]); 
            
            raiz.setLeft(esq);
            raiz.setRight(dir);
            esq = raiz;
                    
        }
        T.addRoot(raiz);
    }

    int distance(String taxon1, String taxon2)
    {
        
        VisitorDistance<String> vd=new VisitorDistance<String>(taxon1,taxon2);
        T.root().accept(vd);
        return vd.getDistance();
    }

    String common(String taxon1, String taxon2)
    {
        VisitorCommon <String> vd=new VisitorCommon<String>(taxon1,taxon2);
        T.root().accept(vd);
        return ""+vd.getCommon();
    }

    
}
