package org.nix.book;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Create by zhangpe0312@qq.com on 2018/4/4.
 * <p>
 * springBoot启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.nix.*")
@EntityScan("org.nix.book.model")
@EnableJpaRepositories("org.nix.book.dao.repositories")
public class Application {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverter() {

        //添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);

        //在转换器中添加配置信息
        //定义一个转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;

        return new HttpMessageConverters(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
