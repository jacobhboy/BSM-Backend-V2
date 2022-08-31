package bssm.bsm.domain.school.meal;

import bssm.bsm.domain.school.meal.dto.response.MealResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("{date}")
    public MealResponseDto getMeal(@PathVariable @DateTimeFormat(pattern = "yyMMdd") LocalDate date) {
        return mealService.getMeal(date);
    }
}
