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
public interface Tree<E> 
{
    public int size();
    public boolean isEmpty();
    public void addRoot(Position<E> e) throws InvalidPositionException;
    public Position<E> root(); 
    public boolean isRoot(Position<E> p) throws InvalidPositionException;
    public boolean isInternal(Position<E> p) throws InvalidPositionException;
    public boolean isLeaf(Position<E> p) throws InvalidPositionException;
    public void addLeft(Position<E> p,Position<E> q) throws InvalidPositionException;
    public Position<E> left(Position<E> p) throws InvalidPositionException;
    public boolean hasLeft(Position<E> p) throws InvalidPositionException;
    public void addRight(Position<E> p,Position<E> q) throws InvalidPositionException;
    public Position<E> right(Position<E> p) throws InvalidPositionException;
    public boolean hasRight(Position<E> p) throws InvalidPositionException;
    public void remove(Position<E> p) throws InvalidPositionException; 
}
