package com.bookeyman.store.service.mappers.impl;

import com.bookeyman.store.service.mappers.ConverterService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

    private final ConversionService conversionService;

    public ConverterServiceImpl(@Qualifier("mvcConversionService") ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetClass) {
        return conversionService.convert(source, targetClass);
    }
}
