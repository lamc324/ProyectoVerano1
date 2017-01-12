package una.cr.design.patterns.view;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JScrollPaneFixture;
import org.assertj.swing.fixture.JTableFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import una.cr.design.patterns.view.AgregarCitaView;

/**
 *
 * @author Grupo Tango
 */
public class AgregarCitaViewJUnitTest {

    public AgregarCitaViewJUnitTest() {
    }

    private FrameFixture window;
    private JPanelFixture ctrlPanel1;
    private JPanelFixture ctrlPanel2;
    private JPanelFixture ctrlPanel3;
    private JPanelFixture ctrlPanel4;
    private JPanelFixture ctrlPanel5;
    private JScrollPaneFixture scrollPanel;

    @Before
    public void setUp() {
        AgregarCitaView view = GuiActionRunner.execute(() -> new AgregarCitaView());
        window = new FrameFixture(view);
        
        window.show();
        ctrlPanel1 = window.panel("ctrlPanel1");
        ctrlPanel2 = window.panel("ctrlPanel2");
        ctrlPanel3 = window.panel("ctrlPanel3");
        ctrlPanel4 = window.panel("ctrlPanel4");
        ctrlPanel5 = window.panel("ctrlPanel5");

        scrollPanel = window.scrollPane("scrollTablePane");

    }

    @Test
    public void testVisibleComponents() {
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("atras").requireVisible();
        ctrlPanel1.button("terminar").requireVisible();        
        scrollPanel.requireVisible();

    }

    @Test
    public void testEditPane() {
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("atras").requireVisible();
        ctrlPanel2.button("terminar").requireVisible();
        scrollPanel.requireVisible();

        ctrlPanel1.comboBox("box").selectItem("Hospital CIMA");
        ctrlPanel1.textBox("descripcion").enterText("Hora de Cita: 12md");
        ctrlPanel1.button("atras").click();

    }

    @Test
    public void testEditPane2() {
        ctrlPanel1.comboBox("box").requireVisible();
        ctrlPanel1.button("atras").requireVisible();
        ctrlPanel2.button("terminar").requireVisible();
        scrollPanel.requireVisible();

        ctrlPanel1.comboBox("box").selectItem("Centro Medico del Este");
        ctrlPanel1.textBox("descripcion").enterText("Hora de Cita: 3pm");
        ctrlPanel1.button("terminar").click();
        
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
