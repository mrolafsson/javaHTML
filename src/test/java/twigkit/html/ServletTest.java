package twigkit.html;

import org.junit.Before;
import org.junit.Test;
import twigkit.html.helper.HtmlHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * @author mr.olafsson
 */
public class ServletTest {

    private FooServlet servlet;

    private HttpServletRequest request;

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
            ol().with(
                    li().with("Groucho"),
                    li().with("Zeppo")
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
