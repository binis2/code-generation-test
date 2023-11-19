package net.binis.codegen.test;

import codegen.deep.Custom1;
import codegen.deep.Custom2;
public class TestDeep {

    public void func(@Custom1 String s, @Custom2 TestDeep t) {
    }

    public void func(@Custom1 String s1, @Custom2 String s2) {
    }

}