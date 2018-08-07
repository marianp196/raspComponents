/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author marian
 */
public interface IWriteableComponent<TState, TResult> extends IReadableComponent<TResult> {
    TResult Write(TState state) throws Exception;
}
