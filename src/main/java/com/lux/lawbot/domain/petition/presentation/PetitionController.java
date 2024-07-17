package com.lux.lawbot.domain.petition.presentation;

import com.lux.lawbot.domain.petition.payload.request.PetitionDto;
import com.lux.lawbot.domain.petition.service.PetitionService;
import com.lux.lawbot.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "국민청원", description = "국민청원 관련 api 입니다.")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petition")
@RequiredArgsConstructor
public class PetitionController {
    private final PetitionService petitionService;

    @Operation(summary = "청원 리스트", description = "진행중인 청원을 확인합니다.")
    @GetMapping("/list")
    public BaseResponse findAllPetitions(){
        return petitionService.findAllPetitions();
    }

    @Operation(summary = "청원 작성", description = "청원을 작성합니다.")
    @PostMapping("/create")
    public BaseResponse petitionCreate(@RequestBody PetitionDto petitionDto){
        return petitionService.petitionCreate(petitionDto);
    }

    @Operation(summary = "선택한 청원 단일 조회", description = "선택한 청원의 내용 확인합니다.")
    @GetMapping("/detail/{id}")
    public BaseResponse petitionRead(@PathVariable("id") Long id){
        return petitionService.petitionRead(id);
    }
}