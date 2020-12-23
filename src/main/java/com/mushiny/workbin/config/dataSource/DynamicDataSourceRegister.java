package com.mushiny.workbin.config.dataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *  动态数据源注册
 *  启动动态数据源请在启动类中 添加 @Import(DynamicDataSourceRegister.class)
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    //主数据源
    private DataSource defaultDataSource;
    //其它数据源
    private Map<String, DataSource> customDataSources = new HashMap<>();
    //数据源名称集合
    private static String DB_NAME = "names";
    //数据源前缀
    private static String DB_DEFAULT_VALUE = "spring.datasource";
    //默认数据源
    private static String DB_DEFAULT_NAME = "defaultname";
    //采用springboot2.0默认连接池(如果不写取默认值)
    private static String DB_DEFAULT_TYPE = "com.zaxxer.hikari.HikariDataSource";

    /**
     * 加载多数据源配置
     */
    @Override
    public void setEnvironment(Environment env) {
        initDefaultDataSource(env);
        initCustomDataSources(env);
    }

    /**
     * 初始化主数据源
     */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        Map<String, Object> dsMap = new HashMap<>();
        //支持不写默认数据源取默认
        String dsPrefixs = (env.getProperty(DB_DEFAULT_VALUE + "." + DB_DEFAULT_NAME) == null ?
                "" : "."+env.getProperty(DB_DEFAULT_VALUE + "." + DB_DEFAULT_NAME));
        dsMap.put("type", env.getProperty(DB_DEFAULT_VALUE + dsPrefixs + ".type"));
        dsMap.put("driver-class-name", env.getProperty(DB_DEFAULT_VALUE + dsPrefixs+ ".driver-class-name"));
        dsMap.put("url", env.getProperty(DB_DEFAULT_VALUE + dsPrefixs + ".url"));
        dsMap.put("username", env.getProperty(DB_DEFAULT_VALUE + dsPrefixs + ".username"));
        dsMap.put("password", env.getProperty(DB_DEFAULT_VALUE + dsPrefixs + ".password"));
        defaultDataSource = buildDataSource(dsMap);
    }


    /**
     * 初始化多数据源
     * @param env
     */
    private void initCustomDataSources(Environment env) {
        String dsPrefixs = env.getProperty(DB_DEFAULT_VALUE + "." + DB_NAME);
        if(dsPrefixs !=null && !dsPrefixs.equals("")) {
            for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
                Map<String, Object> dsMap = new HashMap<>();
                dsMap.put("type", env.getProperty(DB_DEFAULT_VALUE + "." + dsPrefix + "." + "type"));
                dsMap.put("driver-class-name", env.getProperty(DB_DEFAULT_VALUE + "." + dsPrefix + "." + "driver-class-name"));
                dsMap.put("url", env.getProperty(DB_DEFAULT_VALUE + "." + dsPrefix + "." + "url"));
                dsMap.put("username", env.getProperty(DB_DEFAULT_VALUE + "." + dsPrefix + "." + "username"));
                dsMap.put("password", env.getProperty(DB_DEFAULT_VALUE + "." + dsPrefix + "." + "password"));
                DataSource ds = buildDataSource(dsMap);
                customDataSources.put(dsPrefix, ds);
            }
        }
    }

    /**
     * 注册
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
        logger.info("Dynamic DataSource Registry");
    }

    /**
     * 创建DataSource
     * @param dsMap
     * @return
     */
    @SuppressWarnings("unchecked")
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        try {
            Object type = dsMap.get("type");
            if (type == null) {
                type = DB_DEFAULT_TYPE;
            }
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dsMap.get("driver-class-name").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder<? extends DataSource> factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
        	logger.error(e.getMessage());
        }
        return null;
    }
}
