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
public class PacientesViewJUnitTest {

    private FrameFixture window;
    private JPanelFixture ctrlPanel1;
    private JPanelFixture ctrlPanel2;
    private JPanelFixture ctrlPanel3;
    private JScrollPaneFixture scrollPanel;
    private JTableFixture mainTable;

    /**
     *
     */
    public PacientesViewJUnitTest() {

    }

    /**
     *
     */
    @Before
    public void setUp() {
        PacientesView view = GuiActionRunner.execute(() -> new PacientesView());
        window = new FrameFixture(view);
        window.show();
        ctrlPanel1 = window.panel("ctrlPanel1");
        ctrlPanel2 = window.panel("ctrlPanel2");
        ctrlPanel3 = window.panel("ctrlPanel3");
        scrollPanel = window.scrollPane("scrollTablePane");
        mainTable = window.table("mainTable");
    }

    /**
     *
     */
    @Test
    public void testVisibleComponents() {
        String contents[][] = null;
        ctrlPanel1.textBox("texto").requireVisible();
        ctrlPanel1.button("buscar").requireVisible();
        ctrlPanel1.button("agregar").requireVisible();
        ctrlPanel1.button("eliminar").requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
        ctrlPanel1.textBox("texto").enterText("enrique");
        ctrlPanel1.button("buscar").click();

        contents = mainTable.contents();
        assertEquals(contents[0][1], "Enrique Vergara Melendez");
    }
    
    /**
     *
     */
    @Test
    public void testTextField() {
        String contents[][] = null;
        ctrlPanel1.textBox("texto").requireVisible();
        ctrlPanel1.button("buscar").requireVisible();
        ctrlPanel1.button("agregar").requireVisible();
        ctrlPanel1.button("eliminar").requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
        ctrlPanel1.textBox("texto").enterText("STEVE");
        ctrlPanel1.button("buscar").click();

        contents = mainTable.contents();
        assertEquals(contents[0][1], "Steve Johnson");
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }

}
