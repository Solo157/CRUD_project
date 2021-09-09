package com.vasyukovkirill.myproject.mappers;

import com.vasyukovkirill.myproject.dto.NotebooksDTO;
import com.vasyukovkirill.myproject.entity.Notebooks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NotebooksMapper {
    NotebooksMapper INSTANCE = Mappers.getMapper(NotebooksMapper.class);

    @Mapping(target = "lastChange", ignore = true)
    @Mapping(target = "usersId", ignore = true)
    Notebooks toNotebooksEntity(NotebooksDTO notebooksDTO);

    NotebooksDTO toNotebooksDTO(Notebooks notebooks);

    @Mapping(target = "lastChange", ignore = true)
    List<Notebooks> toNotebooksEntities(List<NotebooksDTO> notebooksDTOList);
}
