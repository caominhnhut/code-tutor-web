package com.vn.green.common.constant;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public class BaseMapper {

    public final static MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    public static <T1, T2> void includeMappingFields(ClassMapBuilder<T1, T2> classMapBuilder, String[] fields) {
        
        for (String field : fields) {
            classMapBuilder.field(field, field);
        }

        classMapBuilder.register();
    }
}
