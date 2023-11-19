package codegen.deep;

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.compiler.utils.ElementAnnotationUtils;
import net.binis.codegen.enrich.handler.base.BaseEnricher;
import net.binis.codegen.generation.core.interfaces.ElementDescription;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
public class DeepEnricher extends BaseEnricher {

    public void enrichElement(ElementDescription description) {
        if (nonNull(description.getElement())) {
            ElementAnnotationUtils.removeAnnotation(description.getElement(), description.getProperties().getPrototypeAnnotation());
        }
    }
    @Override
    public int order() {
        return 0;
    }

}
