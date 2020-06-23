package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorCanRideRollercoaster(){
        Visitor visitor = new Visitor(16, 1.6, 12.00);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorCantRideRollercoaster(){
        Visitor visitor = new Visitor(11, 1.2, 3.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorIsRightAgeButTooShort(){
        Visitor visitor = new Visitor(14, 1.2, 3.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorIsTooYoungButRightHeight(){
        Visitor visitor = new Visitor(11, 1.5, 3.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canGetDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void canChargeVisitorsOver2MTallDouble(){
        Visitor visitor = new Visitor(23, 2.1, 20.00);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void canChargeVisitorsUnder2MTallDefaultPrice(){
        Visitor visitor = new Visitor(18, 1.68, 14.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }


}
