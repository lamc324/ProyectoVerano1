
package una.cr.design.patterns.view;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JScrollPaneFixture;
import org.assertj.swing.fixture.JSplitPaneFixture;
import org.assertj.swing.fixture.JTableFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luism
 */


public class MenuViewJUnitTest {
    
    private FrameFixture window;
    public MenuViewJUnitTest() {
    }
    
    @Before
    public void setUp() {    
        MenuView view = GuiActionRunner.execute(() -> new MenuView());
        window = new FrameFixture(view);
        window.show();

    }
    
    @Test
    public void testVisibleComponents() {
        window.menuItem("itemSalir").requireVisible(); 
        window.menuItem("itemPacientes").requireVisible(); 
        window.menuItem("itemHelp").requireVisible(); 
        window.menuItem("itemCitas").requireVisible(); 
        window.menuItem("itemConsultorios").requireVisible(); 
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
