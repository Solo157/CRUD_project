package com.vasyukovkirill.myproject.mappers;


import com.vasyukovkirill.myproject.dto.DetailDTO;
import com.vasyukovkirill.myproject.entity.Detail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DetailMapper {
    DetailMapper INSTANCE = Mappers.getMapper(DetailMapper.class);

    @Mapping(target = "lastChange", ignore = true)
    Detail toDetailEntity(DetailDTO detailDTO);

    DetailDTO toDetailDTO(Detail detail);

}
