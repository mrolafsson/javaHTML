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

#### Container Tags
Most of the tags are not self-closing and can contain other elements. These are added by passing them to the `with()` method:

	ol().with(
		li().with("Groucho"),
		li().with("Zeppo")
	);
	
Important: If no elements are added to the body of the tag(added using `with()` method) you must call `close()` at the end.

	ol( cls("empty-list") ).close();

##### Validate
It's good policy to call `validate()` at the end of the HTML generation to make sure all tags were properly closed.

	ol().with(
		li().with("Groucho"),
		li().with("Zeppo")
	).validate();
	
Failure to close elements or otherwise invalid markup will be logged out at a `warn` level.

#### Missing or Custom Tags?
You can add any tag or element using the `custom()` method:

	custom("blink").with("Las Vegas Baby!");

Would generate:
	
`<blink>Las Vegas Baby</blink>`
	
You can add attributes to custom tags like any other:

	custom("strong", style("background-color: red;")).with("Rocky!");
	
Would generate:

`<strong style="background-color: red;">Rocky!</strong>`
	
#### Attributes
You can add attributes to the HTML tags by declaring them as formal parameters to the tag methods:

	h1( id("foo"), cls("bar", "zip") )
	
You will find these shorthand attributes for the more common types but any attribute can be declared using the `attr("name", "value")` expression:

	a( href("#foo"), target("_blank"), attr("onclick", "doSomething();") );

### Conditionals
You can conditionally output data using a `when()` expression:

	div().with(
	    when( Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 11 ).use(
			h1().with("Good morning!")
	    ).otherwise(
			h2().with("Hello!")
	    )
	);

### Iteration
You can add iteration inline using the `iterate()` method and a `Loop` implementation:

	ol().with(
	    iterate(new Loop<String>("Groucho", "Zeppo") {
	        @Override
	        public void each(String brother) throws Exception {
	            li().with(brother);
	        }
	    })
	);

The `Loop` class is parameterised and instantiated with a `Collection` or varargs and the `each()` method is invoked for each item in the list.

An `iterate()` behaves just like any other content which means you can add other elements to the same container:

	dl().with(
	    dt().with(
			text("Fibonacci")
	    ),
	    iterate(new Loop<Integer>(0, 1, 1, 2, 3, 5, 8) {
	        @Override
	        public void each(Integer fib) throws Exception {
	            dd().with(text(fib));
	        }
	    })
	);

### Custom Code
You can execute any code inline using the `exec()` method and passing it an instance of `Code` where you implement the `run()` method:

	final Random random = new Random();
	h1().with(
	    text("Tom "),
	    exec(new Code() {
	        @Override
	        public void run() throws JspException, IOException {
	            if (random.nextBoolean()) {
	                em().with("hates");
	            } else {
	                span().with("likes");
	            }
	        }
	    }),
	    text(" Jerry")
	);
	
If you use the `exec()` method in a `when()` conditional block it will only execute if the condition was met.