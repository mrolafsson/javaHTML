package twigkit.html;

import atunit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import twigkit.html.helper.HtmlHttpServlet;
import twigkit.html.helper.HtmlSimpleTagSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

/**
 * @author mr.olafsson
 */
@RunWith(AtUnit.class)
@MockFramework(MockFramework.Option.EASYMOCK)
public class ServletTest {

    @Unit
    private FooServlet servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        request = createMock(HttpServletRequest.class);
        replay(request);

    }

    @Test
    public void testServlet() throws Exception {
        StringWriter writer = new StringWriter();

        response = createMock(HttpServletResponse.class);
        expect(response.getWriter()).andReturn(new PrintWriter(writer)).anyTimes();
        replay(response);

        servlet = new FooServlet();
        servlet.doGet(request, response);

        assertEquals("<ol><li>Groucho</li><li>Zeppo</li></ol>", writer.toString());
    }

    public static class FooServlet extends HtmlHttpServlet {

        @Override
        protected void doGetHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ol().body(
                    li().body("Groucho"),
                    li().body("Zeppo")
            ).validate();
        }

        /**
         * Overriding for the test so that we can call the {@link javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
         * method on the parent which has protected access.
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doGet(req, resp);
        }
    }
}
