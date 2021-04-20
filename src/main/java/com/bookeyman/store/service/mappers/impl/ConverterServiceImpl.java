package com.bookeyman.store.service.mappers.impl;

import com.bookeyman.store.service.mappers.ConverterService;
import lombok.AllArgsConstructor;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConverterServiceImpl implements ConverterService {

    private final ConversionService conversionService;

    @Override
    public <T> T convert(Object source, Class<T> targetClass) {
        return conversionService.convert(source, targetClass);
    }
}
