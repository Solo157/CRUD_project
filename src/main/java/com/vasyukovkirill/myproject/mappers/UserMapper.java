package com.vasyukovkirill.myproject.mappers;

import com.vasyukovkirill.myproject.dto.DetailDTO;
import com.vasyukovkirill.myproject.dto.UserDTO;
import com.vasyukovkirill.myproject.entity.Detail;
import com.vasyukovkirill.myproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "surName", target = "surname")
    UserDTO toUserDTO(User user);

    @Mapping(target = "deactivated", ignore = true)
    @Mapping(target = "lastChange", ignore = true)
    @Mapping(source = "surname", target = "surName")
    User toUserEntity(UserDTO userDTO);

    default Detail toDetailEntity(DetailDTO detailDTO) {
        return DetailMapper.INSTANCE.toDetailEntity(detailDTO);
    }
    default DetailDTO toDetailDTO(Detail detail) {
        return DetailMapper.INSTANCE.toDetailDTO(detail);
    }

    @Mapping(source = "surName", target = "surname")
    List<UserDTO> toUserDTOs(List<User> users);

    @Mapping(target = "deactivated", ignore = true)
    @Mapping(target = "lastChange", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "surname", target = "surName")
    public abstract void merge(@MappingTarget User target, UserDTO source);

}
