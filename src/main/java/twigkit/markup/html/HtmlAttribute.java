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
package twigkit.markup.html;

/**
 * Represents an element attribute on a tag.
 *
 * @author mr.olafsson
 */
public class HtmlAttribute extends twigkit.markup.Attribute {

    private static final String CLASS = "class", ID = "id", DATA = "data-", HREF = "href", SRC = "src",
            TARGET = "target", TITLE = "title", WIDTH = "width", HEIGHT = "height", STYLE = "style";

    public HtmlAttribute(String name, Object... values) {
        super(name, values);
    }

    public static class Class extends HtmlAttribute {
        public Class(String... values) {
            super(CLASS, values);
        }
    }

    public static class Id extends HtmlAttribute {
        public Id(String id) {
            super(ID, id);
        }
    }

    public static class Data extends HtmlAttribute {
        public Data(String name, String value) {
            super(DATA + name, value);
        }
    }

    public static class Href extends HtmlAttribute {
        public Href(String value) {
            super(HREF, value);
        }
    }

    public static class Src extends HtmlAttribute {
        public Src(String value) {
            super(SRC, value);
        }
    }

    public static class Target extends HtmlAttribute {
        public Target(String value) {
            super(TARGET, value);
        }
    }

    public static class Title extends HtmlAttribute {
        public Title(String value) {
            super(TITLE, value);
        }
    }

    public static class Style extends HtmlAttribute {
        public Style(String value) {
            super(STYLE, value);
        }
    }

    public static class Width extends HtmlAttribute {
        public Width(int value) {
            super(WIDTH, value > -1 ? value : null);
        }
    }

    public static class Height extends HtmlAttribute {
        public Height(int value) {
            super(HEIGHT, value > -1 ? value : null);
        }
    }
}
