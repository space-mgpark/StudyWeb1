package sw.gdal.homework.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sw.gdal.homework.domain.SatelliteImageInfo;

import javax.persistence.*;
import java.util.List;


@Repository
//@RequiredArgsConstructor
public class ImageSearchRepository {

    @PersistenceContext
    private EntityManager em;

    public List<SatelliteImageInfo> findAll() {
        return em.createQuery("SELECT m FROM SatelliteImageInfo m", SatelliteImageInfo.class).getResultList();
    }

    public List<SatelliteImageInfo> searchInfo(String search_input, String search_option) {
        return em.createQuery("SELECT m FROM SatelliteImageInfo m WHERE m."+
                search_option+" LIKE '%"+search_input+"%'", SatelliteImageInfo.class).getResultList();
    }
}
