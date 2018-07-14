/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.util.Collection;

/**
 * So gebaut wegen Guice.
 * In der Implementierung dieses Interfaces köannen die einzelnen Dat-
 * Sources zurückgegeben werden. 
 * DataSources mit niedrigeren Indizes in der Collection haben bei Namenskonflikten
 * vorrang.
 * @author marian
 */
public interface IDataSourceProvider {
    Collection<IDataSource> Get();
}
