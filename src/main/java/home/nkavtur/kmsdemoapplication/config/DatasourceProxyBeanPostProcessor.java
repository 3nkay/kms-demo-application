package home.nkavtur.kmsdemoapplication.config;

import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatasourceProxyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            HikariDataSource dataSourceBean = (HikariDataSource) bean;
            return ProxyDataSourceBuilder.create(dataSourceBean)
                    .logQueryBySlf4j(SLF4JLogLevel.INFO)
                    .build();
        }
        return bean;
    }
}
