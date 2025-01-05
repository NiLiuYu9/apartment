package com.n.lease.web.admin.custom.converter;

import com.n.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

//解决前端参数转换枚举类问题，springmvc自己传入targetType.class
//将string类型通过code转换成枚举类型的对象
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    //返回转换器对象
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
                T[] enumConstants = targetType.getEnumConstants();//获取所有枚举实例
                //循环比较传入code是否等于其中一个枚举实例的code
//                如果相等则返回那个枚举实例
                for (T enumConstant : enumConstants) {
                    if (enumConstant.getCode().equals(Integer.valueOf(code))){
                        return enumConstant;
                    }
                }
                //否则抛异常
                throw new IllegalArgumentException("code"+code+"非法");
            }
        };
    }
}
