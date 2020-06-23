package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void visitorIsAllowedInThePlayground(){
        Visitor visitor = new Visitor(12, 1.1, 2.50);
        assertEquals(true, playground.isAllowedTo(visitor));
    }

    @Test
    public void visitorIsNotAllowedInThePlayground(){
        Visitor visitor = new Visitor(16, 1.6, 6.0);
        assertEquals(false, playground.isAllowedTo(visitor));
    }

    @Test
    public void visitorWhoIs15IsAllowedInThePlayground(){
        Visitor visitor = new Visitor(15, 1.5, 1.30);
        assertEquals(true, playground.isAllowedTo(visitor));
    }
}
