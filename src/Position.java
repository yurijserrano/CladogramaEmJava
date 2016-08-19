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
public interface Position<E> 
{
    public E getElement();
    public void setElement(E e);
    public Position<E> getParent();
    public void setParent(Position<E> p);
    public Position<E> getLeft();
    public void setLeft(Position<E> p);
    public Position<E> getRight();
    public void setRight(Position<E> p);
    public void accept(Visitor v);
}
