package una.cr.design.patterns.view;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JScrollPaneFixture;
import org.assertj.swing.fixture.JTableFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luism
 */
public class CitasViewJUnitTest {

    public CitasViewJUnitTest() {
    }

    private FrameFixture window;
    private JPanelFixture ctrlPanel1;
    private JPanelFixture ctrlPanel2;
    private JPanelFixture ctrlPanel3;
    private JScrollPaneFixture scrollPanel;
    private JTableFixture mainTable;

    @Before
    public void setUp() {
        CitasView view = GuiActionRunner.execute(() -> new CitasView());
        window = new FrameFixture(view);
        window.show();
        ctrlPanel1 = window.panel("ctrlPanel1");
        ctrlPanel2 = window.panel("ctrlPanel2");
        ctrlPanel3 = window.panel("ctrlPanel3");
        scrollPanel = window.scrollPane("scrollTablePane");
        mainTable = window.table("mainTable");
    }

    @Test
    public void testVisibleComponents() {
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("buscar").requireVisible();
        ctrlPanel1.button("agregar").requireVisible();
        ctrlPanel2.button("cerrar").requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
    }

    @Test
    public void testTextField() {
        String contents[][] = null;
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("buscar").requireVisible();
        ctrlPanel1.button("agregar").requireVisible();
        ctrlPanel2.button("cerrar").requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
        
        ctrlPanel1.comboBox("box").selectItem("Hospital CIMA");
        ctrlPanel1.button("buscar").click();
        
        contents = mainTable.contents();
        assertEquals(contents[0][1], "Hospital CIMA");
       
    }
    
    @Test
    public void testTextField2() {
        String contents[][] = null;
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("buscar").requireVisible();
        ctrlPanel1.button("agregar").requireVisible();
        ctrlPanel2.button("cerrar").requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
        
        ctrlPanel1.comboBox("box").selectItem("Centro Medico del Este");
        ctrlPanel1.button("buscar").click();
        
        contents = mainTable.contents();
        assertEquals(contents[0][1], "Centro Medico del Este");
        assertEquals(contents[1][1], "Centro Medico del Este");
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
