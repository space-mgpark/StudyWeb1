package sw.gdal.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sw.gdal.homework.domain.SatelliteImageInfo;
import sw.gdal.homework.repository.ImageSearchRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageSearchService {

    private final ImageSearchRepository imageSearchRepository;

    public List<SatelliteImageInfo> findAll() {
        return imageSearchRepository.findAll();
    }

    public List<SatelliteImageInfo> searchInfo(String search_input, String search_option) {
        return imageSearchRepository.searchInfo(search_input,search_option);
    }
}
