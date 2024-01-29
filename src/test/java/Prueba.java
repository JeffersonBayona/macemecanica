/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.macemecanica.models.UsuariosFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeffer
 */
public class Prueba {

    UsuariosFacade usuariosFacade;

    public Prueba() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws NamingException {
        EJBContainer ejbContainer = EJBContainer.createEJBContainer();
        Context ctx = ejbContainer.getContext();
        usuariosFacade = (UsuariosFacade) ctx.lookup("java:global/classes/UsuariosFacade");
        assertEquals(usuariosFacade.login("karengo@gamil.com", "1234567"), true);
    }
}
