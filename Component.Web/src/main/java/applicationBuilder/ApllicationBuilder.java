/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationBuilder;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import injection.ComponentPoolConfiguration;
import java.util.ArrayList;
import services.IComponentProvider;

/**
 *
 * @author marian
 */
public class ApllicationBuilder {
    public IComponentProvider Build(){
        if(_injector == null)        
            _injector = getInjector();
        System.out.println("fkdjfid");
        return _injector.getInstance(IComponentProvider.class);
    }

    private Injector getInjector() {
        ArrayList<Module> configuartions = new ArrayList<Module>();
        configuartions.add(new WebConfiguration());
        configuartions.add(new ComponentPoolConfiguration());
        Injector injector = Guice.createInjector(configuartions);
        return injector;
    }
    
    private Injector _injector;
}