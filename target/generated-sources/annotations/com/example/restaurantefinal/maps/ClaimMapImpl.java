package com.example.restaurantefinal.maps;

import com.example.restaurantefinal.dto.ClaimResponseDto;
import com.example.restaurantefinal.entities.Claim;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-28T10:11:49-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class ClaimMapImpl implements ClaimMap {

    @Override
    public ClaimResponseDto transformationClaim(Claim claim) {
        if ( claim == null ) {
            return null;
        }

        ClaimResponseDto claimResponseDto = new ClaimResponseDto();

        claimResponseDto.setId( claim.getId() );
        claimResponseDto.setIdOrder( claim.getIdOrder() );
        claimResponseDto.setCampus( claim.getCampus() );
        claimResponseDto.setReason( claim.getReason() );

        return claimResponseDto;
    }

    @Override
    public List<ClaimResponseDto> transformationListClaim(List<Claim> ListClaim) {
        if ( ListClaim == null ) {
            return null;
        }

        List<ClaimResponseDto> list = new ArrayList<ClaimResponseDto>( ListClaim.size() );
        for ( Claim claim : ListClaim ) {
            list.add( transformationClaim( claim ) );
        }

        return list;
    }
}
