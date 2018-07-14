package abstractions.domian;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marian
 */
public interface IComponent<TState, TResult> {
    String GetID();
    TResult Excute(TState state) throws Exception; 
}
