package sw.gdal.homework.service;

import org.springframework.stereotype.Service;
import sw.gdal.homework.domain.SatelliteImageInfo;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageRegistrationJpa {

    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        //파일 경로까지 추출
        String filepath = "C:\\2021_homework\\tiff";
        FileListReader fileDirList = new FileListReader();
        fileDirList.list(filepath);
        File dir = new File(filepath);
        String[] filenames = dir.list();

        GTiffFileInfoReader fileRead = new GTiffFileInfoReader();
        for (int i = 0; i < fileDirList.filelist.toArray().length; i++) {

            fileRead.readFile(fileDirList.filelist.get(i));
            SatelliteImageInfo file = new SatelliteImageInfo();
            file.setFilename(filenames[i]);
            file.setWidth(fileRead.getWidth());
            file.setHeight(fileRead.getHeight());
            file.setOriginLeft(fileRead.getOriginleft());
            file.setOriginTop(fileRead.getOrigintop());
            file.setResolution(fileRead.getResolution());
            file.setBandCounts(fileRead.getBandcounts());
            file.setUnitType(fileRead.getUnitType());
            file.setNoDataValue(fileRead.getNoDataValue());
            file.setProjection(fileRead.getProjection());
            em.persist(file);
        }
    }
}


// 메모
//        @Builder 랑 세트
//        File file = File.builder().id(id).filename("asdfasdf").bandCounts(3)...................build();