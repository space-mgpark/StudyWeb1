package sw.gdal.homework.service;

import org.gdal.gdal.*;
import org.gdal.gdalconst.gdalconstConstants;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Arrays;

public class GTiffFileInfoReader {
    public String fileName;
    public double width;
    public double height;
    public double originleft;
    public double origintop;
    public double resolution;
    public int bandcounts;
    public String noDataValue;
    public String unitType;
    public String projection;

    public void readFile(String fileName) {
        this.fileName = fileName;
        read(fileName);
    }
    public void read(String file) {
        gdal.AllRegister();
        Dataset sourceDataset = gdal.Open(file, gdalconstConstants.GA_ReadOnly); //데이터셋 객체 생성
        Driver driver = sourceDataset.GetDriver(); //드라이버 객체 생성
        // 오리진 좌표 (upper right)
        double[] gt = new double[6];
        gt = sourceDataset.GetGeoTransform();
        originleft = gt[0];
        origintop = gt[3];
        // 가로 세로 픽셀 갯수
        width = sourceDataset.GetRasterXSize();
        height = sourceDataset.GetRasterYSize();
        // 밴드 갯수
        bandcounts = sourceDataset.GetRasterCount();
        // 프로젝션 정보
//        projection = sourceDataset.GetSpatialRef().toString();
        projection = sourceDataset.GetProjection();
        // 해상도
        resolution = gt[1];
        // 밴드 unit type
        int dataType =sourceDataset.GetRasterBand(1).getDataType();
        unitType = gdal.GetDataTypeName(dataType);
        Band Band1 = sourceDataset.GetRasterBand(1);
        // No Data Value
        Double[] noDataval = new Double[2];
        Band1.GetNoDataValue(noDataval);
        if (!(noDataval[0] == null)){
            noDataValue = noDataval[0].toString();
        } else {
            noDataValue = "null";
        }
    }

    public String getFileName() {
        return fileName;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getOriginleft() {
        return originleft;
    }
    public double getOrigintop() {
        return origintop;
    }
    public double getResolution() {
        return resolution;
    }
    public int getBandcounts() {
        return bandcounts;
    }
    public String getNoDataValue() {
        return noDataValue;
    }
    public String getUnitType() {
        return unitType;
    }
    public String getProjection() {
        return projection;
    }
}
