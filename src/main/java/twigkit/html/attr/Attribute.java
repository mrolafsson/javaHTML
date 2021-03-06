/*
 * TwigKit
 *
 * Copyright (c) twigkit.com 2012
 *
 * NOTICE: All information contained herein is, and remains the property
 * of TwigKit and its suppliers, if any.
 * The intellectual and technical concepts contained herein are PROPRIETARY
 * to TwigKit and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or COPYRIGHT LAW.
 * Dissemination of this information or reproduction of this material
 * is strictly FORBIDDEN unless prior written permission is obtained
 * from TwigKit.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * All Rights Reserved.
 */
package twigkit.html.attr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an element attribute on a tag.
 *
 * @author mr.olafsson
 */
public class Attribute {

    private static final Logger logger = LoggerFactory.getLogger(Attribute.class);

    private static final String CLASS = "class", ID = "id", DATA = "data-", HREF = "href", SRC = "src",
            TARGET = "target", TITLE = "title", WIDTH = "width", HEIGHT = "height";
    private static final String SPACE = " ", QUOTE = "\"", EQUALS = "=", STYLE = "style";

    private final String name;
    private final List<String> values;

    public Attribute(String name, Object... values) {
        this.name = name;
        this.values = new ArrayList<String>();
        for (Object value : values) {
            if (value != null) {
                this.values.add(value.toString());
            }
        }
    }

    public void write(Writer writer) throws IOException {
        if (values != null && values.size() > 0) {
            writer.write(name);
            writer.write(EQUALS);
            writer.write(QUOTE);
            Iterator<String> v = values.iterator();
            while (v.hasNext()) {
                writer.write(v.next());
                if (v.hasNext()) {
                    writer.write(SPACE);
                }
            }
            writer.write("\"");
        }
    }

    public Attribute add(String value) {
        values.add(value);
        return this;
    }

    public Attribute remove(String value) {
        values.remove(value);
        return this;
    }

    public static void write(Writer writer, Attribute... attributes) throws IOException {
        for (int i = 0; i < attributes.length; i++) {
            if (attributes[i] != null && attributes[i].values != null && attributes[i].values.size() > 0) {
                // Aggregating attribute values for other attributes with the same name
                for (int o = i + 1; o < attributes.length; o++) {
                    // Checking subsequent attributes to see if they're the same as this one
                    if (attributes[o] != null && attributes[o].name.equals(attributes[i].name)) {
                        // Adding all the values from the subsequent attribute to this one
                        attributes[i].values.addAll(attributes[o].values);
                        // Clearing the values of the subsequent one
                        attributes[o] = null;
                    }
                }
                writer.write(SPACE);
                attributes[i].write(writer);
            }
        }
    }

    @Override
    public Attribute clone() {
        return new Attribute(name, values.toArray(new String[values.size()]));
    }

    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        try {
            write(writer);
        } catch (IOException e) {
            logger.error("Failed to write Attribute", e);
        }
        return writer.toString();
    }

    public static class Class extends Attribute {
        public Class(String... values) {
            super(CLASS, values);
        }
    }

    public static class Id extends Attribute {
        public Id(String id) {
            super(ID, id);
        }
    }

    public static class Data extends Attribute {
        public Data(String name, String value) {
            super(DATA + name, value);
        }
    }

    public static class Href extends Attribute {
        public Href(String value) {
            super(HREF, value);
        }
    }

    public static class Src extends Attribute {
        public Src(String value) {
            super(SRC, value);
        }
    }

    public static class Target extends Attribute {
        public Target(String value) {
            super(TARGET, value);
        }
    }

    public static class Title extends Attribute {
        public Title(String value) {
            super(TITLE, value);
        }
    }

    public static class Style extends Attribute {
        public Style(String value) {
            super(STYLE, value);
        }
    }

    public static class Width extends Attribute {
        public Width(int value) {
            super(WIDTH, value > -1 ? value : null);
        }
    }

    public static class Height extends Attribute {
        public Height(int value) {
            super(HEIGHT, value > -1 ? value : null);
        }
    }
}
