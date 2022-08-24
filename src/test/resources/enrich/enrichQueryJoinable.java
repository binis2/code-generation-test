package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.QueryEnricher;
import net.binis.codegen.spring.annotation.Joinable;

import java.util.List;
import java.util.Map;

@CodePrototype(enrichers = {QueryEnricher.class})
@Joinable
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

    Map<String, TestReservedPrototype> map();

}