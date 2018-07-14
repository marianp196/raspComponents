package service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import abstractions.IComponentProvider;
import abstractions.IComponentRegistry;
import abstractions.domian.IComponent;
import factory.ComponentsFactory;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.util.Component;
import service.util.Result;
import service.util.State;

/**
 *
 * @author marian
 */
public class ComponentServiceTest {
    
    public ComponentServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void Get_ShouldReturnCorrectType() throws Exception{
       IComponentRegistry registry = ComponentsFactory.GetRegistry();
       IComponent<State, Result> component = new Component("id");
       registry.Add(component);
       
       IComponentProvider provider = ComponentsFactory.GetProvider();
       Assert.assertEquals(provider.<State,Result>Get("id").GetID(), component.GetID() );
   }
    
}
