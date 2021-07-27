package com.example.pruebatecnica.app.service.mappers.config;


import com.example.pruebatecnica.app.dao.dataModel.product.ProductDto;
import com.example.pruebatecnica.app.dao.dataModel.user.UserDto;
import com.example.pruebatecnica.app.dao.models.Product;
import com.example.pruebatecnica.app.dao.models.UserApp;
import com.example.pruebatecnica.app.service.mappers.product.ProductToProductDtoMapper;
import com.example.pruebatecnica.app.service.mappers.user.UserToUserDtoMapper;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class OrikaMaperConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {

        orikaMapperFactory.classMap(Product.class, ProductDto.class)
                .customize(new ProductToProductDtoMapper()).
                register();

        orikaMapperFactory.classMap(UserApp.class, UserDto.class)
                .customize(new UserToUserDtoMapper())
                .register();
    }
}
