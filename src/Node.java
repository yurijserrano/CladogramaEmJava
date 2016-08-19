/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Serrano
 * @param <E>
 */
public class Node<E> implements Position<E>
{
    
    private E element;  // elemento armazenado no nodo
    private Node<E> left, right, parent; // apontadores do nó
    
    Node(E element)
    {
       this.element=element;
       left=right=parent=null;
    }
    
    @Override
    public E getElement()
    {
        // Devolve o elemento armazenado no nodo    
       return element; 
    }
    @Override
    public void setElement(E e)
    {
        // Altera o elemento armazenado no nó 
        element=e;
    }
    @Override
    public Position<E> getParent()
    {
        // Devolve o pai do nodo    
        return parent;
    }
    @Override
    public void setParent(Position<E> p)
    {
    // Altera o pai do nodo para a posição p 
        parent = (Node<E>) p;
    }
    @Override
    public Position<E> getLeft()
    {
        // Devolve o nodo armazenado à esquerda do nodo    
        return left;
    }

    /**
     *
     * @param p
     */
    @Override
    public void setLeft(Position<E> p)
    {
        // Altera o nodo armazenado à esquerda para p
       left = (Node<E>) p;
       if (p!=null)
           p.setParent(this);  
    }

    /**
     *
     * @return
     */
    @Override
    public Position<E> getRight()
    {
        // Devolve o nodo armazenado à esquerda do nodo 
        return right;
    }
   
    /**
     *
     * @param p
     */
    @Override
    public void setRight(Position<E> p)
    {
    // Altera o nodo armazenado à esquerda para p 
        right = (Node<E>) p;
        if (p!=null)
           p.setParent(this);
    }
    
    public int size()
    {
        // Retorna quantos elementos existem na sub-arvore enraizada pelo nó
       int q=1;
       if (getLeft()!=null)
           q+=((Node<E>)getLeft()).size();
       if (getRight()!=null)
           q+=((Node<E>)getRight()).size();
       return q;
    }
    
    /**
     *
     * @param v
     */
    @Override
    @SuppressWarnings("unchecked")
    public void accept(Visitor v)
    {
        v.visit(this);
    }
    @Override
    public String toString()
    {
            return ""+element;
    }

    
}
