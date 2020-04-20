package com.domrade.entity.implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "DataFileSource.findAllFileNames", query = "SELECT d.fileName FROM DataFileSource d")
    ,@NamedQuery(name = "DataFileSource.getFileByName", query = "SELECT d.fileName FROM DataFileSource d "
            + "WHERE d.fileName = :param1 AND d.fileLocation = :param2")})
@Entity
@Table(name = "data_file_source")
public class DataFileSource implements Serializable {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_location")
    private String fileLocation;

    public DataFileSource() {
        // TODO Auto-generated constructor stub                
    }

    public long getId() {
    return id;
    }
    
    public void setId(Long id) {
    this.id = id;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.setId(new Long(fileName.hashCode()));
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

}
