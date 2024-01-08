package kr.co.seoulit.erp.logistic.production.mapStruct;

import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;
import kr.co.seoulit.erp.logistic.production.domain.MrpGatheringDTO;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@ComponentScan
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MrpGatheringMapper {

    MrpGatheringDTO toDto(MrpGathering mrpGathering);
    MrpGathering toEntity(MrpGatheringDTO mrpGatheringDTO);

    List<MrpGatheringDTO> toDtoList(List<MrpGathering> mrpGatheringList);
}
