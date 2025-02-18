/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2023 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser.ast.body;

import org.junit.jupiter.api.Test;

import static com.github.javaparser.utils.Utils.SYSTEM_EOL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstructorDeclarationTest {
    @Test
    void acceptsSuper() {
        ConstructorDeclaration cons = new ConstructorDeclaration("Cons");
        cons.createBody().addStatement("super();");

        assertEquals(String.format("public Cons() {%1$s" +
                "    super();%1$s" +
                "}", SYSTEM_EOL), cons.toString());
    }

    @Test
    public void testTypeCastingMethods() {
        ConstructorDeclaration decl = new ConstructorDeclaration();

        assertTrue(decl.isConstructorDeclaration());
        assertEquals(decl, decl.asConstructorDeclaration());
        decl.ifConstructorDeclaration(e -> {
            assertTrue(e instanceof ConstructorDeclaration);
        });

        assertTrue(decl.toConstructorDeclaration().isPresent());
    }
}
