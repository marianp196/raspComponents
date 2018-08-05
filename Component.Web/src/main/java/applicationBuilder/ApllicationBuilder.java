/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationBuilder;

import factory.ComponentProviderFactory;
import factory.IComponentProviderFactory;
import services.IComponentProvider;

/**
 *
 * @author marian
 */
public class ApllicationBuilder {
    public IComponentProvider Build() throws Exception{
        if(_componentProvider == null) {
            IComponentProviderFactory factory = new ComponentProviderFactory();
            _componentProvider = factory.Build(new DataSourceProvider());
        }       
            
       
        return _componentProvider;
    }
    
    private IComponentProvider _componentProvider;
}