package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setId(entity.getId());
        billDTO.setUuid(entity.getUuid());
        billDTO.setBillNo(entity.getBillNo());
        billDTO.setCreationDate(entity.getCreationDate());
        billDTO.setUpdatedDate(entity.getUpdatedDate());
        billDTO.setTaxAmount(entity.getTaxAmount());
        billDTO.setTaxRate(entity.getTaxRate());
        billDTO.setTotalSellPrice(entity.getTotalSellPrice());
        billDTO.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        billDTO.setBillDate(entity.getBillDate());
        billDTO.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        return billDTO;
    }


    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setBillNo(dto.getBillNo());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setBillDate(dto.getBillDate());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> billDTOList = new ArrayList<>();

        for (BillEntity billEntity : billEntities ){
            billDTOList.add(entityToDTO(billEntity));
        }

        return billDTOList;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> billEntityList = new ArrayList<>();

        for (BillDTO billDTO : billDTOS){
            billEntityList.add(dtoToEntity(billDTO));
        }

        return billEntityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setBillNo(dto.getBillNo());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setBillDate(dto.getBillDate());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return entity;
    }

    public BillEntity updateEntityFromRequestDTO(BillEntity entity, BillRequestDTO dto) {
        entity.setUuid(dto.getUuid());
        entity.setBillNo(dto.getBillNo());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setBillDate(dto.getBillDate());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return entity;
    }
}
