package com.betterprojectsfaster.talks.openj9memory.service.impl;

import com.betterprojectsfaster.talks.openj9memory.service.ProductOrderService;
import com.betterprojectsfaster.talks.openj9memory.domain.ProductOrder;
import com.betterprojectsfaster.talks.openj9memory.repository.ProductOrderRepository;
import com.betterprojectsfaster.talks.openj9memory.service.dto.ProductOrderDTO;
import com.betterprojectsfaster.talks.openj9memory.service.mapper.ProductOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProductOrder}.
 */
@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

    private final Logger log = LoggerFactory.getLogger(ProductOrderServiceImpl.class);

    private final ProductOrderRepository productOrderRepository;

    private final ProductOrderMapper productOrderMapper;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, ProductOrderMapper productOrderMapper) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderMapper = productOrderMapper;
    }

    @Override
    public ProductOrderDTO save(ProductOrderDTO productOrderDTO) {
        log.debug("Request to save ProductOrder : {}", productOrderDTO);
        ProductOrder productOrder = productOrderMapper.toEntity(productOrderDTO);
        productOrder = productOrderRepository.save(productOrder);
        return productOrderMapper.toDto(productOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductOrderDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProductOrders");
        return productOrderRepository.findAll(pageable)
            .map(productOrderMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ProductOrderDTO> findOne(Long id) {
        log.debug("Request to get ProductOrder : {}", id);
        return productOrderRepository.findById(id)
            .map(productOrderMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductOrder : {}", id);
        productOrderRepository.deleteById(id);
    }
}
