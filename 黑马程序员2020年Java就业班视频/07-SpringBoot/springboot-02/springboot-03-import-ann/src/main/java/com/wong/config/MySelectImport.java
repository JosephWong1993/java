package com.wong.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 批量导入对象到容器的类
 */
public class MySelectImport implements ImportSelector {
    /**
     * 返回需要导入Spring容器中的所有的对象全限定名称
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] strings = new String[]{
                "com.wong.service.UserServiceImpl",
                "com.wong.pojo.User"
        };
        return strings;
    }
}
