# javaHTML
javaHTML is a Java library for efficiently writing valid HTML using a fluid api. It's more readable and less error prone than string concatenation (or manually writing to stream).

### Example

	html().body(
	        head().body(
	                meta(attr("charset", "UTF-8"))
	        ),
	        body().body(
	                h1().body("Hello world!")
	        )
	).validate();
	
## Installation
Add the javaHTML jar to the class path or include using Maven:

	<dependency>
		<groupId>twigkit</groupId>
	    <artifactId>javaHTML</artifactId>
	    <version>2.0-SNAPSHOT</version>
	</dependency>

## Usage
Simple really, you build your HTML by using one of the helper classes for servlets, custom tags, extend `HtmlCapability` or use the `Create` class.
	
### Servlets
Extend `HtmlHttpServlet` rather than `HttpServlet` and implement the `doGetHtml()` method:
	
	public class MarxServlet extends HtmlHttpServlet {
	    @Override
	    protected void doGetHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        ol().body(
	                li().body("Groucho"),
	                li().body("Zeppo")
	        ).validate();
	    }
	}

### Tag Libraries
If you're using `SimpleTagSupport` then extend `HtmlSimpleTagSupport` and implement `doTagHtml()` as you would normally have done in `doTag()`:

	public static class MarxTag extends HtmlSimpleTagSupport {

	    @Override
	    public void doTagHtml() throws JspException, IOException {
	        ol().body(
	                li().body("Groucho"),
	                li().body("Zeppo")
	        ).validate();
	    }
	}
	
### Do It Yourself method
Use the `Create` class and either use the default `toString()` method or pass in your own `Writer` in the constructor.

	new Create() {
    	@Override
	    public void markup() throws IOException {
        	div().body("Hello world!");
    	}
	}.toString();
	
## Generating HTML

### Tags

### Iteration

### Custom Code