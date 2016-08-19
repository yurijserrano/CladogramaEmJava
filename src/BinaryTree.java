/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serrano
 */
public class BinaryTree<E> implements Tree<E>
{
    
    private Node<E> root; // raiz da árvore
    private int size;     // quantidade de elementos da árvore
    
    BinaryTree()
    {
        // Cria uma árvore binária vazia  
        root=null;
        size=0;
    }
    
    @Override
    public int size()
    {
        // Devolve o número de elementos da árvore    
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty()
    {
        // Verifica se a árvore está vazia    
       return size==0; 
    }

    /**
     *
     * @param p
     * @throws InvalidPositionException
     */
    @Override
    public void addRoot(Position<E> p) throws InvalidPositionException
    {
    // Adiciona uma raiz para a árvore, caso ela ainda não tenha    
        if (p==null || root!=null)
            throw new InvalidPositionException(); 
        root=(Node<E>)p;
        size=root.size();
    }
    @Override
    public Position<E> root() 
    {
    // Devolve a raiz da árvore.   
        return root;
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public boolean isRoot(Position<E> p) throws InvalidPositionException
    {
        // Verifica se uma posição p válida é a raiz da árvore    
        if (p==null)
            throw new InvalidPositionException();
        return p.getParent()==null;
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public boolean isInternal(Position<E> p) throws InvalidPositionException 
    {
    // Verifica se uma posição p válida é um nó interno  
        if (p==null)
            throw new InvalidPositionException();
        return p.getLeft()!=null || p.getRight()!=null;
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public boolean isLeaf(Position<E> p) throws InvalidPositionException
    {
    // Verifica se uma posição p válida é uma folha
        if (p==null)
            throw new InvalidPositionException();
        return p.getLeft()==null && p.getRight()==null;
    }

    /**
     *
     * @param p
     * @param q
     * @throws InvalidPositionException
     */
    @Override
    public void addLeft(Position<E> p,Position<E> q) throws InvalidPositionException
    {
        // Adiciona uma posição q válida como filho da esquerda da posição p válida
        if (p==null || q==null)
            throw new InvalidPositionException();
        p.setLeft(q);
        size=root.size();
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public Position<E> left(Position<E> p) throws InvalidPositionException
    {
        // Devolve o filho da esquerda de uma posição p válida    
        if (p==null)
            throw new InvalidPositionException();
        return p.getLeft();
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public boolean hasLeft(Position<E> p) throws InvalidPositionException{
    // Verifica se uma posição p válida tem filho na esquerda    
        if (p==null)
            throw new InvalidPositionException();
        return p.getLeft()!=null;
    }

    /**
     *
     * @param p
     * @param q
     * @throws InvalidPositionException
     */
    @Override
    public void addRight(Position<E> p,Position<E> q) throws InvalidPositionException
    {
        // Adiciona uma posição q válida como filho da direita da posição p válida
        if (p==null || q==null)
            throw new InvalidPositionException();
        p.setRight(q);
        size=root.size();
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public Position<E> right(Position<E> p) throws InvalidPositionException
    {
        // Devolve o filho da direita de uma posição p válida 
        if (p==null)
            throw new InvalidPositionException();
        return p.getRight();
    }

    /**
     *
     * @param p
     * @return
     * @throws InvalidPositionException
     */
    @Override
    public boolean hasRight(Position<E> p) throws InvalidPositionException
    {
        // Verifica se uma posição p válida tem filho na direita 
        if (p==null)
            throw new InvalidPositionException();
        return p.getRight()!=null;
    }

    /**
     *
     * @param p
     * @throws InvalidPositionException
     */
    @Override
    public void remove(Position<E> p) throws InvalidPositionException
    {
        // Remove uma posição p e todos os seus descendentes da árvore    
        if (p==null)
            throw new InvalidPositionException();
        else if (p==root)
        {
                root=null;
                size=0;
        }
        else {
                   size-=((Node<E>) p).size();
                   if (p.getParent().getLeft()==p)
                       p.getParent().getLeft().setLeft(null);
                   else if (p.getParent().getRight()==p)
                             p.getParent().getRight().setRight(null);
             }
    }
    
}
