package jcw.camo_server.controller;

import jcw.camo_server.dto.CafeListDto;
import jcw.camo_server.dto.CafeUpdateDto;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.service.CafeService;
import jcw.camo_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    /**
     * cafe 등록
     * @param cafe 등록할 Cafe
     * @return 등록된 Cafe
     */
    @PostMapping("/register")
    public Cafe cafeRegister(@RequestBody Cafe cafe) {
        return cafeService.register(cafe);
    }

    /**
     * Cafe 리스트 조회
     * @return 모든 Cafe 리스트
     */
    @GetMapping("/list")
    public List<CafeListDto> cafeList() {
        return cafeService.cafeList();
    }

    /**
     * Cafe 이름으로 검색
     * @param name 검색어
     * @return 검색어가 이름에 포함된 Cafe 리스트
     */
    @GetMapping("/name/{name}")
    public List<CafeListDto> searchCafeByName(@PathVariable("name") String name) {
        return cafeService.findByName(name);
    }

    /**
     * cafeId로 cafe 정보 조회
     * @param cafeId 정보를 조회할 cafe의 cafeId
     * @return 해당 cafeId를 가진 Cafe
     */
    @GetMapping("/{id}")
    public Cafe cafeInfo(@PathVariable("id") String cafeId) {
        Cafe cafe = cafeService.findById(cafeId);
        log.info("cafe = {}", cafe);
        return cafe;
    }

    /**
     * cafe 정보 수정
     *
     * @param cafeId        수정할 카페의 id
     * @param cafeUpdateDto 수정할 정보
     * @return 정보가 수정된 후 cafe
     */
    @PutMapping("/{id}")
    public Cafe cafeInfoUpdate(@PathVariable("id") String cafeId, @RequestBody CafeUpdateDto cafeUpdateDto) {
        cafeUpdateDto.setCafeId(cafeId);
        return cafeService.cafeUpdate(cafeUpdateDto);
    }

    /**
     * 카페 삭제
     * @param cafeId 삭제할 카페의 cafeId
     */
    @DeleteMapping("/{id}")
    public void deleteCafe(@PathVariable("id") String cafeId) {
        cafeService.cafeDelete(cafeId);
    }
}
