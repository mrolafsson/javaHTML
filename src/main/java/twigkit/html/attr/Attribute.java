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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author mr.olafsson
 */
public class Attribute {

    private static final String CLASS = "class", ID = "id", DATA = "data-", HREF = "href", SRC = "src", TARGET = "target";
    private static final String SPACE = " ", QUOTE = "\"", EQUALS = "=";

    private final String name;
    private final List<String> values;

    public Attribute(String name, String... values) {
        this.name = name;
        this.values = new ArrayList<String>();
        for (String value : values) {
            if (value != null) {
                this.values.add(value);
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
            if (attributes[i].values != null && attributes[i].values.size() > 0) {
                writer.write(SPACE);
                attributes[i].write(writer);
            }
        }
    }

    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        try {
            write(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static class Css extends Attribute {
        public Css(String... values) {
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
}
