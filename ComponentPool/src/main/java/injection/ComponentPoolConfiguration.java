/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injection;

import com.google.inject.AbstractModule;
import dataSourceReader.DatasourceReader;
import dataSourceReader.IDatasourceReader;
import services.ComponentPool;
import services.IComponentProvider;

/**
 *
 * @author marian
 */
public class ComponentPoolConfiguration extends AbstractModule{
    @Override
    protected void configure() {
        bind(IDatasourceReader.class).to(DatasourceReader.class);
        bind(IComponentProvider.class).to(ComponentPool.class);
    }
}
