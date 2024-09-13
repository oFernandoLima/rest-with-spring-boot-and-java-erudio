package br.com.erudio.rest_with_spring_boot_and_java_erudio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.data.vo.v1.PersonVO;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.model.Person;

// import com.github.dozermapper.core.DozerBeanMapperBuilder;
// import com.github.dozermapper.core.Mapper;

public class Mapper {
    
    // private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(Person.class, PersonVO.class)
            .addMapping(src -> src.getId(), PersonVO::setKey);

        mapper.createTypeMap(PersonVO.class, Person.class)
            .addMapping(src -> src.getKey(), Person::setId);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }
    
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
     
}
