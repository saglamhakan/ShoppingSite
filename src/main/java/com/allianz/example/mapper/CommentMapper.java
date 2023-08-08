package com.allianz.example.mapper;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.util.IBaseMapper;
import lombok.Data;

import java.util.List;

@Data
public class CommentMapper implements IBaseMapper<CommentDTO, CommentEntity, CommentRequestDTO> {


    @Override
    public CommentDTO entityToDTO(CommentEntity entity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(entity.getId());
        commentDTO.setUuid(entity.getUuid());
        commentDTO.setCreationDate(entity.getCreationDate());
        commentDTO.setUpdatedDate(entity.getUpdatedDate());

        return commentDTO;
    }

    @Override
    public CommentEntity dtoToEntity(CommentDTO dto) {
        return null;
    }

    @Override
    public List<CommentDTO> entityListToDTOList(List<CommentEntity> commentEntities) {
        return null;
    }

    @Override
    public List<CommentEntity> dtoListTOEntityList(List<CommentDTO> commentDTOS) {
        return null;
    }

    @Override
    public CommentEntity requestDTOToEntity(CommentRequestDTO dto) {
        return null;
    }
}
