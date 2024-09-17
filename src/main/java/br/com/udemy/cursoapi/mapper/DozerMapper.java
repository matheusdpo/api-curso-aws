package br.com.udemy.cursoapi.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();


    public static <O, D> D parseObj(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObj(List<O> origin, Class<D> destination) {
        List<D> destinationObjList = new ArrayList<>();

        for (O e : origin)
            destinationObjList.add(parseObj(e, destination));

        return destinationObjList;
    }

}