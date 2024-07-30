package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarService;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          Model model) {
        if (count == null) {
            model.addAttribute("cars", carService.index());
            return "cars";
        } else {
            if (count >= carService.index().size()) {
                model.addAttribute("cars", carService.index());
                return "cars";
            }
            model.addAttribute("cars", carService.getCarList(count));
        }
        return "cars";
    }

}
