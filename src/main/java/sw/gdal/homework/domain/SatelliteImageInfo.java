package sw.gdal.homework.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="TIFF_INFO_TB")
@SequenceGenerator(
        name = "ID_SEQ_GENERATOR",
        sequenceName = "ID_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class SatelliteImageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ_GENERATOR")
    @Column(name="ID_SQ", unique = true, nullable = false)
    private int id;
    @Column(name="FILE_NM")
    private String filename;
    @Column(name="WIDTH_NO")
    private double width;
    @Column(name="HEIGHT_NO")
    private double height;
    @Column(name="ORIGINLEFT_NO")
    private double originLeft;
    @Column(name="ORIGINTOP_NO")
    private double originTop;
    @Column(name="RESOLUTION_NO")
    private double resolution;
    @Column(name="BANDCOUNTS_CNT")
    private int bandCounts;
    @Column(name="UNITTYPE")
    private String unitType;
    @Column(name="NODATAVALUE")
    private String noDataValue;
    @Column(name="PROJECTION")
    private String projection;

//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//    public void setHeight(double height) {
//        this.height = height;
//    }
//
//    public double getOriginLeft() {
//        return originLeft;
//    }
//    public void setOriginLeft(double originLeft) {
//        this.originLeft = originLeft;
//    }
//
//    public double getOriginTop() {
//        return originTop;
//    }
//    public void setOriginTop(double originTop) {
//        this.originTop = originTop;
//    }
//
//    public double getResolution() {
//        return resolution;
//    }
//    public void setResolution(double resolution) {
//        this.resolution = resolution;
//    }
//
//    public int getBandCounts() {
//        return bandCounts;
//    }
//    public void setBandCounts(int bandCounts) {
//        this.bandCounts = bandCounts;
//    }
//
//    public String getUnitType() {
//        return unitType;
//    }
//    public void setUnitType(String unitType) {
//        this.unitType = unitType;
//    }
//
//    public String getNoDataValue() {
//        return noDataValue;
//    }
//    public void setNoDataValue(String noDataValue) {
//        this.noDataValue = noDataValue;
//    }
//
//    public String getProjection() {
//        return projection;
//    }
//    public void setProjection(String projection) {
//        this.projection = projection;
//    }
}
