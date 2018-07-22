/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationBuilder;

import com.google.inject.AbstractModule;
import dataSource.IDataSourceProvider;

/**
 *
 * @author marian
 */
public class WebConfiguration extends AbstractModule {
      @Override
    protected void configure() {
        bind(IDataSourceProvider.class).to(DataSourceProvider.class);        
    }
}
