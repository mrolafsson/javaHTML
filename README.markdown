# javaHTML
javaHTML is a Java library for efficiently writing valid HTML using a fluid api. It's more readable and less error prone than string concatenation (or manually writing to stream).

### Example

	html().with(
	        head().with(
	                meta(attr("charset", "UTF-8"))
	        ),
	        body().with(
	                h1().with("Hello world!")
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
	        ol().with(
	                li().with("Groucho"),
	                li().with("Zeppo")
	        ).validate();
	    }
	}

### Tag Libraries
If you're using `SimpleTagSupport` then extend `HtmlSimpleTagSupport` and implement `doTagHtml()` as you would normally have done in `doTag()`:

	public static class MarxTag extends HtmlSimpleTagSupport {

	    @Override
	    public void doTagHtml() throws JspException, IOException {
	        ol().with(
	                li().with("Groucho"),
	                li().with("Zeppo")
	        ).validate();
	    }
	}
	
### Do It Yourself method
Use the `Create` class and either use the default `toString()` method or pass in your own `Writer` in the constructor.

	new Create() {
    	@Override
	    public void markup() throws IOException {
        	div().with("Hello world!");
    	}
	}.toString();
	
## Generating HTML

### Tags

##### Validate
It's good policy to call `validate()` at the end of the HTML generation to make sure all tags were properly closed.

#### Container Tags
If they do not contain elements in the body (added using `with()` method) you must call `close()` at the end.

### Iteration

### Custom Code