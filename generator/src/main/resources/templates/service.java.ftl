package ${package.Service};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${superServiceClassPackage};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * @author ${author}
 * @since ${date}
 */
@Service
public class ${table.serviceName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${superServiceClass}<${entity}> {

}
