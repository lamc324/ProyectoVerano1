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
import una.cr.design.patterns.view.AgregarPacienteView;

/**
 *
 * @author Usuario
 */
public class AgregarPacienteViewJUnitTest {

    public AgregarPacienteViewJUnitTest() {
    }

    private FrameFixture window;
    private JPanelFixture ctrlPanel1;
    private JPanelFixture ctrlPanel2;

    @Before
    public void setUp() {
        AgregarPacienteView view = GuiActionRunner.execute(() -> new AgregarPacienteView());
        window = new FrameFixture(view);
        window.show();
        ctrlPanel1 = window.panel("ctrlPanel1");
        ctrlPanel1 = window.panel("ctrlPanel2");
    }

    @Test
    public void testVisibleComponents() {
        ctrlPanel1.textBox("id").requireVisible();
        ctrlPanel1.textBox("nombre").requireVisible();
        ctrlPanel1.textBox("telefono").requireVisible();
        ctrlPanel1.textBox("direccion").requireVisible();
        ctrlPanel1.textBox("fechaNac").requireVisible();
        ctrlPanel1.textBox("enfermedades").requireVisible();
        ctrlPanel1.textBox("observaciones").requireVisible();
        ctrlPanel2.button("cancelar").requireVisible();
        ctrlPanel2.button("siguiente").requireVisible();

    }

//    @Test
//    public void testTextField() {
//        String contents[][] = null;
//        ctrlPanel1.comboBox("box").requireVisible();
//        ctrlPanel1.button("buscar").requireVisible();
//        ctrlPanel1.button("agregar").requireVisible();
//        ctrlPanel2.button("cerrar").requireVisible();
//        scrollPanel.requireVisible();
//
//        ctrlPanel1.comboBox("box").selectItem("Hospital CIMA");
//        ctrlPanel1.button("buscar").click();
//
//    }
//
//    @Test
//    public void testTextField2() {
//        ctrlPanel1.comboBox("box").requireVisible();
//        ctrlPanel1.button("buscar").requireVisible();
//        ctrlPanel1.button("agregar").requireVisible();
//        ctrlPanel2.button("cerrar").requireVisible();
//        scrollPanel.requireVisible();
//
//        ctrlPanel1.comboBox("box").selectItem("Centro Medico del Este");
//        ctrlPanel1.button("buscar").click();
//
//    }

//    @Test
//    public void testButton() {
//        ctrlPanel1.comboBox("box").requireVisible();
//        ctrlPanel1.button("buscar").requireVisible();
//        ctrlPanel1.button("agregar").requireVisible();
//        ctrlPanel2.button("cerrar").requireVisible();
//        scrollPanel.requireVisible();
//        mainTable.requireVisible();
//
//        ctrlPanel1.button("agregar").click();
//    }
//
//    @Test
//    public void testButton2() {
//        ctrlPanel1.comboBox("box").requireVisible();
//        ctrlPanel1.button("buscar").requireVisible();
//        ctrlPanel1.button("agregar").requireVisible();
//        ctrlPanel2.button("cerrar").requireVisible();
//        scrollPanel.requireVisible();
//        mainTable.requireVisible();
//
//        ctrlPanel2.button("cerrar").click();
//    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
