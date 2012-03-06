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

/**
 * @author mr.olafsson
 */
public class Attribute {

    private static final String CLASS = "class", ID = "id", DATA = "data-";
    private static final String SPACE = " ", QUOTE = "\"", EQUALS = "=";

    private final String name;
    private final String[] values;

    public Attribute(String name, String... values) {
        this.name = name;
        this.values = values;
    }

    public void write(Writer writer) throws IOException {
        if (values != null && values.length > 0) {
            writer.write(name);
            writer.write(EQUALS);
            writer.write(QUOTE);
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    writer.write(SPACE);
                }
                writer.write(values[i]);
            }
            writer.write("\"");
        }
    }

    public static void write(Writer writer, Attribute... attributes) throws IOException {
        for (int i = 0; i < attributes.length; i++) {
            writer.write(SPACE);
            attributes[i].write(writer);
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
}
