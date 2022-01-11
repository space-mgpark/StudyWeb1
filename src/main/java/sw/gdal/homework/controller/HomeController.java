package sw.gdal.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sw.gdal.homework.service.ImageSearchService;
import sw.gdal.homework.domain.SatelliteImageInfo;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final ImageSearchService imageSearchService2;

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
    @GetMapping("/images")
    public String imageList(Model model) {
        List<SatelliteImageInfo> list = imageSearchService2.findAll();
        model.addAttribute("images", list);
        return "images";
    }

    @PostMapping("/images/search")
    @ResponseBody
    public List<SatelliteImageInfo> script(Model model, @RequestParam("search") String search_input, @RequestParam("option") String search_option) {
        List<SatelliteImageInfo> list = imageSearchService2.searchInfo(search_input, search_option);
        model.addAttribute("images", list);
        return list;
    }
}