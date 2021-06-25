package BLL;
import static org.mockito.Mockito.*;

import DAL.EntityContext;
import Model.Dish;
import Model.Ingredient;
import Model.Order;
import org.mockito.Mock;

class EntityServiceTest {

    @org.junit.jupiter.api.Test
    void store() {
        EntityContext ec = mock(EntityContext.class);
        Ingredient ing = new Ingredient();
        doNothing().when(ec).saveToDb(ing);
        EntityService es = new EntityService(ec);
        es.store(ing);
        verify(ec, only()).saveToDb(ing);
    }

    @org.junit.jupiter.api.Test
    void testStore() {
        EntityContext ec = mock(EntityContext.class);
        Dish d = new Dish();
        doNothing().when(ec).saveToDb(d);
        EntityService es = new EntityService(ec);
        es.store(d);
        verify(ec, only()).saveToDb(d);
    }

    @org.junit.jupiter.api.Test
    void testStore1() {
        EntityContext ec = mock(EntityContext.class);
        Order o = new Order();
        doNothing().when(ec).saveToDb(o);
        EntityService es = new EntityService(ec);
        es.store(o);
        verify(ec, only()).saveToDb(o);
    }
}