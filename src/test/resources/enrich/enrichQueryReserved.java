package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.QueryEnricher;

import java.util.List;

@CodePrototype(enrichers = {QueryEnricher.class})
public interface TestReservedPrototype {

    String  ensure();
    String  reference();
    String  get();
    List<String> list();
    List<String>  references();
    String  count();
    String  top();

    String  page();

    String tuple();
    String tuples();
    String prepare();

    String projection();
    String flush();
    String lock();
    String hint();
    String filter();

    String exists();
    String delete();
    String remove();

}